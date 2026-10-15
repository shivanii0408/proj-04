package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.model.GymModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

 @WebServlet("/ctl/GymCtl")
public class GymCtl extends BaseCtl<GymBean, GymModel>{

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("memberId"))) {
			request.setAttribute("memberId", "member id id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", "name is require");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("membershipType"))) {
			request.setAttribute("membershipType", "membership Type is require");
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("joiningDate"))) {
			request.setAttribute("joiningDate", "joining Date is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("trainerName"))) {
			request.setAttribute("trainerName", "trainer name is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected GymBean populateBean(HttpServletRequest request) {

		GymBean bean = new GymBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setMemberId(DataUtility.getString(request.getParameter("memberId")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setMembershipType(DataUtility.getString(request.getParameter("membershipType")));
		bean.setJoiningDate(DataUtility.getString(request.getParameter("joiningDate")));
		bean.setTrainerName(DataUtility.getString(request.getParameter("trainerName")));
		

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.GYM_VIEW;
	}

	@Override
	protected GymModel getModel() {
		return new GymModel();
	}
}
