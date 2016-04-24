package startr;

import static spark.Spark.get;

public class Servlet implements spark.servlet.SparkApplication {

	/**
	 * 
	 */

	@Override
	public void init() {

		get("/hello", (req, res) -> "Hello World");
	}

	public static void main(String[] args) {
		Servlet s = new Servlet();

		s.init();

	}
}
