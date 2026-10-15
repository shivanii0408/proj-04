package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.StudentModel;

public class TestStudentModel {

	public static StudentModel model = new StudentModel();

	public static void main(String[] args) throws ParseException {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByEmailId();
		testSearch();

	}

	private static void testAdd() throws ParseException {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setCollegeId(1);
//		bean.setCollegeName("IET DAVV");
//		bean.setFirstName("Rahul");
//		bean.setLastName("Sharma");
//		bean.setDob(sdf.parse("2002-05-15"));
//		bean.setMobileNo("9876543210");
//		bean.setEmail("rahul.sharma@gmail.com");
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setCollegeId(2);
		bean.setCollegeName("Medicaps University");
		bean.setFirstName("Priya");
		bean.setLastName("Verma");
		bean.setDob(sdf.parse("2003-08-21"));
		bean.setMobileNo("9876543211");
		bean.setEmail("priya.verma@gmail.com");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testUpdate() throws ParseException {

		StudentBean bean = new StudentBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(2);
		bean.setCollegeId(2);
		bean.setCollegeName("Medicaps University");
		bean.setFirstName("Shivani");
		bean.setLastName("Verma");
		bean.setDob(sdf.parse("2003-08-21"));
		bean.setMobileNo("9876543211");
		bean.setEmail("shivani@gmail.com");

//		bean.setCreatedBy("admin");
		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	public static void testFindByPk() {

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

		bean = model.findByPK(1);

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getEmail());

	}

	public static void testFindByEmailId() {

		StudentModel model = new StudentModel();

		StudentBean bean = new StudentBean();

		bean = model.findByEmailId("shivani@gmail.com");

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getDob());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getEmail());
	}
	
	public static void testSearch() {

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

//		bean.setFirstName("virat"); 

		List<StudentBean> list = model.search(bean, 1, 5);

		Iterator<StudentBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getEmail());
			System.out.println("----------------");
		}

	}


}
