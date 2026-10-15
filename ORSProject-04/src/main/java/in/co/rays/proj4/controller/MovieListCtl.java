package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.MovieBean;
import in.co.rays.proj4.model.MovieModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/MovieListCtl")

public class MovieListCtl extends BaseListCtl<MovieBean, MovieModel> {

	@Override
	protected MovieBean populateBean(HttpServletRequest request) {
		MovieBean bean = new MovieBean();
		bean.setTitle(DataUtility.getString(request.getParameter("title")));
		bean.setGenre(DataUtility.getString(request.getParameter("genre")));
//		bean.setPhysics(DataUtility.getInt(request.getParameter("physcis")));
//		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));
//		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.MOVIE_LIST_VIEW;
	}

	@Override
	protected MovieModel getModel() {
		return new MovieModel();
	}

}
