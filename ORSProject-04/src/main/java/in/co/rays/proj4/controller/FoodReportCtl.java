package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.FoodBean;
import in.co.rays.proj4.model.FoodModel;
import jakarta.servlet.annotation.WebServlet;

/**
 * Report servlet that generates a Food Order list report in PDF or DOC format.
 *
 * @author Rays EdTech
 * @version 1.0
 * @see BaseReportCtl
 */
@WebServlet("/ctl/FoodReportCtl")
public class FoodReportCtl extends BaseReportCtl<FoodBean> {

    /**
     * Fetches all food order records from the database.
     *
     * @return list of all FoodBean records
     */
    public List<FoodBean> getList() {
        FoodModel model = new FoodModel();
        List<FoodBean> food = model.list();
        return food;
    }

    /**
     * Returns the JRXML template path for the food order report.
     *
     * @return Food report view
     */
    public String getView() {
        return ORSView.FOOD_REPORT_VIEW;
    }

    /**
     * Returns the ServletContext cache key for the compiled food report.
     *
     * @return Food compiled report key
     */
    public String getCompiledReportKey() {
        return "FOOD_LIST_COMPILED_REPORT";
    }
}