package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GymBean extends BaseBean {

	private long id;
	private String memberId;
	private String name;
	private String membershipType;
	private String joiningDate;
	private String trainerName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setMemberId(rs.getString("member_id"));
			this.setName(rs.getString("name"));
			this.setMembershipType(rs.getString("membership_type"));
			this.setJoiningDate(rs.getString("joining_date"));
			this.setTrainerName(rs.getString("trainer_name"));

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
