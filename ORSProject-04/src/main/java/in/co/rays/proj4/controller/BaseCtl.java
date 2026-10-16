package in.co.rays.proj4.controller;

import java.io.IOException;
import java.util.ArrayList;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.model.BaseModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.MessageSource;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * BaseCtl is an abstract base controller class.
 * It provides common functionality that can be reused
 * by different controller classes.
 *
 * @param <B> Bean type which extends BaseBean
 * @param <M> Model type which extends BaseModel
 */
/**
 * @author Shivani
 * @param <B>
 * @param <M>
 */
public abstract class BaseCtl<B extends BaseBean, M extends BaseModel> extends HttpServlet {

	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOG_OUT = "Logout";

	public static final String HAS_ERROR = "haserror";
	public static final String MESSAGE = "message";

	public static final String MSG_SUCCESS = "success";
	public static final String MSG_ERROR = "error";

	/**
	 * Validates the data received from the client request. Child controllers can
	 * override this method to provide their own validation logic.
	 *
	 * @param request HTTP request containing form data
	 * @return true if data is valid, otherwise false
	 */
	protected boolean validate(HttpServletRequest request) {
		return true;
	}

	/**
	 * Loads required data before processing the request. Child controllers can
	 * override this method to load dropdown values or other required data.
	 *
	 * @param request HTTP request in which preload data is stored
	 */
	protected void preload(HttpServletRequest request) {

	}

	/**
	 * Populates a bean object using data received from the HTTP request. Child
	 * controllers override this method to create and populate their specific bean.
	 *
	 * @param request HTTP request containing form data
	 * @return populated bean object
	 */
	protected B populateBean(HttpServletRequest request) {
		return null;
	}

	/**
	 * Populates common audit information into the DTO/Bean. It sets createdBy,
	 * modifiedBy, createdDateTime and modifiedDateTime values.
	 *
	 * If no logged-in user is available, "root" is used as the createdBy and
	 * modifiedBy value.
	 *
	 * @param dto     bean/DTO whose common information is populated
	 * @param request HTTP request containing user and form data
	 * @return updated DTO/Bean
	 */
	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {

		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;
		UserBean userbean = (UserBean) request.getSession().getAttribute("user");

		if (userbean == null) {
			createdBy = "root";
			modifiedBy = "root";
		} else {
			modifiedBy = userbean.getLogin();

			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}
		}

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDateTime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDateTime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDateTime(DataUtility.getCurrentTimestamp());

		return dto;
	}

	/**
	 * Handles GET requests. It retrieves the operation and ID from the request,
	 * finds the corresponding record using the model, stores the bean in the
	 * request and forwards the request to the appropriate view.
	 *
	 * @param request  HTTP request received from the client
	 * @param response HTTP response sent to the client
	 * @throws ServletException if a servlet-related error occurs
	 * @throws IOException      if an input/output error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));

		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {
			BaseBean bean = getModel().findByPK(id);// findbypk user ka data return kregi
			ServletUtility.setBean(bean, request);
		}

		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Handles POST requests. It populates the bean from request data and performs
	 * either add or update operation depending on the ID.
	 *
	 * If ID is greater than zero, the existing record is updated. If ID is zero, a
	 * new record is added.
	 *
	 * @param request  HTTP request received from the client
	 * @param response HTTP response sent to the client
	 * @throws ServletException if a servlet-related error occurs
	 * @throws IOException      if an input/output error occurs
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getLong(request.getParameter("id"));

		B bean = populateBean(request);// populate bean method m user k data ko bean m set kia
		M model = getModel(); // getModel method se usermodel ka object create kia

		if (id > 0) {
			model.update(bean);
			ServletUtility.setSuccessMessage("Data is successfully updated", request);
		} else {
			model.add(bean);
			ServletUtility.setSuccessMessage("Data is successfully saved", request);
		}

		ServletUtility.setBean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * Processes every request before it reaches doGet() or doPost().
	 *
	 * This method loads the message source and preload data. For POST requests, it
	 * also performs validation. If validation fails, the request is forwarded back
	 * to the view with the entered bean data.
	 *
	 * It also handles DuplicateRecordException thrown during request processing.
	 *
	 * @param request  HTTP request received from the client
	 * @param response HTTP response sent to the client
	 * @throws ServletException if a servlet-related error occurs
	 * @throws IOException      if an input/output error occurs
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getMessageSource(request);
		BaseBean bean = populateBean(request);

		preload(request);

		if ("POST".equals(request.getMethod())) {

			if (validate(request) == false) {

				ServletUtility.setBean(bean, request);

				ServletUtility.forward(getView(), request, response);

				return;
			}
		}

		try {

			super.service(request, response);

		} catch (DuplicateRecordException e) {
			e.printStackTrace();
			ServletUtility.setBean(bean, request);
			ServletUtility.setErrorMessage(e.getMessage(), request);

			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + " ============== database is down ===================");
			ServletUtility.setPageNo(1, request);
			ServletUtility.setPageSize(10, request);
			ServletUtility.setList(new ArrayList<BaseBean>(), request);
			request.setAttribute("nextList", new ArrayList<BaseBean>());
			ServletUtility.setErrorMessage("database service is down", request);
			ServletUtility.forward(getView(), request, response);
		}

	}

	/**
	 * Returns the JSP view associated with the controller. Child controllers must
	 * override this method and return their respective view path.
	 *
	 * @return view path of the controller
	 */
	protected abstract String getView();

	/**
	 * Returns the model associated with the controller. Child controllers must
	 * override this method and return their respective model object.
	 *
	 * @return model object used by the controller
	 */ 
	protected abstract M getModel();

	/**
	 * Gets the MessageSource instance used for retrieving application messages.
	 *
	 * @param request HTTP request
	 * @return MessageSource singleton instance
	 */
	public MessageSource getMessageSource(HttpServletRequest request) {

		MessageSource messagesource = MessageSource.getInstance();

		return messagesource;
	}
}