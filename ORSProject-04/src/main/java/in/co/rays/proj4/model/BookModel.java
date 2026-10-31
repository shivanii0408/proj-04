package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.BookBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class BookModel extends BaseModel<BookBean> {

	@Override
	public long add(BookBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;
		BookBean existbean = findByIsbnNumber(bean.getIsbnNumber());

		if (existbean != null) {
			throw new DuplicateRecordException("IsbnNumber already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into " + getTable() + " values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getBookName());
			pstmt.setString(3, bean.getAuthor());
			pstmt.setString(4, bean.getCategory());
			pstmt.setString(5, bean.getPublisher());
			pstmt.setString(6, bean.getIsbnNumber());
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
	public void update(BookBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set bank_name = ?,author = ?,category = ?,publisher = ?,isbnNumber = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getBookName());
			pstmt.setString(2, bean.getAuthor());
			pstmt.setString(3, bean.getCategory());
			pstmt.setString(4, bean.getPublisher());
			pstmt.setString(5, bean.getIsbnNumber());
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

	public BookBean findByIsbnNumber(String isbnNumber) {

		BookBean bean = findByUniqueColumn("isbnNumber", isbnNumber);

		return bean;

	}

	@Override
	public String getWhereClause(BookBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getBookName() != null && bean.getBookName().length() > 0) {
			    sql.append(" and book_name like '" + bean.getBookName() + "%'");
			}

			if (bean.getCategory() != null && bean.getCategory().length() > 0) {
				sql.append(" and category like '" + bean.getCategory() + "%'");
			}

			if (bean.getAuthor() != null && bean.getAuthor().length() > 0) {
				sql.append(" and author like '" + bean.getAuthor() + "%'");
			}

			if (bean.getIsbnNumber() != null && bean.getPublisher().length() > 0) {
				sql.append(" and publisher like '" + bean.getPublisher() + "%'");
			}

			if (bean.getIsbnNumber() != null && bean.getIsbnNumber().length() > 0) {
				sql.append(" and isbnNumber like '" + bean.getIsbnNumber() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_book";
	}

	@Override
	public BookBean getBean() {
		return new BookBean();
	}

}