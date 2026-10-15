package in.co.rays.proj4.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;

/**
 * UserCtl is a controller class used to handle user-related requests.
 * It extends BaseCtl and provides user-specific validation,
 * preload and bean population functionality.
 *
 * @author Shivani
 */
@WebServlet("/ctl/UserCtl")
public class UserCtl extends BaseCtl<UserBean, UserModel> {

	/**
	 * Preloads role data required for the User form.
	 * 
	 * It fetches the list of roles from RoleModel and
	 * stores the role list in the request scope so that
	 * it can be used in the role dropdown on the JSP page.
	 *
	 * @param request HTTP request containing the client request data
	 */
	@Override
	// Dynamic Preload
	protected void preload(HttpServletRequest request) {

		RoleModel rmodel = new RoleModel(); // role model ka object bnaya or list method ko call kia
		List<RoleBean> roleList = rmodel.list(); // list ko roleList name ke object me hold kia
		request.setAttribute("roleList", roleList); // usko request attribute me key-value ke form me set kia

		super.preload(request);
	}

	/**
	 * Validates the user input received from the request.
	 *
	 * It checks whether required fields such as first name,
	 * last name, login, password, confirm password, gender,
	 * role and date of birth are provided.
	 *
	 * It also validates the login format and checks whether
	 * password and confirm password are the same.
	 *
	 * @param request HTTP request containing user form data
	 * @return true if all input data is valid, otherwise false
	 */
	
	@Override
	protected boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", "firstName is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", "lastName is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("login"))) {
			request.setAttribute("login", "login is required");
			pass = false;

		} else if (!DataValidator.isEmail(request.getParameter("login"))) {
			request.setAttribute("login", "login is not in valid format");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", "password is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", "confirmPassword is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			request.setAttribute("gender", "gender is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("roleId"))) {
			request.setAttribute("roleId", "role is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", "dob is required");
			pass = false;
		}

		if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))
				&& !"".equals(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", "Confirm  Password  should not be matched.");
			pass = false;
		}

		return pass;
	}

	/**
	 * Populates the UserBean object with data received
	 * from the HTTP request.
	 *
	 * It reads user form parameters such as ID, role ID,
	 * first name, last name, login, password, gender and DOB,
	 * and stores them in the UserBean.
	 *
	 * It also calls populateDTO() to set common audit
	 * information such as createdBy, modifiedBy,
	 * createdDateTime and modifiedDateTime.
	 *
	 * @param request HTTP request containing user form data
	 * @return populated UserBean object
	 */
	@Override
	protected UserBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setRoleId(DataUtility.getInt(request.getParameter("roleId")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
//		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));

		populateDTO(bean, request); // Its work is to set only 4 attributes

		return bean;
	}

	/**
	 * Returns the JSP view associated with the User controller.
	 *
	 * @return User view path
	 */
	@Override
	protected String getView() {
		return ORSView.USER_VIEW;
	}

	/**
	 * Returns a UserModel object used to perform
	 * user-related database operations.
	 *
	 * @return UserModel object
	 */
	@Override
	protected UserModel getModel() {
		return new UserModel();
	}
}