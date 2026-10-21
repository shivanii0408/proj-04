package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.EmailBuilder;
import in.co.rays.proj4.util.EmailMessage;
import in.co.rays.proj4.util.EmailUtility;
import in.co.rays.proj4.util.JDBCDataSource;

public class UserModel extends BaseModel<UserBean> {

	private static Logger log = Logger.getLogger(UserModel.class);

	@Override
	public long add(UserBean bean) throws ApplicationException, DuplicateRecordException {

		log.debug("Entering add() method for login: " + bean.getLogin());

		Connection conn = null;
		UserBean existbean = findByLogin(bean.getLogin());

		if (existbean != null) {
			log.warn("Duplicate login ID found: " + bean.getLogin());
			throw new DuplicateRecordException("Login Id already exists");
		}

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			log.debug("Inserting new user into ST_USER table");

			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO ST_USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setTimestamp(6, new java.sql.Timestamp(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setInt(9, bean.getUnSuccessfulLogin());
			pstmt.setString(10, bean.getGender());
			pstmt.setTimestamp(11, bean.getLastLogin());
			pstmt.setString(12, bean.getLock());
			pstmt.setString(13, bean.getRegisteredIP());
			pstmt.setString(14, bean.getLastLoginIP());
			pstmt.setString(15, bean.getCreatedBy());
			pstmt.setString(16, bean.getModifiedBy());
			pstmt.setTimestamp(17, bean.getCreatedDateTime());
			pstmt.setTimestamp(18, bean.getModifiedDateTime());
			pstmt.setString(19, bean.getPhoto());

			pstmt.executeUpdate();
			conn.commit();

			log.info("User added successfully with login: " + bean.getLogin());

		} catch (SQLException e) {
			log.error("Error while adding user: " + bean.getLogin(), e);
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean.getId();
	}

	@Override
	public void update(UserBean bean) throws ApplicationException, DuplicateRecordException {
 
		log.debug("Entering update() method for user ID: " + bean.getId());

		Connection conn = null;
		UserBean existbean = findByLogin(bean.getLogin());

		if (existbean != null && bean.getId() != existbean.getId()) {
			log.warn("Duplicate login ID found while updating: " + bean.getLogin());
			throw new DuplicateRecordException("LoginId is already exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			log.debug("Updating user details for user ID: " + bean.getId());

			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSFUL_LOGIN=?,GENDER=?,LAST_LOGIN=?,USER_LOCK=?,REGISTERED_IP=?,LAST_LOGIN_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setTimestamp(5, new java.sql.Timestamp(bean.getDob().getTime()));
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setLong(7, bean.getRoleId());
			pstmt.setInt(8, bean.getUnSuccessfulLogin());
			pstmt.setString(9, bean.getGender());
			pstmt.setTimestamp(10, bean.getLastLogin());
			pstmt.setString(11, bean.getLock());
			pstmt.setString(12, bean.getRegisteredIP());
			pstmt.setString(13, bean.getLastLoginIP());
			pstmt.setString(14, bean.getCreatedBy());
			pstmt.setString(15, bean.getModifiedBy());
			pstmt.setTimestamp(16, bean.getCreatedDateTime());
			pstmt.setTimestamp(17, bean.getModifiedDateTime());
			pstmt.setLong(18, bean.getId());
			pstmt.executeUpdate();

			conn.commit();
			pstmt.close();

			log.info("User updated successfully with ID: " + bean.getId());

		} catch (SQLException e) {
			log.error("Error while updating user ID: " + bean.getId(), e);
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public UserBean findByLogin(String login) throws ApplicationException {

		log.debug("Searching user by login: " + login);

		UserBean bean = findByUniqueColumn("login", login);

		if (bean != null) {
			log.info("User found with login: " + login);
		} else {
			log.debug("No user found with login: " + login);
		}

		return bean;
	}

	public UserBean authenticate(String login, String password) throws ApplicationException {

		log.debug("Authenticating user with login: " + login);

		UserBean bean = findByLogin(login);

		if (bean != null && bean.getPassword().equals(password)) {
			log.info("User authenticated successfully: " + login);
			return bean;
		} else {
			log.warn("Authentication failed for login: " + login);
			return null;
		}
	}

	@Override
	public String getWhereClause(UserBean bean) {

		log.debug("Building WHERE clause for UserBean");

		StringBuffer sql = new StringBuffer("");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and first_name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and last_name like '" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password like '" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}

		log.debug("WHERE clause created: " + sql.toString());

		return sql.toString();
	}

	public void updatePhoto(long id, String photo) throws ApplicationException {

		log.debug("Updating photo for user ID: " + id);

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("UPDATE"+getTable()+" SET PHOTO = ? WHERE ID = ?");
			pstmt.setString(1, photo);
			pstmt.setLong(2, id);
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

			log.info("User photo updated successfully for ID: " + id);

		} catch (Exception e) {
			log.error("Error while updating photo for user ID: " + id, e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				log.fatal("Critical error during updatePhoto rollback for ID: " + id, ex);
				throw new ApplicationException("Exception : updatePhoto rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User Photo");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public UserBean changePassword(String newPassword, String oldPassword, String login) {

		log.debug("Changing password for login: " + login);

		UserBean bean = findByLogin(login);

		if (bean != null && bean.getPassword().equals(oldPassword)) {

			log.info("Old password verified for login: " + login);

			bean.setPassword(newPassword);
			update(bean);

			HashMap<String, String> map = new HashMap<String, String>();
			EmailMessage msg = new EmailMessage();

			map.put("login", bean.getLogin());
			map.put("password", bean.getPassword());
			map.put("firstName", bean.getFirstName());
			map.put("lastName", bean.getLastName());

			msg.setTo(map.get("login"));
			msg.setSubject("Password Changed");
			msg.setMessage(EmailBuilder.getChangePasswordMessage(map));
			msg.setMessageType(EmailMessage.HTML_MSG);

			EmailUtility.sendMail(msg);

			log.info("Password changed and email sent successfully for login: " + login);

			return bean;
		}

		log.warn("Password change failed for login: " + login);

		return null;
	}

	public UserBean forgotPassword(String login) {

		log.debug("Processing forgot password request for login: " + login);

		UserBean bean = findByLogin(login);

		if (bean != null) {

			HashMap<String, String> map = new HashMap<String, String>();
			EmailMessage msg = new EmailMessage();

			map.put("login", bean.getLogin());
			map.put("password", bean.getPassword());
			map.put("firstName", bean.getFirstName());
			map.put("lastName", bean.getLastName());

			msg.setTo(map.get("login"));
			msg.setSubject("Password Changed");
			msg.setMessage(EmailBuilder.getForgetPasswordMessage(map));
			msg.setMessageType(EmailMessage.HTML_MSG);

			EmailUtility.sendMail(msg);

			log.info("Forgot password email sent successfully for login: " + login);

			return bean;
		}

		log.warn("Forgot password request failed. User not found: " + login);

		return null;
	}

	public long register(UserBean bean) {

		log.debug("Registering new user with login: " + bean.getLogin());

		long pk = add(bean);

		HashMap<String, String> map = new HashMap<String, String>();
		EmailMessage msg = new EmailMessage();

		map.put("login", bean.getLogin());
		map.put("password", bean.getPassword());

		msg.setTo(map.get("login"));
		msg.setSubject("User Rgistration Information");
		msg.setMessage(EmailBuilder.getUserRegistrationMessage(map));
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);
		System.out.println("mail send successfully");

		log.info("User registered and registration email sent successfully: " + bean.getLogin());

		return pk;
	}

	@Override
	public String getTable() {
		log.debug("Returning User table name: st_user");
		return "st_user";
	}

	@Override
	public UserBean getBean() {
		log.debug("Creating new UserBean object");
		return new UserBean();
	}

}