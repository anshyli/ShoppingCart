package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
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
		System.out.println("Product Details");
/*	 	System.out.println("productName" + ((model.Product) request.getAttribute("productName")).getDescription());
		System.out.println("productDesc" + request.getParameter("productDesc"));*/
		System.out.println("productId" + request.getParameter("productId"));
//		System.out.println("productName" + (String) request.getAttribute("productName"));
		// get product id from the ListProducts.jsp
//		System.out.println("productName" + request.getAttribute("productName").toString());
//		System.out.println("productDesc" + request.getParameter("productDesc"));
		Enumeration<String> params = request.getAttributeNames(); 
		while(params.hasMoreElements()){			
		 String paramName = (String)params.nextElement();
		 System.out.println("Attribute Name - "+paramName+", Value - "+ request.getAttribute(paramName));
		}
		//display product details and ask for purchase quantity  which will  add the lineitem to cart linkedlist
		

/*		model.Tuser tuser = new model.Tuser();
		model.T tPost = new model.T();
		String theMsg = request.getParameter("tmsg");    
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("loginname");
        tuser = TuserDB.selectUser(userName);
        request.setAttribute("profileusername", userName);
        request.setAttribute("profileusermotto", tuser.getMotto());
        java.sql.Timestamp sqlTime = new java.sql.Timestamp(tuser.getJoindate().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        request.setAttribute("profiledate", sdf.format(sqlTime));*/
		//display cart and user can continue shopping or checkout		
		getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(request, response);	
	}
}
