

import java.io.IOException;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.DBUtil;
import model.MAdmin;

@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignIn() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Email = "", Password = "";
		Email = request.getParameter("email");
		Password = request.getParameter("password");
		String qString = "select m from MAdmin m where m.email = ?1 and m.password = ?2";
		TypedQuery<MAdmin> q = DBUtil.createQuery(qString, MAdmin.class);
		q.setParameter(1, Email).setParameter(2, Password);
		String Page = "";
		MAdmin user = new MAdmin();
		try{
			 user = q.getSingleResult();
		}catch(Exception e){
			 user = null;
		}
		
		
		if(user == null){
			String invalid = "<p style=\"color:red;white-space:pre-line;\">Invalid Email/Password, please insert a valid email and password, or <a href=\"Signup.jsp\">Sign up</a> if you don't have an account</p>";
			request.setAttribute("invalid", invalid);
			Page = "/Login.jsp";
		}else{
			HttpSession session = request.getSession();	
			session.setAttribute("user", user);
			Page = "/index.jsp";
		}
		
		//doPost(request,response,Page);
		getServletContext().getRequestDispatcher(Page).forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
