package startr;

import static spark.Spark.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import startr.StartUp.Logo;

public class Servlet extends spark.servlet.SparkFilter implements spark.servlet.SparkApplication {
    private static final HashMap<String, String> corsHeaders = new HashMap<String, String>();
    
    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }
    
	@Override
	public void init() {
		
		before((request, response) -> {
			corsHeaders.forEach((key, value) -> {
                response.header(key, value);
            });
		});
		
		get("/", (req, res) -> {
			 res.redirect("index.html");
			 //res.type("text/html");
			 return res;
			});
			
		
		Gson gson = new Gson();

		post("/processData", (req, res) -> {
			
			
			FormData fd = gson.fromJson(req.body(), FormData.class);
			
			List<String> target = fd.getTarget();
			List<String> category = fd.getCategory();
			List<String> keywords = fd.getKeywords();
			
			StartUp start = new StartUp(target, category, keywords);
			
			List<Logo> result = new ArrayList<Logo>();
			
			for(int i = 0; i < 3; i++) {
				result.add(start.generate());
			}
			
			return result;
		}, gson::toJson);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
		String requestUrl = ((HttpServletRequest) req).getRequestURI().toString();
		
		Map<String, String> mimeMapping = new HashMap<>();
        
		mimeMapping.put(".css","text/css");
        mimeMapping.put(".js","text/javascript");
        mimeMapping.put("/", "text/html");

        for(Map.Entry<String,String> entry : mimeMapping.entrySet())
        {
            if(requestUrl.endsWith(entry.getKey()))
            {
                ((HttpServletResponse) res).setHeader("Content-Type",entry.getValue());
            }
        }
        
        super.doFilter(req, res, chain);
	}

	public static void main(String[] args) {
		Servlet s = new Servlet();

		s.init();

	}
}
