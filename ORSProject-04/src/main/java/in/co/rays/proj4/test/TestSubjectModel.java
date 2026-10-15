package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.StudentModel;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	public static SubjectModel model = new SubjectModel();

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByName();
		testSearch();
	}

	private static void testAdd() throws Exception {

		SubjectBean bean = new SubjectBean();

//		bean.setName("Java");
//		bean.setDescription("Core Java Programming");
//		bean.setCourseId(1);
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setName("SQL");
		bean.setDescription("Database and SQL Programming");
		bean.setCourseId(2);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testUpdate() {
		SubjectBean bean = new SubjectBean();

		bean.setId(2);
		bean.setName("DSA");
		bean.setDescription("Data Structures and Algorithms");
		bean.setCourseId(2);
//		bean.setCreatedBy("admin");
		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(bean);

	}

	public static void testFindByPk() {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = new SubjectBean();

		bean = model.findByPK(1);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCourseId());

	}

	public static void testFindByName() {

		SubjectModel model = new SubjectModel();

		SubjectBean bean = new SubjectBean();

		bean = model.findByName("DSA");

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
		System.out.println(bean.getCourseId());
	}
	
	
	public static void testSearch() {

		SubjectModel model = new SubjectModel();
		SubjectBean bean = new SubjectBean();

//		bean.setFirstName("virat"); 

		List<SubjectBean> list = model.search(bean, 1, 5);

		Iterator<SubjectBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCourseId());
			System.out.println("----------------");
		}

	}

}
