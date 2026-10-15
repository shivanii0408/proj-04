package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.model.GymModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/GymListCtl")
public class GymListCtl extends BaseListCtl<GymBean, GymModel> {

	@Override
	protected GymBean populateBean(HttpServletRequest request) {
		GymBean bean = new GymBean();
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setMembershipType(DataUtility.getString(request.getParameter("membershipType")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.GYM_LIST_VIEW;
	}

	@Override
	protected GymModel getModel() {
		return new GymModel();
	}
}
