

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.MAdmin;
import model.MMovy;
import model.MReview;

@WebServlet("/movie_details")
public class movie_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public movie_details() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long movie_id = Long.parseLong(request.getParameter("movie_id"));
		String qString = "select m from MMovy m where m.id = ?1";
		TypedQuery<MMovy> q = DBUtil.createQuery(qString, MMovy.class);
		q.setParameter(1, movie_id);
		MMovy movie = q.getSingleResult();
		
		String Page = "";
		
		if(request.getParameter("comment") != null){
			Page = "/movie_reviews.jsp";
			Calendar cal = Calendar.getInstance();
			int rating_scale = Integer.parseInt(request.getParameter("scale"));
			String review = request.getParameter("comment");
			
			
			HttpSession session = request.getSession(true);	
			MAdmin user = (MAdmin) session.getAttribute("user");
			
			
			MReview store_review = new MReview();
			store_review.setMAdmin(user);
			store_review.setMMovy(movie);
			store_review.setRatingscale(rating_scale);
			store_review.setReview(review);
			store_review.setRDate((cal.getTimeInMillis()/(1000*60)) + "");
			
			DBUtil.addToDB(store_review);
			
		}else{
			Page = "/overview.jsp";
		}
		
		qString = "select m from MReview m where m.MMovy = ?1 order by m.rDate desc";
		TypedQuery<MReview> q2 = DBUtil.createQuery(qString, MReview.class);
		q2.setParameter(1, movie);
		
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy");
		
		List<MReview> reviews = q2.getResultList();
		List<String> review_dates = new ArrayList<String>();
		
		Calendar cal = Calendar.getInstance();
		
		double sum = 0,avg_rating;
		int number_of_reviews = reviews.size();
		for(MReview review:reviews){
			sum += review.getRatingscale();
			cal.setTimeInMillis(Long.parseLong(review.getRDate())*1000*60);
			review_dates.add(sdf.format(cal.getTime()));
		}
		avg_rating = (number_of_reviews == 0) ? 0:sum/number_of_reviews;
        
		
		HttpSession session = request.getSession();	
		session.setAttribute("movie", movie);
		session.setAttribute("reviews", reviews);
		session.setAttribute("number_of_reviews", number_of_reviews);
		session.setAttribute("avg_rating", avg_rating);
		session.setAttribute("review_dates", review_dates);
		getServletContext().getRequestDispatcher(Page).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
