package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Shivani
 */
public class StudentBean extends BaseBean {

	private String firstName;
	private String lastName;
	private Date dob;
	
	private String mobileNo;
	private String email;
	private int collegeId;
	private String collegeName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+ lastName;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setFirstName(rs.getString("first_name"));
			this.setLastName(rs.getString("last_name"));
			this.setDob(rs.getDate("date_of_birth"));
			this.setMobileNo(rs.getString("mobile_no"));
			this.setEmail(rs.getString("email"));
			this.setCollegeId(rs.getInt("college_id"));
			this.setCollegeName(rs.getString("college_name"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
