package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.TimeTableBean;

import in.co.rays.proj4.model.TimeTableModel;

import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/TimeTableListCtl")
public class TimeTableListCtl  extends BaseListCtl<TimeTableBean, TimeTableModel>{

	@Override
	protected TimeTableBean populateBean(HttpServletRequest request) {
		TimeTableBean bean = new TimeTableBean();
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		bean.setSemester(DataUtility.getString(request.getParameter("semester")));
//		bean.setLogin(DataUtility.getString(request.getParameter("login")));
//		bean.setPassword(DataUtility.getString(request.getParameter("password")));
//		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
//		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
//		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
//		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.TIMETABLE_LIST_VIEW;
	}

	@Override
	protected TimeTableModel getModel() {
		return new TimeTableModel();
	}
}
