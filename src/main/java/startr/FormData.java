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
		//map.put();
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
