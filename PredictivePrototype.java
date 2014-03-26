package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


public class PredictivePrototype {

	
	static String input;
	static StringBuffer output;
	static String signature;
	static Scanner dictionary = null;
	static String curr;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("Testing wordToSignature");
		input = in.nextLine();
		System.out.println(wordToSignature(input));
		System.out.println("Testing signatureToWords...");
		System.out.println(signatureToWords(wordToSignature(input)));
		
	}

	/**
	 * A method that converts a single String into a String 
	 * of integers as though the original String were typed 
	 * on a mobile phone keypad
	 * 
	 * @param Word The inputed word to be changed to numbers
	 * @return The String of numbers representing the word after conversion 
	 */
	
	public static String wordToSignature(String word) {
		
		word = word.toLowerCase();
		
		Hashtable<String, Integer> charTable = new Hashtable<String, Integer>();
		charTable.put("a", 2);
		charTable.put("b", 2);
		charTable.put("c", 2);
		charTable.put("d", 3);
		charTable.put("e", 3);
		charTable.put("f", 3);
		charTable.put("g", 4);
		charTable.put("h", 4);
		charTable.put("i", 4);
		charTable.put("j", 5);
		charTable.put("k", 5);
		charTable.put("l", 5);
		charTable.put("m", 6);
		charTable.put("n", 6);
		charTable.put("o", 6);
		charTable.put("p", 7);
		charTable.put("q", 7);
		charTable.put("r", 7);
		charTable.put("s", 7);
		charTable.put("t", 8);
		charTable.put("u", 8);
		charTable.put("v", 8);
		charTable.put("w", 9);
		charTable.put("x", 9);
		charTable.put("y", 9);
		charTable.put("z", 9);
		
		output = new StringBuffer("");
		
		for(int i = 0; i < word.length(); i++) { 
			if(!charTable.containsKey(Character.toString(word.charAt(i)))) {
				output.append(" ");
			} else {
				output.append(charTable.get(Character.toString(word.charAt(i))));
			}
		}
		
		/**
		
		StringBuffer has a specific method for appending Strings rather than 
		using the basic String addition. This is far more efficient in this case.
		
		 */
		
		signature = output.toString();
		
		return output.toString();
	}
	 public static boolean isValidWord(String word) 
	 {
		 String w;
		 w = word;
			for (int i = 0; i < w.length(); i++) {
				if (((int)w.charAt(i) < 65 )||((int)w.charAt(i) > 122 )) 
				{
					return false;
				}
				
			}
			
		  return true;
		
		 
	 }
	
	/**
	 * Takes a signature, or a String of integers and 
	 * converts it to a set of possible corresponding words 
	 * 
	 * @param signature The signature to be converted to a Set of possible corresponding Strings
	 * @return The set of possible corresponding Strings to the inputed signature
	 */
	
	 public static Set<String> signatureToWords(String signature) {

		 Set<String> convert = new HashSet<String>();
		 
		 try {
//			 Scanner fileIn = new Scanner (new File("/usr/share/dict/words"));
			 Scanner fileIn = new Scanner (new File("K:/Study/Software workshop/workspace/EX14/src/predictive/words.txt"));
			 while(fileIn.hasNext()) {
				String prev = fileIn.nextLine().toLowerCase();
				String curr = wordToSignature(prev).toString();
				if(signature.equals(curr)) {
					convert.add(prev);
				}
			 }
		 
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();			 
		 }		

		return convert;
	 }

}
