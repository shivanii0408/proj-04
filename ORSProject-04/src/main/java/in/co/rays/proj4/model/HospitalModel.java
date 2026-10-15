
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.proj4.bean.HospitalBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.util.JDBCDataSource;

public class HospitalModel extends BaseModel<HospitalBean> {

	@Override
	public long add(HospitalBean bean) throws ApplicationException {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO st_hospital "
					+ "(patientId, name, age, blood_group, disease) " + "VALUES (?, ?, ?, ?, ?)");

			pstmt.setString(1, bean.getPatientId());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getBloodGroup());
			pstmt.setString(5, bean.getDisease());

			System.out.println("Blood Group: " + bean.getBloodGroup());
			pstmt.executeUpdate();

			conn.commit();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return 0;
	}

	@Override
	public void update(HospitalBean bean) throws ApplicationException {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE st_hospital SET name=?, age=?, blood_group=?, disease=? " + "WHERE patientId=?");

			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getAge());
			pstmt.setString(3, bean.getBloodGroup());
			pstmt.setString(4, bean.getDisease());
			pstmt.setString(5, bean.getPatientId());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public HospitalBean findByPatientId(String patientId) {
		Connection conn = null;
		HospitalBean bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT patientId, name, age, blood_group, disease " + "FROM st_hospital WHERE patientId=?");

			pstmt.setString(1, patientId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = new HospitalBean();
				bean.setResultset(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}

	@Override
	public String getWhereClause(HospitalBean bean) {
		StringBuilder sql = new StringBuilder();

		if (bean != null) {
			if (bean.getPatientId() != null && !bean.getPatientId().trim().isEmpty()) {
				sql.append(" AND patientId = '").append(bean.getPatientId().trim()).append("'");
			}

			if (bean.getName() != null && !bean.getName().trim().isEmpty()) {
				sql.append(" AND name LIKE '").append(bean.getName().trim()).append("%'");
			}

			if (bean.getAge() > 0) {
				sql.append(" AND age = ").append(bean.getAge());
			}

			if (bean.getBloodGroup() != null && !bean.getBloodGroup().trim().isEmpty()) {
				sql.append(" AND blood_group LIKE '").append(bean.getBloodGroup().trim()).append("%'");
			}

			if (bean.getDisease() != null && !bean.getDisease().trim().isEmpty()) {
				sql.append(" AND disease LIKE '").append(bean.getDisease().trim()).append("%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_hospital";
	}

	@Override
	public HospitalBean getBean() {
		return new HospitalBean();
	}
}
