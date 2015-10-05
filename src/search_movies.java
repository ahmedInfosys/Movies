

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBUtil;
import model.MShowtime;
import model.MTheatre;

@WebServlet("/search_movies")
public class search_movies extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public search_movies() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qString = "";
		if(request.getParameter("city/state") != null){
			Calendar cal = Calendar.getInstance();
			qString = "select distinct m.mDate from MShowtime m where m.MHall.MTheatre.city = ?1 or m.MHall.MTheatre.state = ?2"
					+ " and mDate > ?3 order by m.mDate";
			TypedQuery<MShowtime> q = DBUtil.createQuery(qString, MShowtime.class);
			q.setParameter(3,(cal.getTimeInMillis()/(1000*60*60*24))+"");
			String search = request.getParameter("city/state");
			List<MShowtime> shows = new ArrayList<MShowtime>();
			
			if(search.contains(","))search = search.replace(",", " ");
			
			for(String word:search.split(" ")){
				if(word.length() == 2) q.setParameter(2, word);
				else q.setParameter(1, word);
				
			}
			
			try{
				shows = q.getResultList();
			}catch(Exception e){
				shows = null;
			}
			
			if(shows == null){
				String invalid = "<p style=\"color:red\">Invalid city or state :(, please try again.</p>";
				request.setAttribute("invalid", invalid);
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("bdd");
				List<String> movies_dates = new ArrayList<String>();
				
				for(MShowtime show:shows){
					cal.setTimeInMillis((Long.parseLong(show.getMDate())));
					movies_dates.add(sdf.format(cal.getTime()));
				}
				HttpSession session = request.getSession();
				session.setAttribute("movies_dates", movies_dates);
			}
			

		}else{
			qString = "select m from MShowtime m where m.MHall.MTheatre.city = ?1 or m.MHall.MTheatre.state = ?2"
					+ " and mDate = ?3 order by m.mDate";
			TypedQuery<MShowtime> q = DBUtil.createQuery(qString, MShowtime.class);
			long movies_date = Long.parseLong(request.getParameter("ID"));
			q.setParameter(3,movies_date+"");
			String search = request.getParameter("city/state");
			List<MShowtime> shows = new ArrayList<MShowtime>();
			
			if(search.contains(","))search = search.replace(",", " ");
			
			for(String word:search.split(" ")){
				if(word.length() == 2) q.setParameter(2, word);
				else q.setParameter(1, word);
				
			}
			
			try{
				shows = q.getResultList();
			}catch(Exception e){
				shows = null;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shows", shows);
		}
		getServletContext().getRequestDispatcher("/movie_times.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
