package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingBean extends BaseBean {

	private String vehicleNumber;
	private String vehicleType;
	private String entryTime;

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setVehicleNumber(rs.getString("vehicle_number"));
			this.setVehicleType(rs.getString("vehicle_type"));
			this.setEntryTime(rs.getString("entry_time"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.setResultset(rs);
	}

	@Override
	public String getValue() {
		return null;
	}

}
