package strockContoller;

import java.awt.print.Printable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.net.URL;
import java.net.HttpURLConnection;

/**
 * Servlet implementation class stockControllerSignin
 */
@WebServlet("/stockControllerSignin")
public class stockControllerSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stockControllerSignin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("action").equals("userSignin")) {
			
			String name = request.getParameter("user_name");
			String password = request.getParameter("user_password");
			String url = "https://dev13.jhuep.com/StockTracker/user/signin?email=" + name + "&password=" + password;
			System.out.print(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			//con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == 200) { // success
				String message = "User logged in succesfully";
				request.setAttribute("message",  message);
				String goToUrl = "/index.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			} else {
				String message = "Unable to verify user";
				request.setAttribute("message",  message);
				String goToUrl = "/index.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			}
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
