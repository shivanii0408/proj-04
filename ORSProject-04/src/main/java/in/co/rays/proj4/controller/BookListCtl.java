
package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.BookBean;
import in.co.rays.proj4.model.BookModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/BookListCtl")

public class BookListCtl extends BaseListCtl<BookBean, BookModel> {

	@Override
	protected BookBean populateBean(HttpServletRequest request) {
		BookBean bean = new BookBean();
		bean.setBookName(DataUtility.getString(request.getParameter("book_name")));
		bean.setAuthor(DataUtility.getString(request.getParameter("author")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.BOOK_LIST_VIEW;
	}

	@Override
	protected BookModel getModel() {
		return new BookModel();

	}
}