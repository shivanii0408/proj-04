package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.FoodBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class FoodModel extends BaseModel<FoodBean> {

	@Override
	public long add(FoodBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		FoodBean existbean = findByOrderId(bean.getOrderId());

		
		if (existbean != null) {
			throw new DuplicateRecordException("Login Id already exists");
		}

		try {
  
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getOrderId());
			pstmt.setString(3, bean.getCustomerName());
			pstmt.setString(4, bean.getRestaurant());
			pstmt.setDouble(5, bean.getOrderAmount());
			pstmt.setString(6, bean.getDeliveryStatus());
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
	public void update(FoodBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable() 
					+ " set order_id = ?,customer_name = ?,restaurant = ?,order_amount = ?, delivery_status = ?, modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getOrderId());
			pstmt.setString(2, bean.getCustomerName());
			pstmt.setString(3, bean.getRestaurant());
			pstmt.setDouble(4, bean.getOrderAmount());
			pstmt.setString(5, bean.getDeliveryStatus());
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
	
	public FoodBean findByOrderId(String orderId) {

		FoodBean bean = findByUniqueColumn("order_id", orderId);

		return bean;

	}

	@Override
	public String getWhereClause(FoodBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getOrderId() != null && bean.getOrderId().length() > 0) {
				sql.append(" and order_id like '" + bean.getOrderId() + "%'");
			}
			if (bean.getCustomerName() != null && bean.getCustomerName().length() > 0) {
				sql.append(" and customer_name like '" + bean.getCustomerName() + "%'");
			}
			if (bean.getRestaurant() != null && bean.getRestaurant().length() > 0) {
				sql.append(" and restaurant like '" + bean.getRestaurant() + "%'");
			}
			if (bean.getOrderAmount()  > 0) {
				 sql.append(" and order_amount = " + bean.getOrderAmount());
			}
			if (bean.getDeliveryStatus() != null && bean.getDeliveryStatus().length() > 0) {
				sql.append(" and delivery_status like '" + bean.getDeliveryStatus() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_food";
	}

	@Override
	public FoodBean getBean() {
		return new FoodBean();
	}

	

}
