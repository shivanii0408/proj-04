package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.BookBean;
import in.co.rays.proj4.model.BookModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/BookCtl")

public class BookCtl extends BaseCtl<BookBean, BookModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("bookName"))) {
			request.setAttribute("bookName", "Book Name is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("author"))) {
			request.setAttribute("author", "Author is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("category"))) {
			request.setAttribute("category", "Category is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("publisher"))) {
			request.setAttribute("publisher", "Publisher is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("isbnNumber"))) {
			request.setAttribute("isbnNumber", "IsbnNumber is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected BookBean populateBean(HttpServletRequest request) {

		BookBean bean = new BookBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setBookName(DataUtility.getString(request.getParameter("bookName")));
		bean.setAuthor(DataUtility.getString(request.getParameter("author")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));

		bean.setPublisher(DataUtility.getString(request.getParameter("publisher")));
		bean.setIsbnNumber(DataUtility.getString(request.getParameter("isbnNumber")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.BOOK_VIEW;
	}

	@Override
	protected BookModel getModel() {
		return new BookModel();
	}

}