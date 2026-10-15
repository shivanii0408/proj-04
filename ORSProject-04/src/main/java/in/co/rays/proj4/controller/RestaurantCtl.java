package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.RestaurantBean;
import in.co.rays.proj4.model.RestaurantModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/RestaurantCtl")

public class RestaurantCtl extends BaseCtl<RestaurantBean, RestaurantModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("itemId"))) {
			request.setAttribute("itemId", "Item Id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("itemName"))) {
			request.setAttribute("itemName", "Item Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("category"))) {
			request.setAttribute("category", "Category is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", "Price is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("isAvailable"))) {
			request.setAttribute("isAvailable", "Is Available is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected RestaurantBean populateBean(HttpServletRequest request) {

		RestaurantBean bean = new RestaurantBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setItemId(DataUtility.getString(request.getParameter("itemId")));
		bean.setItemName(DataUtility.getString(request.getParameter("itemName")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));

		bean.setPrice(DataUtility.getDouble(request.getParameter("price")));
		bean.setAvailable(DataUtility.getBoolean(request.getParameter("isAvailable")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.RESTAURANT_VIEW;
	}

	@Override
	protected RestaurantModel getModel() {
		return new RestaurantModel();
	}

}
