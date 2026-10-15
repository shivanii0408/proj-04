package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shivani
 */
public class CollegeBean extends BaseBean {

	private String name;
	private String address;
	private String state;
	private String city;
	private String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setName(rs.getString("name"));
			this.setAddress(rs.getString("address"));
			this.setState(rs.getString("state"));
			this.setCity(rs.getString("city"));
			this.setPhoneNo(rs.getString("phone_no"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.setResultset(rs);
	}

	@Override
	public String getValue() {

		return name;
	}

}
