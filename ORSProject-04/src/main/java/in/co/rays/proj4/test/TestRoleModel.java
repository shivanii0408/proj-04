package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.model.RoleModel;

public class TestRoleModel {

	public static RoleModel model = new RoleModel();

	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testFindByPk();
//		testFindByName();
		testSearch();
	}

	private static void testAdd() {

		RoleBean bean = new RoleBean();

//		bean.setName("KIOSK");
//		bean.setDescription("KIOSK Role");
//		bean.setCreatedBy("Tanisha");
//		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		bean.setName("MANAGER");
		bean.setDescription("Manager Role");
		bean.setCreatedBy("Tanisha");
		bean.setModifiedBy("Tanisha");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.add(bean);

	}

	private static void testUpdate() {
		RoleBean bean = new RoleBean();

		bean.setId(6);
		bean.setName("Admin");
		bean.setDescription("Admin Role");
//		bean.setCreatedBy("Tanisha");
		bean.setModifiedBy("Tanisha");
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		model.update(bean);
	}
	
	public static void testFindByPk() {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();

		bean = model.findByPK(2);

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());

	}
	
	public static void testFindByName() {

		RoleModel model = new RoleModel();

		RoleBean bean = new RoleBean();

		bean = model.findByName("Faculty");

		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());

	}
	
	
	public static void testSearch() {

		RoleModel model = new RoleModel();
		RoleBean bean = new RoleBean();

		List<RoleBean> list = model.search(bean, 1, 5);

		Iterator<RoleBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println("----------------");
		}

	}

	
}
