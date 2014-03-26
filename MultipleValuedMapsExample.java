package predictive;

import java.util.*;

public class MultipleValuedMapsExample {

    public static void main(String args [])
    {
	//   key       value
	Map<Integer,TreeSet<String>> table = new HashMap<Integer,TreeSet<String>>();

	for (int i = 0; i < args.length; i++) {

	    int key = args[i].length();

	    if (table.get(key) == null) {
		
		TreeSet<String> emptySet = new TreeSet<String>();
	      
		table.put(key, emptySet);
	    }

	    TreeSet<String> values = table.get(key);

	    values.add(args[i]);
	}
	


	// For each entry e of the table, print the key and the value: 

	for (Map.Entry<Integer,TreeSet<String>> e : table.entrySet()) {

	    System.out.println("Key " + e.getKey() + " -> ");

	     for (String s : e.getValue())
	    	System.out.println(s);
	}
    }    
}