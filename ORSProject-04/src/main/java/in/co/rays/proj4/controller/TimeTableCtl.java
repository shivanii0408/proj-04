package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.bean.TimeTableBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.model.SubjectModel;
import in.co.rays.proj4.model.TimeTableModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/TimeTableCtl")
public class TimeTableCtl extends BaseCtl<TimeTableBean, TimeTableModel> {

	
	@Override
	//Dynamic Preload 
	protected void preload(HttpServletRequest request) {
		CourseModel cmodel = new CourseModel(); // role model ka object bnaya or list method ko call kia
		List<CourseBean> courseList = cmodel.list(); //list ko rolelist nm k object m hold kia 
		request.setAttribute("courseList", courseList); //or usko request attribute m key value m set kia
		
		
		SubjectModel smodel = new SubjectModel(); // role model ka object bnaya or list method ko call kia
		List<SubjectBean> subjectList = smodel.list(); //list ko rolelist nm k object m hold kia 
		request.setAttribute("subjectList", subjectList); //or usko request attribute m key value m set kia

		super.preload(request);
	}
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("semester"))) {
			request.setAttribute("semester", " semester is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", "description is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("examDate"))) {
			request.setAttribute("examDate", "exam date is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("examTime"))) {
			request.setAttribute("examTime", "exam time is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("courseId"))) {
			request.setAttribute("courseId", "course id is require");
			pass = false;
		}
//		if (DataValidator.isNull(request.getParameter("courseName"))) {
//			request.setAttribute("courseName", "course name is require");
//			pass = false;
//		}
		if (DataValidator.isNull(request.getParameter("subjectId"))) {
			request.setAttribute("subjectId", "subject id is require");
			pass = false;
		}
//		if (DataValidator.isNull(request.getParameter("subjectName"))) {
//			request.setAttribute("subjectName", "subject name is require");
//			pass = false;
//		}

		return pass;
	}

	@Override
	protected TimeTableBean populateBean(HttpServletRequest request) {

		TimeTableBean bean = new TimeTableBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setSemester(DataUtility.getString(request.getParameter("semester")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		bean.setExamDate(DataUtility.getDate(request.getParameter("examDate")));
		bean.setExamTime(DataUtility.getString(request.getParameter("examTime")));
		bean.setCourseId(DataUtility.getInt(request.getParameter("courseId")));
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		bean.setSubjectId(DataUtility.getInt(request.getParameter("subjectId")));
		bean.setSubjectName(DataUtility.getString(request.getParameter("subjectName")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.TIMETABLE_VIEW;
	}

	@Override
	protected TimeTableModel getModel() {
		return new TimeTableModel();
	}

}
