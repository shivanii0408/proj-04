package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.FoodBean;
import in.co.rays.proj4.model.FoodModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/FoodListCtl")
public class FoodListCtl extends BaseListCtl<FoodBean, FoodModel>{

	@Override
	protected FoodBean populateBean(HttpServletRequest request) {
		FoodBean bean = new FoodBean();
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setRestaurant(DataUtility.getString(request.getParameter("restaurant")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));
		
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.FOOD_LIST_VIEW;
	}

	@Override
	protected FoodModel getModel() {
		return new FoodModel();
	}
}
