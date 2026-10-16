package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.GymBean;
import in.co.rays.proj4.model.GymModel;
import jakarta.servlet.annotation.WebServlet;

/**
 * Report servlet that generates a Gym list report in PDF or DOC format.
 *
 * @author Rays EdTech
 * @version 1.0
 * @see BaseReportCtl
 */
@WebServlet("/ctl/GymReportCtl")
public class GymReportCtl extends BaseReportCtl<GymBean> {

    /**
     * Fetches all gym records from the database.
     *
     * @return list of all GymBean records
     */
    public List<GymBean> getList() {
        GymModel model = new GymModel();
        List<GymBean> gym = model.list();
        return gym;
    }

    /**
     * Returns the JRXML template path for the gym list report.
     *
     * @return Gym report view
     */
    public String getView() {
        return ORSView.GYM_REPORT_VIEW;
    }

    /**
     * Returns the ServletContext cache key for the compiled gym report.
     *
     * @return Gym compiled report key
     */
    public String getCompiledReportKey() {
        return "GYM_LIST_COMPILED_REPORT";
    }
}