package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.FoodBean;
import in.co.rays.proj4.model.FoodModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

 @WebServlet("/ctl/FoodCtl")
public class FoodCtl extends BaseCtl<FoodBean, FoodModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("orderId"))) {
			request.setAttribute("orderId", "order id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", "customer name is require");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("restaurant"))) {
			request.setAttribute("restaurant", "restaurant is require");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("orderAmount"))) {
			request.setAttribute("orderAmount", "order amount is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("deliveryStatus"))) {
			request.setAttribute("deliveryStatus", "delivery status is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected FoodBean populateBean(HttpServletRequest request) {

		FoodBean bean = new FoodBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setOrderId(DataUtility.getString(request.getParameter("orderId")));
		bean.setCustomerName(DataUtility.getString(request.getParameter("customerName")));
		bean.setRestaurant(DataUtility.getString(request.getParameter("restaurant")));
		bean.setOrderAmount(DataUtility.getDouble(request.getParameter("orderAmount")));
		bean.setDeliveryStatus(DataUtility.getString(request.getParameter("deliveryStatus")));
		

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.FOOD_VIEW;
	}

	@Override
	protected FoodModel getModel() {
		return new FoodModel();
	}
}
