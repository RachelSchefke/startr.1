package startr;

import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

public class Servlet implements spark.servlet.SparkApplication {

	/**
	 * 
	 */

	@Override
	public void init() {

		//get("/hello", (req, res) -> "Hello World");
		
		Gson gson = new Gson();

		post("/processData", (req, res) -> {
			
			
			FormData fd = gson.fromJson(req.body(), FormData.class);
			
			List<String> target = fd.getTarget();
			List<String> category = fd.getCategory();
			List<String> keywords = fd.getKeywords();
			
			StartUp start = new StartUp(target, category, keywords);
			
			
			return fd;
		}, gson::toJson);
	}

	public static void main(String[] args) {
		Servlet s = new Servlet();

		s.init();

	}
}
