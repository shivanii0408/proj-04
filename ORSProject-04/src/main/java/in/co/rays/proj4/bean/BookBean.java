package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBean extends BaseBean {
	private String bookName;
	private String author;
	private String category;
	private String publisher;
	private String isbnNumber;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setResultset(ResultSet rs) {
		try {
			super.setResultset(rs);
			this.setBookName(rs.getString("book_name"));
			this.setAuthor(rs.getString("author"));
			this.setCategory(rs.getString("category"));
			this.setPublisher(rs.getString("publisher"));
			this.setIsbnNumber(rs.getString("isbnNumber"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}