package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DictionaryMapImpl extends PredictivePrototype implements Dictionary{
	private static Scanner dictRead;
	private static Map<BigInteger,Set<String>> table;
	public DictionaryMapImpl(File file) {
		super();
		ReadFile(file);
		// TODO Auto-generated constructor stub

	}
public static void main(String args [])
{
	DictionaryMapImpl obj = new DictionaryMapImpl(new File("K://Study/Software workshop/workspace/EX14/src/predictive/words.txt"));
//	DictionaryMapImpl obj = new DictionaryMapImpl(new File("/usr/share/dict/words"));
//	private Map<BigInteger,Set<String>> map = new Map<BigInteger,Set<String>>(null,null);
	//printMap(table);
	System.out.println("Hi");
	System.out.println("Key " + table.get(0) + " -> ");
}
@Override
public void ReadFile(File _file) {
	// TODO Auto-generated method stub
	try {
		  if (checkBeforeReadfile(_file)){
	   dictRead = new Scanner(_file);
	   table = new HashMap<BigInteger,Set<String>>();
	   
	   while (dictRead.hasNext()) {
	    String next = dictRead.nextLine().toLowerCase();
	    if(isValidWord(next)) {
	     BigInteger sig = new BigInteger(wordToSignature(next));
	     table.put(sig,signatureToWords(wordToSignature(next)));
	    }
	   }	

		  }else{
		        System.out.println("Can't find the file");
		      }
	  } catch (FileNotFoundException e) {
	   e.printStackTrace();
	  }
	  }

	  private static boolean checkBeforeReadfile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canRead()){
	        return true;
	      }
	    }

	    return false;
	
}
@Override
public void printList() {
	// TODO Auto-generated method stub
	
}
@Override
public void printSet(Set<String> set) {
	// TODO Auto-generated method stub




}
	


public static void printMap(Map<BigInteger, Set<String>> map) {
	// TODO Auto-generated method stub
	//For each entry e of the table, print the key and the value: 

	for (Map.Entry<BigInteger,Set<String>> e : table.entrySet()) {

	   System.out.println("Key " + e.getKey() + " -> ");

	    for (String s : e.getValue())
	   	System.out.println(s);
	
}  

}


}
