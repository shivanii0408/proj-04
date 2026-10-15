package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

	public static CourseModel model = new CourseModel();

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDelete();
//		testUpdate();
//		testFindByPk();
//		testFindByName();
		testSearch();

	}

	private static void testAdd() {
		CourseBean bean = new CourseBean();

//		bean.setName("Java");
//		bean.setDuration("6 Months");
//		bean.setDescription("Java Programming Course");
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

//		bean.setName("Python");
//		bean.setDuration("4 Months");
//		bean.setDescription("Python Programming Course");
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setName("JavaScript");
		bean.setDuration("3 Months");
		bean.setDescription("JavaScript Web Development Course");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testUpdate() {
		CourseBean bean = new CourseBean();

		bean.setId(3);
		bean.setName("React");
		bean.setDuration("3 Months");
		bean.setDescription("JavaScript Web Development Course");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("Tanisha");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	private static void testDelete() throws Exception {
		model.delete(2);

	}

	public static void testFindByPk() {

		CourseModel model = new CourseModel();

		CourseBean bean = new CourseBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDuration());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());

	}

	public static void testFindByName() {

		CourseModel model = new CourseModel();

		CourseBean bean = new CourseBean();

		bean = model.findByName("React");

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDuration());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
	}
	
	public static void testSearch() {

		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();

//		bean.setFirstName("virat");

		List<CourseBean> list = model.search(bean, 1, 5);

		Iterator<CourseBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDuration());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println("----------------");
		}

	}
}
