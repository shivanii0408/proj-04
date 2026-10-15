package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.RestaurantBean;
import in.co.rays.proj4.model.RestaurantModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/RestaurantListCtl")

public class RestaurantListCtl extends BaseListCtl<RestaurantBean, RestaurantModel> {

	@Override
	protected RestaurantBean populateBean(HttpServletRequest request) {
		RestaurantBean bean = new RestaurantBean();
		bean.setItemName(DataUtility.getString(request.getParameter("item_name")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.RESTAURANT_LIST_VIEW;
	}

	@Override
	protected RestaurantModel getModel() {
		return new RestaurantModel();
	}
}
