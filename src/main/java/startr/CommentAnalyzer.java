package startr;

import com.ibm.watson.developer_cloud.tone_analyzer.v3_beta.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3_beta.model.ToneAnalysis;

public class CommentAnalyzer {

	public String text;
	public double score;
	
	public CommentAnalyzer(String _text) {
		text = _text;
	}
	
	public String analyze() {
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_02_11);
		
		service.setUsernameAndPassword("7f57a9af-0c6a-4731-a2ea-adbd5ffd4ecc", "QlwdyAT7Exfs");
		
		ToneAnalysis tone = service.getTone(text).execute();
		
		tone.getDocumentTone().getTones().forEach(value -> {
			value.getTones().forEach(t -> {
				if(t.getName().equals("Confident")) {
					score = t.getScore();
				}
			});
		});
				
		String analysis = "Your Tone Confidence score is " + score + ". ";
		
		if(score > 0.5) {
			analysis+="Congratulations! This means that you have great confidence with your startup, which means you are on the road to success! I am sure that this startup will be the next hottest company. You have the gumption to do great in this dog eat dog startup world. Keep up the great work!";
		}
		else {
			analysis+="This means that you are not confident in your startup.  Being confident will help you get more money along the way of your startup journey, so you should really start to believe in yourself and your million dollar idea. Don't give up!";
		}
		
		return analysis;
		
	}
	
}
