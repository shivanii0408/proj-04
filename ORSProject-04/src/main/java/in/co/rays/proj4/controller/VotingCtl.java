package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.VotingBean;
import in.co.rays.proj4.model.VotingModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VotingCtl")

public class VotingCtl extends BaseCtl<VotingBean, VotingModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("voterId"))) {
			request.setAttribute("voterId", " voter Id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", "name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("age"))) {
			request.setAttribute("age", "age is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("constituency"))) {
			request.setAttribute("constituency", "constituency is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("hasVoted"))) {
			request.setAttribute("hasVoted", "It is required");
			pass = false;
		}

		return pass;
	}

	@Override
	protected VotingBean populateBean(HttpServletRequest request) {

		VotingBean bean = new VotingBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setVoterId(DataUtility.getString(request.getParameter("voterId")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setAge(DataUtility.getString(request.getParameter("age")));
		bean.setConstituency(DataUtility.getString(request.getParameter("constituency")));
		bean.setHasVoted(Boolean.parseBoolean(request.getParameter("hasVoted")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.VOTING_VIEW;
	}

	@Override
	protected VotingModel getModel() {
		return new VotingModel();
	}
}
