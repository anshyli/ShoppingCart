package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import customTools.*;
import model.*;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("loginname");
        //getUserByName
        Shopper aShopper = customTools.ShopperDB.getUserByName(userid);
        int quanty = Integer.parseInt(request.getParameter("qty"));         
        String pId = request.getParameter("Prodid");    
 		// get product by id
		model.Product theP = customTools.ProductDB.getProduct(Integer.parseInt(pId));
		BigDecimal total = theP.getUnitprice().multiply(new BigDecimal(quanty));
		Lineitem aLineitem = new Lineitem();
		aLineitem.setProduct(theP);
		aLineitem.setQuantity(quanty);
		aLineitem.setTotal(total);
		aLineitem.setShopper(aShopper);
		LinkedList<Lineitem> myCart = null;
		myCart.add(aLineitem);
		for (Lineitem anItem : ShopperDB.getTheCart()){
			if (anItem.getId() == aShopper.getId()) myCart.add(anItem);
		}
		request.setAttribute("MyCart", myCart);
		
		getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(request, response);	
	}
}
