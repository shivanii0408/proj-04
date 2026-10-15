package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Shivani
 */
public class SubjectBean extends BaseBean {

	
	private String name;
	private String description;
	private long courseId;
	
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

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setName(rs.getString("name"));
			this.setDescription(rs.getString("description"));
			this.setCourseId(rs.getLong("course_id"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getValue() {
		return name;
	}

}
