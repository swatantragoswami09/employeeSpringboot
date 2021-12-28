package com.store.Maven;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TShirtController {
	
	//Creating tshirtview object
	TShirtView tshirtview=new TShirtView();
	
	// sort by rating
	  private static Float sortRating(String line) {
	        return Float.parseFloat( line.split("\\|")[6]);
	    }
	  
	// sort by price
	  private static Float sortPrice(String line) {
	        return Float.parseFloat( line.split("\\|")[5]);
	    }
	//Search Tshirt on user demand
	public void searchTShirt(String fileName,TShirt tshirt) throws IOException {
		
		List<String> l = null;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		Map<Float, List<String>> map = new TreeMap<Float, List<String>>();
		 String line = reader.readLine();//read header
		 

		 while ((line = reader.readLine()) != null) {
				 Float key;
				 if(tshirt.getoutput_Preference().toLowerCase().equals("price")) key = sortPrice(line);
				 else if(tshirt.getoutput_Preference().toLowerCase().equals("rating")) key = sortRating(line);
				 else {
					 key = sortPrice(line);
					 key = sortRating(line);
				 }
				 
	             l = map.get(key);
	            if (l == null) {
	                l = new LinkedList<String>();
	                map.put(key, l);
	            }
	            l.add(line);
	        }
		 //Calling display method
		 tshirtview .viewTShirt(map,tshirt);
		 
		 
		 
//		 for(Entry<Float, List<String>> e:map.entrySet()) {
//      	   System.out.println( e.getKey()+" => : "+ e.getValue());
//         }
	 
	}
		
		 
	
}
