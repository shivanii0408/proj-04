package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.model.FacultyModel;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {

	public static MarksheetModel model = new MarksheetModel();

	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testFindByRollNo();
//		testFindByPk();
		testSearch();
	}

	private static void testAdd() {

		MarksheetBean bean = new MarksheetBean();

//		bean.setRollNo("R001");
//		bean.setStudentId(1);
//		bean.setName("Rahul Sharma");
//		bean.setPhysics(85);
//		bean.setChemistry(78);
//		bean.setMaths(92);
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setRollNo("R002");
		bean.setStudentId(2);
		bean.setName("Priya Verma");
		bean.setPhysics(91);
		bean.setChemistry(88);
		bean.setMaths(95);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setRollNo("R003");
		bean.setStudentId(3);
		bean.setName("Amit Patel");
		bean.setPhysics(76);
		bean.setChemistry(82);
		bean.setMaths(79);
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

	private static void testUpdate() {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(3);
		bean.setRollNo("R003");
		bean.setStudentId(3);
		bean.setName("Sneha Gupta");
		bean.setPhysics(88);
		bean.setChemistry(94);
		bean.setMaths(90);
//		bean.setCreatedBy("admin");
		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	public static void testFindByPk() {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getStudentId());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());

	}

	public static void testFindByRollNo() {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		bean = model.findByRollNo("R003");

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getStudentId());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
	}
	
	public static void testSearch() {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

//		bean.setFirstName("virat"); 

		List<MarksheetBean> list = model.search(bean, 1, 5);

		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println("----------------");
		}

	}
}
