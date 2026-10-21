package in.co.rays.proj4.controller;

public interface ORSView {

	public String APP_CONTEXT = "/ORSProject-04"; // constant, field, variable

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
	public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
	public String FOOD_VIEW = PAGE_FOLDER + "/FoodView.jsp";
	public String FOOD_LIST_VIEW = PAGE_FOLDER + "/FoodListView.jsp";
	public String GYM_VIEW = PAGE_FOLDER + "/GymView.jsp";
	public String GYM_LIST_VIEW = PAGE_FOLDER + "/GymListView.jsp";
	public String PARKING_VIEW = PAGE_FOLDER + "/ParkingView.jsp";
	public String PARKING_LIST_VIEW = PAGE_FOLDER + "/ParkingListView.jsp";
	public String VOTING_VIEW = PAGE_FOLDER + "/VotingView.jsp";
	public String VOTING_LIST_VIEW = PAGE_FOLDER + "/VotingListView.jsp";
	public String HOSPITAL_VIEW = PAGE_FOLDER + "/HospitalView.jsp";
	public String HOSPITAL_LIST_VIEW = PAGE_FOLDER + "/HospitalListView.jsp";

	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String MOVIE_VIEW = PAGE_FOLDER + "/MovieView.jsp";
	public String MOVIE_LIST_VIEW = PAGE_FOLDER + "/MovieListView.jsp";
	public String RESTAURANT_VIEW = PAGE_FOLDER + "/RestaurantView.jsp";
	public String RESTAURANT_LIST_VIEW = PAGE_FOLDER + "/RestaurantListView.jsp";

	public String ERROR_CTL = "/ctl/MarksheetCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
	public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
	public String FOOD_CTL = APP_CONTEXT + "/ctl/FoodCtl";
	public String FOOD_LIST_CTL = APP_CONTEXT + "/ctl/FoodListCtl";
	public String FOOD_REPORT_CTL = APP_CONTEXT + "/ctl/FoodReportCtl";
	public String GYM_CTL = APP_CONTEXT + "/ctl/GymCtl";
	public String GYM_LIST_CTL = APP_CONTEXT + "/ctl/GymListCtl";
	public String PARKING_CTL = APP_CONTEXT + "/ctl/ParkingCtl";
	public String PARKING_LIST_CTL = APP_CONTEXT + "/ctl/ParkingListCtl";
	public String UPLOAD_PHOTO_CTL = APP_CONTEXT + "/ctl/uploadphoto";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
	public String VOTING_CTL = APP_CONTEXT + "/ctl/VotingCtl";
	public String VOTING_LIST_CTL = APP_CONTEXT + "/ctl/VotingListCtl";
	public String HOSPITAL_CTL = APP_CONTEXT + "/ctl/HospitalCtl";
	public String HOSPITAL_LIST_CTL = APP_CONTEXT + "/ctl/HospitalListCtl";
	public String MOVIE_CTL = APP_CONTEXT + "/ctl/MovieCtl";
	public String MOVIE_LIST_CTL = APP_CONTEXT + "/ctl/MovieListCtl";
	public String RESTAURANT_CTL = APP_CONTEXT + "/ctl/RestaurantCtl";
	public String RESTAURANT_LIST_CTL = APP_CONTEXT + "/ctl/RestaurantListCtl";
	

	public String STUDENT_REPORT_CTL = APP_CONTEXT + "/ctl/StudentReportCtl";
	public String COLLEGE_REPORT_CTL = APP_CONTEXT + "/ctl/CollegeReportCtl";
	public String USER_REPORT_CTL = APP_CONTEXT + "/ctl/UserReportCtl";
	public String ROLE_REPORT_CTL = APP_CONTEXT + "/ctl/RoleReportCtl";
	public String COURSE_REPORT_CTL = APP_CONTEXT + "/ctl/CourseReportCtl";
	public String SUBJECT_REPORT_CTL = APP_CONTEXT + "/ctl/SubjectReportCtl";
	public String MARKSHEET_REPORT_CTL = APP_CONTEXT + "/ctl/MarksheetReportCtl";
	public String FACULTY_REPORT_CTL = APP_CONTEXT + "/ctl/FacultyReportCtl";
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	public String TIMETABLE_REPORT_CTL = APP_CONTEXT + "/ctl/TimeTableReportCtl";
	public String GYM_REPORT_CTL = APP_CONTEXT + "/ctl/GymReportCtl";
	public String VOTING_REPORT_CTL = APP_CONTEXT + "/ctl/VotingReportCtl";
	public String HOSPITAL_REPORT_CTL = APP_CONTEXT + "/ctl/HospitalReportCtl";
	public String MOVIE_REPORT_CTL = APP_CONTEXT + "/ctl/MovieReportCtl";
	public String RESTAURANT_REPORT_CTL = APP_CONTEXT + "/ctl/RestaurantReportCtl";


	public String COURSE_REPORT_VIEW = "/reports/CourseListReport.jrxml";
	public String STUDENT_REPORT_VIEW = "/reports/StudentListReport.jrxml";
	public String COLLEGE_REPORT_VIEW = "/reports/CollegeListReport.jrxml";
	public String USER_REPORT_VIEW = "/reports/UserListReport.jrxml";
	public String ROLE_REPORT_VIEW = "/reports/RoleListReport.jrxml";
	public String SUBJECT_REPORT_VIEW = "/reports/SubjectListReport.jrxml";
	public String MARKSHEET_REPORT_VIEW = "/reports/MarksheetListReport.jrxml";
	public String FACULTY_REPORT_VIEW = "/reports/FacultyListReport.jrxml";
	public String TIMETABLE_REPORT_VIEW = "/reports/TimeTableListReport.jrxml";
	public String GYM_REPORT_VIEW = "/reports/GymListReport.jrxml";
	public String FOOD_REPORT_VIEW = "/reports/FoodListReport.jrxml";
	public String VOTING_REPORT_VIEW = "/reports/VotingListReport.jrxml";
	public String HOSPITAL_REPORT_VIEW = "/reports/HospitalListReport.jrxml";
	public String MOVIE_REPORT_VIEW = "/reports/MovieListReport.jrxml";
	public String RESTAURANT_REPORT_VIEW = "/reports/RestaurantListReport.jrxml";


}