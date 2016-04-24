package startr;

import static spark.Spark.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/")
public class Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2344357533926691472L;

	@Override
	public void init() throws ServletException {
		super.init();
		
		get("/hello", (req, res) -> "Hello World");
	}
	
	public static void main(String[] args) {
		Servlet s = new Servlet();
		
		try {
			s.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
