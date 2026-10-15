package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Shivani
 */
public abstract class BaseBean implements DropdownListBean {

	protected long id;
	protected String createdBy;
	protected String modifiedBy; 
	protected Timestamp createdDateTime; // Timestamp has = data time minute second
	protected Timestamp modifiedDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public void setResultset(ResultSet rs) {
		try {
			this.setId(rs.getLong("ID")); //Database ke ResultSet se ID lo aur current Bean object ke id variable me store karo.
			this.setCreatedBy(rs.getString("CREATED_BY"));
			this.setModifiedBy(rs.getString("MODIFIED_BY"));
			this.setCreatedDateTime(rs.getTimestamp("CREATED_DATETIME"));
			this.setModifiedDateTime(rs.getTimestamp("MODIFIED_DATETIME"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getKey() {
		return id+"";
	}

}
