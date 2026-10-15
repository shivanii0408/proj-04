package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.model.GymModel;
import jakarta.servlet.annotation.WebServlet;

/**
 * Report servlet that generates a Faculty list report in PDF or DOC format.
 * Mapped to {@code /ctl/FacultyReportCtl}; add {@code ?type=doc} for Word
 * output.
 *
 * @author Rays EdTech
 * @version 1.0
 * @see BaseReportCtl
 */
@WebServlet("/ctl/GymReportCtl")
public class GymReportCtl extends BaseReportCtl<GymBean> {

	/**
	 * Fetches all faculty members from the database.
	 *
	 * @return list of all {@link FacultyBean} records
	 */
	public List<GymBean> getList() {
		GymModel model = new GymModel();
		@SuppressWarnings("unchecked")
		List<GymBean> faculty = model.list();
		return faculty;
	}

	/**
	 * Returns the JRXML template path for the faculty list report.
	 *
	 * @return {@link ORSView#FACULTY_REPORT_VIEW}
	 */
	public String getView() {
		return ORSView.GYM_REPORT_VIEW;
	}

	/**
	 * Returns the ServletContext cache key for the compiled faculty report.
	 *
	 * @return {@code "GYM_LIST_COMPILED_REPORT"}
	 */
	public String getCompiledReportKey() {
		return "GYM_LIST_COMPILED_REPORT";
	}

}