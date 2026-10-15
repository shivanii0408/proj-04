package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.model.UserModel;

public class TestCollegeModel {

	public static CollegeModel model = new CollegeModel();

	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByName();
		testSearch();
	}

	private static void testAdd() {

		CollegeBean bean = new CollegeBean();

//		bean.setName("IET DAVV");
// 	 	bean.setAddress("Khandwa Road");
//		bean.setState("Madhya Pradesh");
//		bean.setCity("Indore");
//		bean.setPhoneNo("9876543210");
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

//		bean.setName("Medicaps University");
//		bean.setAddress("Rau");
//		bean.setState("Madhya Pradesh");
//		bean.setCity("Indore");
//		bean.setPhoneNo("9876543211");
//		bean.setCreatedBy("admin");
//		bean.setModifiedBy("admin");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setName("IPS Academy");
		bean.setAddress("Rajendra Nagar");
		bean.setState("Madhya Pradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("9876543212");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.add(bean);

	}

	private static void testUpdate() {
		CollegeBean bean = new CollegeBean();

		bean.setId(3);
		bean.setName("Acropolis Institute");
		bean.setAddress("Manglia");
		bean.setState("Madhya Pradesh");
		bean.setCity("Indore");
		bean.setPhoneNo("9876543213");
//		bean.setCreatedBy("admin");
		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(null);
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		model.update(bean);

	}

	public static void testFindByPk() {

		CollegeModel model = new CollegeModel();

		CollegeBean bean = new CollegeBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getAddress());
		System.out.println(bean.getState());
		System.out.println(bean.getCity());
		System.out.println(bean.getPhoneNo());

	}

	public static void testFindByName() {

		CollegeModel model = new CollegeModel();

		CollegeBean bean = new CollegeBean();

		bean = model.findByName("IET DAVV");

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getAddress());
		System.out.println(bean.getState());
		System.out.println(bean.getCity());
		System.out.println(bean.getPhoneNo());

	}

	public static void testSearch() {

		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();

//		bean.setFirstName("virat");

		List<CollegeBean> list = model.search(bean, 1, 5);

		Iterator<CollegeBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getState());
			System.out.println(bean.getCity());
			System.out.println(bean.getPhoneNo());
			System.out.println("----------------");
		}

	}
}
