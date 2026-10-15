
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.co.rays.proj4.bean.HospitalBean;
import in.co.rays.proj4.bean.MovieBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class MovieModel extends BaseModel<MovieBean> {

	@Override
	public long add(MovieBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;

		MovieBean existbean = findByMovieId(bean.getMovieId());

		if (existbean != null) {
			throw new DuplicateRecordException("Movie Id already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO st_movie " + "(movie_id, title, genre, duration, rating) " + "VALUES (?, ?, ?, ?, ?)");

			pstmt.setString(1, bean.getMovieId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getGenre());
			pstmt.setInt(4, bean.getDuration());
			pstmt.setDouble(5, bean.getRating());

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
	public void update(MovieBean bean) throws ApplicationException, DuplicateRecordException {
		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update " + getTable()
					+ " set movie_id = ?,title = ?,genre = ?,duration = ?,rating = ?,modified_By = ?,modified_DateTime = ? where id = ?");

			pstmt.setString(1, bean.getMovieId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getGenre());
			pstmt.setInt(4, bean.getDuration());
			pstmt.setDouble(5, bean.getRating());
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

	public MovieBean findByMovieId(String movieId) {

		MovieBean bean = findByUniqueColumn("movie_id", movieId);

		return bean;

	}

	@Override
	public String getWhereClause(MovieBean bean) {
		StringBuffer sql = new StringBuffer("");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getMovieId() != null && bean.getMovieId().length() > 0) {
				sql.append(" and movie_id = '" + bean.getMovieId() + "'");
			}

			if (bean.getTitle() != null && bean.getTitle().length() > 0) {
				sql.append(" and title like '" + bean.getTitle() + "%'");
			}

			if (bean.getGenre() != null && bean.getGenre().length() > 0) {
				sql.append(" and genre like '" + bean.getGenre() + "%'");
			}

			if (bean.getDuration() > 0) {
				sql.append(" and duration like '" + bean.getDuration() + "%'");
			}

			if (bean.getRating() > 0) {
				sql.append(" and rating like '" + bean.getRating() + "%'");
			}

		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_movie";
	}

	@Override
	public MovieBean getBean() {
		return new MovieBean();
	}

}
