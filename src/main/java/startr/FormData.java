package startr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormData {
	
	public Map<String, Boolean> target;
	public Map<String, Boolean> category;
	public Map<String, Boolean> keywords;
	public String comments;
	
	public static final Map<String, String> map;
	static {
		map = new HashMap<String, String>();
		map.put("kids", "Kids");
		map.put("teens", "Teens");		
		map.put("adults", "Adults");
		map.put("elderly", "Elderly");
		map.put("travel", "Travel");
		map.put("transportation", "Transportation");
		map.put("lodging", "Lodging");
		map.put("attractions", "Attractions");
		map.put("fitness", "Fitness");
		map.put("running", "Running");
		map.put("diet", "Diet");
		map.put("workout", "Workout");
		map.put("social", "Social Networking");
		map.put("chat", "Chat");
		map.put("professional", "Professional");
		map.put("dating", "Dating");
		map.put("productivity", "Productivity");
		map.put("note", "Note");
		map.put("list", "List");
		map.put("calendar", "Calendar");
		map.put("finance", "Finance");
		map.put("banking", "Banking");
		map.put("investments", "Investments");
		map.put("budget", "Budget");
		map.put("shopping", "Shopping");
		map.put("clothing", "Clothing & Accessories");
		map.put("home", "Home Goods");
		map.put("electronics", "Electronics");
		map.put("medai", "Media");
		map.put("music", "Music");
		map.put("video", "Videos");
		map.put("photo", "Photos");
		map.put("education", "Education");
		map.put("study", "Study");
		map.put("learn", "Learn");
		map.put("reference", "Reference");

	}
	
	public List<String> getTarget() {
		
		List<String> list =  target.entrySet().stream().filter(e->e.getValue()).map(e -> e.getKey()).collect(Collectors.toList());
	
		return list;
	}
	
	public List<String> getCategory() {
		
		List<String> list =  category.entrySet().stream().filter(e->e.getValue()).map(e -> e.getKey()).collect(Collectors.toList());
	
		return list;
	}
	
	public List<String> getKeywords() {
		
		List<String> list =  keywords.entrySet().stream().filter(e->e.getValue()).map(e -> e.getKey()).collect(Collectors.toList());
	
		return list;
	}
}
