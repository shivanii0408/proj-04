package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.RestaurantBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class RestaurantModel extends BaseModel<RestaurantBean> {

	@Override
	public long add(RestaurantBean bean) throws ApplicationException, DuplicateRecordException {

		RestaurantBean existbean = findByItemId(bean.getItemId());

		if (existbean != null) {
			throw new DuplicateRecordException("Item Id already exists");
		}

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO st_restaurant "
					+ "(item_id, item_name, category, price, is_available) " + "VALUES (?, ?, ?, ?, ?)");

			pstmt.setString(1, bean.getItemId());
			pstmt.setString(2, bean.getItemName());
			pstmt.setString(3, bean.getCategory());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setString(5, String.valueOf(bean.isAvailable()));

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
	public void update(RestaurantBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set item_id = ?,item_name = ?,category = ?,price = ?,is_available = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getItemId());
			pstmt.setString(2, bean.getItemName());
			pstmt.setString(3, bean.getCategory());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setBoolean(5, bean.isAvailable());
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

	public RestaurantBean findByItemId(String itemId) {

		RestaurantBean bean = findByUniqueColumn("item_id", itemId);

		return bean;

	}

	@Override
	public String getWhereClause(RestaurantBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getItemId() != null && bean.getItemId().length() > 0) {
				sql.append(" and item_id = '" + bean.getItemId() + "'");
			}

			if (bean.getItemName() != null && bean.getItemName().length() > 0) {
				sql.append(" and item_name like '" + bean.getItemName() + "%'");
			}

			if (bean.getCategory() != null && bean.getCategory().length() > 0) {
				sql.append(" and category like '" + bean.getCategory() + "%'");
			}

			if (bean.getPrice() > 0) {
				sql.append(" and price like '" + bean.getPrice() + "%'");
			}

			if (bean.isAvailable()) {
				sql.append(" and is_available = " + bean.isAvailable());
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_restaurant";
	}

	@Override
	public RestaurantBean getBean() {
		return new RestaurantBean();
	}

}
