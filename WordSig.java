package predictive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;



public class WordSig implements Comparable<WordSig>{
//private String signature;
private String words;
private BigInteger signature; 
public WordSig (String words,String signature)
{ 
    this.words = words;
//    this.signature = signature;
    this.signature = new BigInteger (signature);
    
}
public String getwords() { return words; }
//public String getsignature() { return signature; }
public BigInteger getsignature() {return signature; }
public String toString() { return getwords()+" "+getsignature();}


public int SignatureCount(String word) {
	ArrayList<Integer> Slot = new ArrayList<Integer>();
	int cal = 0;
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
	

	
	for(int i = 0; i < word.length(); i++) { 
		if(!charTable.containsKey(Character.toString(word.charAt(i)))) {
			Slot.add(0);
		} else {
			Slot.add(charTable.get(Character.toString(word.charAt(i))));
		}
	}
	for(int i = 0; i < Slot.size(); i++) { 
		cal = (int) (cal + Slot.get(i) * Math.pow(10,Slot.size() - i));
		
	}
	
	Slot.clear();
	
	return cal;
}
    	

   /*
    
	public int compareTo(WordSig arg0, WordSig arg1)
    {
		
//    	PredictivePrototype a =new PredictivePrototype();
    	
    	if(b.SignatureCount(arg0.getwords()) > b.SignatureCount(arg1.getwords()))
    	    return 1;
    	else if(b.SignatureCount(arg0.getwords()) == (b.SignatureCount(arg1.getwords())))
    		return 0;
    	else
    		return -1;
    }
    */
	@Override
	public int compareTo(WordSig arg0) {
		// TODO Auto-generated method stub
//		return SignatureCount(this.getwords()).compareTo(SignatureCount(arg0.getwords()); 
		return this.getsignature().compareTo(arg0.getsignature());
		/*		
    	if(SignatureCount(words) > SignatureCount(arg0.getwords()))
    	    return 1;
    	else if(SignatureCount(words) == (SignatureCount(arg0.getwords())))
    		return 0;
    	else
    		return -1;
    		*/
    		
	}

 

}