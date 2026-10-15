package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import in.co.rays.proj4.bean.ParkingBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class ParkingModel extends BaseModel<ParkingBean> {

    @Override
    public long add(ParkingBean bean)
            throws ApplicationException, DuplicateRecordException {

        ParkingBean existbean = findByVehicleNumber(bean.getVehicleNumber());

        if (existbean != null) {
            throw new DuplicateRecordException("Vehicle Number already exists");
        }

        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();

            String sql = "INSERT INTO st_parking "
                    + "(vehicle_number, vehicle_type, entry_time) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getVehicleNumber());
            pstmt.setString(2, bean.getVehicleType());
            pstmt.setString(3, bean.getEntryTime());

            int rows = pstmt.executeUpdate();

            return rows;

        } catch (Exception e) {
            throw new ApplicationException("Error adding parking record: " + e.getMessage());
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    @Override
    public void update(ParkingBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;

        try {
            conn = JDBCDataSource.getConnection();

            String sql = "UPDATE st_parking SET "
                    + "vehicle_type = ?, entry_time = ? "
                    + "WHERE vehicle_number = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getVehicleType());
            pstmt.setString(2, bean.getEntryTime());
            pstmt.setString(3, bean.getVehicleNumber());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new ApplicationException("Error updating parking record: " + e.getMessage());
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    public ParkingBean findByVehicleNumber(String vehicleNumber) {
        return findByUniqueColumn("vehicle_number", vehicleNumber);
    }

    @Override
    public String getWhereClause(ParkingBean bean) {
        StringBuffer sql = new StringBuffer("");

        if (bean != null) {

            if (bean.getVehicleNumber() != null
                    && !bean.getVehicleNumber().trim().isEmpty()) {
                sql.append(" and vehicle_number = '")
                   .append(bean.getVehicleNumber()).append("'");
            }

            if (bean.getVehicleType() != null
                    && !bean.getVehicleType().trim().isEmpty()) {
                sql.append(" and vehicle_type like '")
                   .append(bean.getVehicleType()).append("%'");
            }

            if (bean.getEntryTime() != null
                    && !bean.getEntryTime().trim().isEmpty()) {
                sql.append(" and entry_time like '")
                   .append(bean.getEntryTime()).append("%'");
            }
        }

        return sql.toString();
    }

    @Override
    public String getTable() {
        return "st_parking";
    }

    @Override
    public ParkingBean getBean() {
        return new ParkingBean();
    }
}