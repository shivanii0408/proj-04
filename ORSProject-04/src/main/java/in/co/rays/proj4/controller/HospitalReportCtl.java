package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.HospitalBean;
import in.co.rays.proj4.model.HospitalModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/HospitalReportCtl")
public class HospitalReportCtl extends BaseReportCtl<HospitalBean> {

	public List<HospitalBean> getList() {
		HospitalModel model = new HospitalModel();
		@SuppressWarnings("unchecked")
		List<HospitalBean> hospital = model.list();
		return hospital;
	}

	public String getView() {
		return ORSView.HOSPITAL_REPORT_VIEW;
	}

	public String getCompiledReportKey() {
		return "HOSPITAL_LIST_COMPILED_REPORT";
	}

}
