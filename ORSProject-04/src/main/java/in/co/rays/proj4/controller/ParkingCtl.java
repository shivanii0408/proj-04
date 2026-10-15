package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.ParkingBean;
import in.co.rays.proj4.model.ParkingModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/ParkingCtl")

public class ParkingCtl extends BaseCtl<ParkingBean, ParkingModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("vehicleNumber"))) {
			request.setAttribute("vehicleNumber", " Vehicle number is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("vehicleType"))) {
			request.setAttribute("vehicleType", "vehicle Type is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("entryTime"))) {
			request.setAttribute("entryTime", "entry Time is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected ParkingBean populateBean(HttpServletRequest request) {

		ParkingBean bean = new ParkingBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setVehicleNumber(DataUtility.getString(request.getParameter("vehicleNumber")));
		bean.setVehicleType(DataUtility.getString(request.getParameter("vehicleType")));
		bean.setEntryTime(DataUtility.getString(request.getParameter("entryTime")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.PARKING_VIEW;
	}

	@Override
	protected ParkingModel getModel() {
		return new ParkingModel();
	}

}
