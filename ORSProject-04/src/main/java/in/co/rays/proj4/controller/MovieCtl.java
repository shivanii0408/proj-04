package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.MovieBean;
import in.co.rays.proj4.model.MovieModel;
import in.co.rays.proj4.util.DataUtility;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/ctl/MovieCtl")

public class MovieCtl extends BaseCtl<MovieBean, MovieModel> {

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("movieId"))) {
			request.setAttribute("movieId", "Movie Id is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("title"))) {
			request.setAttribute("title", "Title is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("genre"))) {
			request.setAttribute("genre", "Genre is require");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("duration"))) {
			request.setAttribute("duration", "Duration is require");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("rating"))) {
			request.setAttribute("rating", "Rating is require");
			pass = false;
		}

		return pass;
	}

	@Override
	protected MovieBean populateBean(HttpServletRequest request) {

		MovieBean bean = new MovieBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setMovieId(DataUtility.getString(request.getParameter("movieId")));
		bean.setTitle(DataUtility.getString(request.getParameter("title")));
		bean.setGenre(DataUtility.getString(request.getParameter("genre")));

		bean.setDuration(DataUtility.getInt(request.getParameter("duration")));
		bean.setRating(DataUtility.getDouble(request.getParameter("rating")));

		populateDTO(bean, request);

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.MOVIE_VIEW;
	}

	@Override
	protected MovieModel getModel() {
		return new MovieModel();
	}

}
