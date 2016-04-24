package startr;
import java.util.ArrayList;
import java.math.*;
import java.util.Map;
import java.lang.Object;
public class StartUp {
	
	// variables
	public ArrayList<String> font = new ArrayList<String>();
	// small, normal, big
	public ArrayList<String> size = new ArrayList<String>();
	public ArrayList<String> words = new ArrayList<String>();
	public ArrayList<String> image = new ArrayList<String>();
	public ArrayList<String> color = new ArrayList<String>();

	
	public StartUp(ArrayList<String> _audience, ArrayList<String> _category, ArrayList<String> _keywords) {

		// analyze data
		analyzeAudience(_audience);
		analyzeCategoryAndWords(_category, _keywords);
		
	}

	
	public void analyzeAudience(ArrayList<String> _audience) {
		size.add("normal");
		font.add("Homenaje");
		font.add("Poiret One");
		font.add("Montserrat Subrayada");
		
		if(_audience.contains("Kids")) {
			// kid friendly
			size.add("big");
			font.add("Patrick Hand");
			font.add("Chewy");
			font.add("Londrina Shadow");
		}
		
		if(_audience.contains("Elderly")) {
			// elderly friendly
			if(!_audience.contains("Kids")) {
				size.add("big");
			}
			font.add("Libre Baskerville");
			font.add("Abril Fatface");	
			font.add("Marcellus SC");
		}
		
		if(!_audience.contains("Kids") && !_audience.contains("Elderly")) {
			// trendy options
			size.add("small");
			font.add("Oswald");
			font.add("Wire One");
			font.add("Lobster");
			font.add("Megrim");
			font.add("Pacifico");
			font.add("Grand Hotel");
		}
	}
	
	public void analyzeCategoryAndWords(ArrayList<String> _category, ArrayList<String> _words) {
		
		if(_category.contains("Travel")) {
			// add fonts
			font.add("Great Vibes");
			font.add("Berkshire Swash");
			
			// images
			image.add("globe.png");
			image.add("map.png");
			
			// keywords
			if(_words.contains("Transportation")) {
				words.add("go");
				words.add("route");
				words.add("fly");
				words.add("zoom");
			}
			if(_words.contains("Lodging")) {
				words.add("stay");
				words.add("sleep");
				words.add("home");
			}
			if(_words.contains("Attractions")) {
				words.add("trip");
				words.add("vacation");
				words.add("travel");
				words.add("explore");
			}
			
		}
		
		if(_category.contains("Fitness")) {
			// add fonts
			font.add("Faster One");
			
			// images
			image.add("heartrate.png");
			image.add("running.png");
			
			// keywords
			if(_words.contains("Running")) {
				words.add("miles");
				words.add("run");
				words.add("step");
			}
			if(_words.contains("Diet")) {
				words.add("weight");
				words.add("health");
				words.add("heart");
				words.add("food");
			}
			if(_words.contains("Workout")) {
				words.add("sweat");
				words.add("burn");
				words.add("power");
				words.add("workout");
			}
		}
		
		if(_category.contains("Social Networking")) {
			// add fonts
			font.add("Lemon");
			font.add("Condiment");
			
			// images
			image.add("speechbubble.png");
			image.add("people.png");
			
			// keywords
			
			if(_words.contains("Chat")) {
				words.add("connect");
				words.add("talk");
				words.add("vibe");
			}
			if(_words.contains("Professional")) {
				words.add("link");
				words.add("job");
				words.add("work");
			}
			if(_words.contains("Dating")) {
				image.add("heart.png");
				
				words.add("match");
				words.add("chat");
				words.add("love");
				words.add("crush");
				words.add("date");
			}
		}
		
		if(_category.contains("Productivity")) {
			// add fonts
			font.add("Lateef");
			
			// keywords
			if(_words.contains("Note")) {
				image.add("check.png");
				words.add("note");
				words.add("write");
				words.add("reminder");
			}
			if(_words.contains("List")) {
				image.add("check.png");
				words.add("list");
				words.add("check");
				words.add("todo");
			}
			if(_words.contains("Calendar")) {
				image.add("cal.png");
				words.add("calendar");
				words.add("time");
				words.add("schedule");
			}
		}
		
		if(_category.contains("Finance")) {
			// add fonts
			font.add("Cinzel");
			font.add("Trocchi");
			
			// images
			image.add("money.png");
			image.add("piggy.png");
			
			// keywords
			
			words.add("money");
			
			if(_words.contains("Banking")) {
				words.add("manage");
				words.add("bank");
			}
			if(_words.contains("Investments")) {
				words.add("trade");
				words.add("invest");
			}
			if(_words.contains("Budget")) {
				words.add("save");
				words.add("budget");
				words.add("smart");
			}
		}
		
		if(_category.contains("Shopping")) {
			// add fonts
			font.add("Kenia");
			font.add("Rozha One");
			
			// images
			image.add("cart.png");
			image.add("purse.png");
			
			// keywords
			words.add("shop");
			words.add("buy");
			if(_words.contains("Clothing & Accessories")) {
				words.add("trend");
				words.add("hip");
				words.add("style");
				words.add("fashion");
				words.add("runway");
			}
			if(_words.contains("Home Goods")) {
				words.add("remodel");
				words.add("interior");
				words.add("decorate");
				words.add("home");
			}
			if(_words.contains("Electronics")) {
				words.add("gadget");
				words.add("device");
				words.add("tech");
			}
		}
		
		if(_category.contains("Media")) {
			// add fonts
			font.add("Aclonica");
			font.add("Yellowtail");
			
			// keywords
			if(_words.contains("Music")) {
				image.add("headphones.png");
				image.add("musicnote.png");
				words.add("radio");
				words.add("song");
				words.add("music");
				words.add("tune");
				words.add("beat");
				words.add("rhythm");
			}
			if(_words.contains("Videos")) {
				image.add("tv.png");
				words.add("stream");
				words.add("watch");
				words.add("flick");
				words.add("movie");
			}
			if(_words.contains("Photos")) {
				image.add("camera.png");
				words.add("collage");
				words.add("pic");
				words.add("photo");
				words.add("camera");
				words.add("snapshot");
			}
		}
		
		if(_category.contains("Education")) {
			// add fonts and logos
			font.add("Fredericka the Great");
			font.add("Schoolbell");
			font.add("Stardos Stencil");
			font.add("Chelsea Market");
			
			// images
			image.add("apple.png");
			image.add("pencil.png");
			image.add("cap.png");
			
			// keywords
			if(_words.contains("Study")) {
				words.add("quiz");
				words.add("flashcard");
				words.add("review");
				words.add("prep");
			}
			if(_words.contains("Learn")) {
				words.add("learn");
				words.add("brain");
				words.add("school");
			}
			if(_words.contains("Reference")) {
				words.add("word");
				words.add("dictionary");
				words.add("define");
			}
		}
	}
	
