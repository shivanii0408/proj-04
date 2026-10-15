package in.co.rays.proj4.controller;

import java.io.IOException;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.BaseModel;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.ServletUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ctl/GetMarksheetCtl")
public class GetMarksheetCtl extends BaseCtl {

	private MarksheetModel model = new MarksheetModel();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollNo = DataUtility.getString(request.getParameter("rollNo"));

		try {

			MarksheetBean bean = model.getMarksheet(rollNo);
			if (bean != null) {
				request.setAttribute("bean", bean);
			} else {
				ServletUtility.setErrorMessage("Roll No not found", request);
			}

			ServletUtility.forward(ORSView.GET_MARKSHEET_VIEW, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getView() {
		return ORSView.GET_MARKSHEET_VIEW;
	}

	@Override
	protected BaseModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}