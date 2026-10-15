package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {

	public static FacultyModel model = new FacultyModel();

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByEmail();
		testSearch();
	}

	private static void testAdd() throws Exception {
		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

//		bean.setCollegeId(1);
//		bean.setCollegeName("IET DAVV");
//		bean.setFirstName("Rahul");
//		bean.setLastName("Sharma");
//		bean.setEmail("rahul.sharma@gmail.com");
//		bean.setMobileNo("9876543210");
//		bean.setAddress("Indore, Madhya Pradesh");
//		bean.setGender("Male");
//		bean.setDateOfBirth(sdf.parse("1998-05-15"));
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

//		bean.setCollegeId(2);
//		bean.setCollegeName("IPS Academy");
//		bean.setFirstName("Neha");
//		bean.setLastName("Singh");
//		bean.setEmail("neha.singh@gmail.com");
//		bean.setMobileNo("9876543213");
//		bean.setAddress("Rau, Indore");
//		bean.setGender("Female");
//		bean.setDateOfBirth(sdf.parse("1997-03-18"));
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setCollegeId(3);
		bean.setCollegeName("Medicaps University");
		bean.setFirstName("Anjali");
		bean.setLastName("Joshi");
		bean.setEmail("anjali.joshi@gmail.com");
		bean.setMobileNo("9876543215");
		bean.setAddress("Scheme No. 54, Indore");
		bean.setGender("Female");
		bean.setDateOfBirth(sdf.parse("1995-12-10"));
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

	private static void testUpdate() throws ParseException {
		FacultyBean bean = new FacultyBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setId(3);
		bean.setCollegeId(3);
		bean.setCollegeName("Medicaps University");
		bean.setFirstName("Anjali");
		bean.setLastName("Joshi");
		bean.setEmail("anjali.joshi@gmail.com");
		bean.setMobileNo("9676543215"); // Update
		bean.setAddress("Scheme No. 54, Indore");
		bean.setGender("Female");
		bean.setDateOfBirth(sdf.parse("1995-12-10"));
//		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.update(bean);
	}

	public static void testFindByPk() {

		FacultyModel model = new FacultyModel();

		FacultyBean bean = new FacultyBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getEmail());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getAddress());
		System.out.println(bean.getGender());
		System.out.println(bean.getDateOfBirth());

	}

	public static void testFindByEmail() {

		FacultyModel model = new FacultyModel();

		FacultyBean bean = new FacultyBean();

		bean = model.findByEmail("anjali.joshi@gmail.com");

		System.out.println(bean.getId());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getEmail());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getAddress());
		System.out.println(bean.getGender());
		System.out.println(bean.getDateOfBirth());

	}
	
	public static void testSearch() {

		FacultyModel model = new FacultyModel();
		FacultyBean bean = new FacultyBean();

//		bean.setFirstName("virat");

		List<FacultyBean> list = model.search(bean, 1, 5);

		Iterator<FacultyBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getEmail());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getAddress());
			System.out.println(bean.getGender());
			System.out.println(bean.getDateOfBirth());
			System.out.println("----------------");
		}

	}
}
