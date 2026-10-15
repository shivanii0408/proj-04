package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shivani
 */
public class CourseBean extends BaseBean {

	private String name;
	private String description;
	private String duration;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setName(rs.getString("name"));
			this.setDuration(rs.getString("duration"));
			this.setDescription(rs.getString("description"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
