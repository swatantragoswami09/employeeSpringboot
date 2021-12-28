package TshirtPreference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TShirtView {
	

	 List<String> v=new ArrayList<String>();
	 Map<Float, List<String>> map = new TreeMap<Float, List<String>>();

	// sort by rating
	  private static Float sortRating(String line) {
	        return Float.parseFloat( line.split("\\|")[6]);
	    }
	  
	// sort by price
	  private static Float sortPrice(String line) {
	        return Float.parseFloat( line.split("\\|")[5]);
	    }
	  
	  //Check whether string is present in line or not
	  private static boolean isContain(String source, String subItem){
	         String pattern = subItem;
	         Pattern p=Pattern.compile(pattern);
	         Matcher m=p.matcher(source);
	         return m.find();
	    }
	  
	// Display available tshirts
	public void viewTShirt( Map<Float, List<String>> map,TShirt tshirt) {
		List<String> result = new ArrayList<String>();
		boolean col=false;
		 boolean gen=false;
		 boolean size=false;
		 for(Map.Entry<Float, List<String>> entry : map.entrySet()) {
			 
			  v=entry.getValue();
			  for(int i=0;i<v.size();i++) {
				 String[] words=v.get(i).split("\\|");

				 col= isContain(words[2].toLowerCase(),tshirt.getcolor());
				 gen= isContain(words[3].toLowerCase(),tshirt.getgender());
				 size= isContain(words[4].toLowerCase(),tshirt.getsize());
				
				if(col && size && gen) {
					result.add(v.get(i));
				}
			 }
		}
		 if(col && size && gen) {
			 display(result,tshirt);
		 }
		 else {
			 System.out.println("Item not present ");
		 }
//		 result.forEach((n) -> System.out.println(n));
					
	}//end of function
	
	public void display(List<String> result,TShirt tshirt) {
		Float key;
		List<String> l = null;
		for(int i=0;i<result.size();i++) {	
			if(tshirt.getoutput_Preference().toLowerCase().equals("price")) key = sortPrice(result.get(i));
			 else if(tshirt.getoutput_Preference().toLowerCase().equals("rating")) key = sortRating(result.get(i));
			 else {
				 key = sortPrice(result.get(i));
				 key = sortRating(result.get(i));
			 }
			 if (l == null) {
	             l = new LinkedList<String>();
	             map.put(key, l);
	         }
	         l.add(result.get(i));
	         
	        l.forEach((n)->System.out.println(n));    
		}
		
	}
	
}


