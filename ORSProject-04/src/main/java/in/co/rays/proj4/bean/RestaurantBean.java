package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantBean extends BaseBean {

	private String itemId;
	private String itemName;
	private String category;
	private double price;
	private boolean isAvailable;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setItemId(rs.getString("item_id"));
			this.setItemName(rs.getString("item_name"));
			this.setCategory(rs.getString("category"));
			this.setPrice(rs.getDouble("price"));
			this.setAvailable(rs.getBoolean("is_available"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getValue() {
		return null;
	}
}
