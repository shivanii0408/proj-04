package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class GymModel extends BaseModel<GymBean> {

	@Override
	public long add(GymBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		GymBean existbean = findByMemberId(bean.getMemberId());

		if (existbean != null) {
			throw new DuplicateRecordException("Member Id already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getMemberId());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getMembershipType());
			pstmt.setString(5, bean.getJoiningDate());
			pstmt.setString(6, bean.getTrainerName());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDateTime());
			pstmt.setTimestamp(10, bean.getModifiedDateTime());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean.getId();
	}

	@Override
	public void update(GymBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set member_id = ?,name = ?,membership_type = ?,joining_date = ?, trainer_name = ?, modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getMemberId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getMembershipType());
			pstmt.setString(4, bean.getJoiningDate());
			pstmt.setString(5, bean.getTrainerName());
//			pstmt.setString(6, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
//			pstmt.setTimestamp(8, bean.getCreatedDateTime());
			pstmt.setTimestamp(7, bean.getModifiedDateTime());
			pstmt.setLong(8, bean.getId());

			pstmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public GymBean findByMemberId(String memberId) {

		GymBean bean = findByUniqueColumn("member_id", memberId);

		return bean;

	}

	@Override
	public String getWhereClause(GymBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getMemberId() != null && bean.getMemberId().length() > 0) {
				sql.append(" and member_id = " + bean.getMemberId());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}

			if (bean.getMembershipType() != null && bean.getMembershipType().length() > 0) {
				sql.append(" and membership_type like '" + bean.getMembershipType() + "%'");
			}

			if (bean.getJoiningDate() != null && bean.getJoiningDate().length() > 0) {
				sql.append(" and joining_date = '" + bean.getJoiningDate() + "'");
			}

			if (bean.getTrainerName() != null && bean.getTrainerName().length() > 0) {
				sql.append(" and trainer_name like '" + bean.getTrainerName() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "gym_member";
	}

	@Override
	public GymBean getBean() {
		return new GymBean();
	}

}
