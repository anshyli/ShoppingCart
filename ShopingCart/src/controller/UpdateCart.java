package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TuserDB;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// get product id from the ListProducts.jsp
		//display product details and ask for purchase quantity  which will  add the lineitem to cart linkedlist
		//display cart and user can continue shopping or checkout
		model.Tuser tuser = new model.Tuser();
		model.T tPost = new model.T();
		String theMsg = request.getParameter("tmsg");    
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("loginname");
        tuser = TuserDB.selectUser(userName);
        request.setAttribute("profileusername", userName);
        request.setAttribute("profileusermotto", tuser.getMotto());
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(tuser.getJoindate().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        request.setAttribute("profiledate", sdf.format(sqlTime));
		
		getServletContext().getRequestDispatcher("/UserProfile.jsp").forward(request, response);	
	}
}
