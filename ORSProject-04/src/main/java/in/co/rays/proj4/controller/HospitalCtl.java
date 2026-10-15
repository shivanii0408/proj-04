
package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.HospitalBean;
import in.co.rays.proj4.model.HospitalModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/HospitalCtl")
public class HospitalCtl extends BaseCtl<HospitalBean, HospitalModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("patientId"))) {
			request.setAttribute("patientId", "Patient Id is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", "Name is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("age"))) {
			request.setAttribute("age", "Age is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("bloodGroup"))) {
			request.setAttribute("bloodGroup", "Blood Group is required");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("disease"))) {
			request.setAttribute("disease", "Disease is required");
			pass = false;
		}

		return pass;
	}

	@Override
	protected HospitalBean populateBean(HttpServletRequest request) {
		HospitalBean bean = new HospitalBean();

		bean.setPatientId(DataUtility.getString(request.getParameter("patientId")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setAge(DataUtility.getInt(request.getParameter("age")));
		bean.setBloodGroup(DataUtility.getString(request.getParameter("bloodGroup")));
		bean.setDisease(DataUtility.getString(request.getParameter("disease")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.HOSPITAL_VIEW;
	}

	@Override
	protected HospitalModel getModel() {
		return new HospitalModel();
	}
}
