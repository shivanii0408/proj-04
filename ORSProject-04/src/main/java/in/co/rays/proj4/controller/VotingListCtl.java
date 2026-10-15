package in.co.rays.proj4.controller;
import in.co.rays.proj4.bean.VotingBean;
import in.co.rays.proj4.model.VotingModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/VotingListCtl")
public class VotingListCtl extends BaseListCtl<VotingBean, VotingModel> {

	@Override
	protected VotingBean populateBean(HttpServletRequest request) {
		VotingBean bean = new VotingBean();
		bean.setVoterId(DataUtility.getString(request.getParameter("voterId")));
		bean.setConstituency(DataUtility.getString(request.getParameter("constituency")));


		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.VOTING_LIST_VIEW;
	}

	@Override
	protected VotingModel getModel() {
		return new VotingModel();
	}
}
