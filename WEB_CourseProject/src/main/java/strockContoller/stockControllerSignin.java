package strockContoller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
import org.json.JSONObject;

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
			// con.getIfModifiedSince()
			System.out.println("GET Response Code :: " + responseCode);
			//String message = con.getResponseMessage();
			if (responseCode == 200) { // success
				String message = "User logged in successfully";
				request.setAttribute("message",  message);
				String goToUrl = "/TrackerDisplay.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			} else {
				String message = "Unable to verify user";
				request.setAttribute("message",  message);
				String goToUrl = "/index.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			}
		
		} else if (request.getParameter("action").equals("userSignUp")) {
			
			String name = request.getParameter("user_name");
			String password = request.getParameter("user_password");
			String firstName = request.getParameter("user_firstName");
			String lastName = request.getParameter("user_lastName");
			
			String url = "https://dev13.jhuep.com/StockTracker/user/signup";
			System.out.print(url);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("PUT");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestMethod("PUT");
			
			JSONObject cred   = new JSONObject();
			cred.put("firstname",firstName);
			cred.put("lastname", lastName);
			cred.put("email", name);
			cred.put("password", password);

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(cred.toString());
			wr.flush();
			
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			String message = con.getResponseMessage();
			
			if (responseCode == 201) { // success
				// String message = "User logged in successfully";
				request.setAttribute("message",  message);
				String goToUrl = "/TrackerDisplay.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			} else {
				// String message = "Unable to verify user";
				request.setAttribute("message",  "User already exist");
				String goToUrl = "/index.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
				dispatcher.forward(request, response);	
			}
		
		} else {
			request.setAttribute("message",  "Sorry, error in page redirection, please try again");
			String goToUrl = "/index.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(goToUrl);
			dispatcher.forward(request, response);	
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