	public static class Logo {
		public String _font;
		public String _size;
		public String _image;
		public String _title;
		
		public Logo(String _f, String _s, String _i, String _t) {
			_font = _f;
			_size = _s;
			_image = _i;
			_title = _t;
		}
	}
	
	public Logo generate() {
		
		// pick font
		int font_ = (int) (Math.random() * font.size());
		
		// pick size
		int size_ = (int) (Math.random() * size.size());
		
		// pick image
		int image_ = (int) (Math.random() * image.size());
		
		// choice
		int random = (int) (Math.random() * 3);
		System.out.println(random);
		
		int word1 = (int) (Math.random() * words.size());
		int word2 = (int) (Math.random() * words.size());
		
		String title = "";
		
		if(random == 0) {
			// ending word
			String [] endings = {"ster", "ify", ".it", ".io", "ly", ".me", "fy", "bit"};
			int end = (int) (Math.random() * endings.length);
			title = words.get(word1) + endings[end];
		}
		else if(random == 1) {
			// word manipulation
			String s = words.get(word1);
			String s2 = words.get(word2);
			if(s.contains("i")) {
				s.replace('i','y');
				title = s;
			}
			else if (s2.contains("i")){
				s.replace('i','y');
				title = s;
			}
			else {
				// put text in the beginning
				String [] start = {"e", "i", ".", "//"};
				int e = (int) (Math.random() * start.length);
				title = start[e] + words.get(word1);
			}
		}
		else if(random == 2) {
			// 2 words
			int r = (int) (Math.random() * 2);
			if(r == 0) {
				// plus
				title = words.get(word1) + "+" + words.get(word2);
			}
			else if(r == 1) {
				// no space
				title = words.get(word1) + words.get(word2);
			}
			else {
				// dot
				title = words.get(word1) + "." + words.get(word2);
			}
		}
		
		Logo l = new Logo(font.get(font_), size.get(size_), image.get(image_), title);
		
		
		return l;
	}
	
}
