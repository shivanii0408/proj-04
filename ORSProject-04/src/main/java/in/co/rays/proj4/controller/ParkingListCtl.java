package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.bean.ParkingBean;
import in.co.rays.proj4.model.GymModel;
import in.co.rays.proj4.model.ParkingModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ParkingListCtl")
public class ParkingListCtl extends BaseListCtl<ParkingBean, ParkingModel> {

	@Override
	protected ParkingBean populateBean(HttpServletRequest request) {
		ParkingBean bean = new ParkingBean();
		bean.setVehicleNumber(DataUtility.getString(request.getParameter("vehicleNumber")));
		bean.setVehicleType(DataUtility.getString(request.getParameter("vehicleType")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.PARKING_LIST_VIEW;
	}

	@Override
	protected ParkingModel getModel() {
		return new ParkingModel();
	}
}
