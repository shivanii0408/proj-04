package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.HospitalBean;
import in.co.rays.proj4.model.HospitalModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HospitalListCtl")
public class HospitalListCtl extends BaseListCtl<HospitalBean, HospitalModel> {

	@Override
	protected HospitalBean populateBean(HttpServletRequest request) {
		HospitalBean bean = new HospitalBean();
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setBloodGroup(DataUtility.getString(request.getParameter("bloodGroup")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.HOSPITAL_LIST_VIEW;
	}

	@Override
	protected HospitalModel getModel() {
		return new HospitalModel();
	}
}
