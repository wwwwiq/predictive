package predictive;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;



/**
 * @author Fanise
 * DictionaryListImpl class for import the dictionary into a array list.
 *
 */
public class DictionaryListImpl extends PredictivePrototype {
	public static String now;
	private static ArrayList<WordSig> dictEnt = new ArrayList<WordSig>();
    private Scanner dictRead;
 //   public static WordSig entry = new WordSig(null, null);
 //   public static WordSig search = new WordSig(null,null);
	/** Constructor
	 * @param file the dictionary file
	 */

	public DictionaryListImpl(File file) {
		ReadFile(file);
		Collections.sort(dictEnt);	


		 }
	/**Read dictionary file from the file and put them into the array list
	 * @param file the dictionary file
	 */
	 private void ReadFile(File _file) {
		 try {
			  if (checkBeforeReadfile(_file)){
		   dictRead = new Scanner(_file);
		   dictEnt = new ArrayList<WordSig>();
		   
		   while (dictRead.hasNext()) {
		    String next = dictRead.nextLine().toLowerCase();
		    if(isValidWord(next)) {
		     WordSig entry = new WordSig(next, wordToSignature(next));
		     dictEnt.add(entry);
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


			/**
			 * @param _dictEnt the array list
			 *
			 */
private static void printList(ArrayList<WordSig> _dictEnt)
{
	for(int i = 0; i < _dictEnt.size(); i++) { 

//		System.out.println(_dictEnt.get(_dictEnt.size()-1).toString()); 
		System.out.println(_dictEnt.get(i).toString()); 

	}
}
	public static void main(String[] args) {


		DictionaryListImpl reader = new DictionaryListImpl(new File("K://Study/Software workshop/workspace/EX14/src/predictive/words.txt"));
//		DictionaryListImpl reader = new DictionaryListImpl(new File("/usr/share/dict/words"));


//		printList(dictEnt);
//		System.out.println(dictEnt.get(0).toString()); 
		printSet(signatureToWords(wordToSignature("ag"), dictEnt));
//		printSet(signatureToWords("222", dictEnt));

		/*
		Scanner in = new Scanner(System.in);
				
		System.out.println("Testing wordToSignature");
		input = in.nextLine();
		System.out.println(wordToSignature(input));
		System.out.println("Testing signatureToWords...");
		System.out.println(signatureToWords(wordToSignature(input)));
		*/	
	}
	/**
	 * @param the Set contains words
	 * 
	 */
public static void printSet(Set<String> set)
{
	
	System.out.print("The set:\n   ");

    for (String s : set)
        System.out.print(s + " ");

    System.out.println("\n");
}

/**
 * @param the signature
 * @param _dictEnt the array list
 * @return the set contains words with same signature 
 */
	 public static Set<String> signatureToWords(String signature, ArrayList<WordSig> _dictEnts) {

			Set<String> convert = new HashSet<String>();	
			
			WordSig search = new WordSig("",signature);
//			System.out.println(search.toString()); 
//			int result = 0;
			int result = Collections.binarySearch(_dictEnts, search);
			convert.add(_dictEnts.get(result).getwords());
//			System.out.println(result); 
			/*
			while(result >= 0)
			{
				result = Collections.binarySearch(_dictEnts, search);
				convert.add(_dictEnts.get(result).getwords());
				_dictEnts.remove(result);
				
			}
			*/
			
			
			int iterator = result;
			while(_dictEnts.get(iterator).getsignature().equals(_dictEnts.get(iterator+1).getsignature())) {
				convert.add(_dictEnts.get(iterator+1).getwords());
				iterator++;
			}
			iterator = result;
			while(_dictEnts.get(iterator).getsignature().equals(_dictEnts.get(iterator-1).getsignature())) {
				convert.add(_dictEnts.get(iterator+1).getwords());
				iterator--;
			}
			
			return convert;
			
	
		}


}
