package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FoodBean;
import in.co.rays.proj4.model.FoodModel;


public class TestFoodModel {


	public static FoodModel model = new FoodModel();

	public static void main(String[] args) {
		testAdd();
//		testUpdate();
//		testFindByOrderId();
//		testFindByPk();
//		testSearch();
	}

	private static void testAdd() {

		FoodBean bean = new FoodBean();

//		bean.setOrderId("101");
//
//		bean.setCustomerName("Tanisha");
//
//		bean.setRestaurant("Domino's");
//
//		bean.setOrderAmount(599);
//
//		bean.setDeliveryStatus("Delivered");
//
//		bean.setCreatedBy("admin");
//
//		bean.setModifiedBy("admin");
//
//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
//
//		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

	
		
	}

	private static void testUpdate() {
		FoodBean bean = new FoodBean();

		
		bean.setId(1);
		bean.setOrderId("101");

		bean.setCustomerName("Tanisha");

		bean.setRestaurant("Domino's");

		bean.setOrderAmount(499); //update 

		bean.setDeliveryStatus("Delivered");

//		bean.setCreatedBy("admin");

		bean.setModifiedBy("admin");

//		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));

		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		

		model.update(bean);

	}

	public static void testFindByPk() {

		FoodModel model = new FoodModel();

		FoodBean bean = new FoodBean();

		bean = model.findByPK(1);

		System.out.println(bean.getId());
		System.out.println(bean.getOrderId());
		System.out.println(bean.getCustomerName());
		System.out.println(bean.getRestaurant());
		System.out.println(bean.getOrderAmount());
		System.out.println(bean.getDeliveryStatus());
		

	}

	public static void testFindByOrderId() {

		FoodModel model = new FoodModel();

		FoodBean bean = new FoodBean();

		bean = model.findByOrderId("101");

		System.out.println(bean.getId());
		System.out.println(bean.getOrderId());
		System.out.println(bean.getCustomerName());
		System.out.println(bean.getRestaurant());
		System.out.println(bean.getOrderAmount());
		System.out.println(bean.getDeliveryStatus());
	}
	
	public static void testSearch() {

		FoodModel model = new FoodModel();
		FoodBean bean = new FoodBean();

//		bean.setFirstName("virat"); 

		List<FoodBean> list = model.search(bean, 1, 5);

		Iterator<FoodBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getOrderId());
			System.out.println(bean.getCustomerName());
			System.out.println(bean.getRestaurant());
			System.out.println(bean.getOrderAmount());
			System.out.println(bean.getDeliveryStatus());
			System.out.println("----------------");
		}

	}
	
}
