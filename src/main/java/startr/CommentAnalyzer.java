package startr;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CommentAnalyzer {

	public String text;
	public double score;

	public CommentAnalyzer(String _text) {
		text = _text;
	}

	public HttpResponse<JsonNode> doHTTP(String str) throws UnirestException {
		Gson g = new Gson();

		String body = "{\"text\": " + g.toJson(str, String.class) + "}";

		return Unirest.post("https://gateway.watsonplatform.net/tone-analyzer-beta/api/v3/tone?version=2016-02-11")
				.basicAuth("7f57a9af-0c6a-4731-a2ea-adbd5ffd4ecc", "QlwdyAT7Exfs")
				.header("Content-Type", "application/json")
				.body(body)
				.asJson();
	}

	public String analyze() {
		JsonNode res;
		score = 0.0f;

		try {
			res = doHTTP(text).getBody();
			
			System.out.println(res.toString());
			
			score = res.getObject()
					.getJSONObject("document_tone")
					.getJSONArray("tone_categories")
					.getJSONObject(1)
					.getJSONArray("tones")
					.getJSONObject(1)
					.getDouble("score");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String analysis = "Your Tone Confidence score is " + score + ". ";

		if (score > 0.5) {
			analysis += "Congratulations! This means that you have great confidence with your startup, which means you are on the road to success! I am sure that this startup will be the next hottest company. You have the gumption to do great in this dog eat dog startup world. Keep up the great work!";
		} else {
			analysis += "This means that you are not confident in your startup.  Being confident will help you get more money along the way of your startup journey, so you should really start to believe in yourself and your million dollar idea. Don't give up!";
		}

		return analysis;

	}

}
