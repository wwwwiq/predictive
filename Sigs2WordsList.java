package predictive;

import java.io.File;

public class Sigs2WordsList extends DictionaryListImpl {
	public static void main(String[] args) {
		
		for (int i=0;i<args.length;i++) {
			
			System.out.println(args[i] + " = " + signatureToWords(args[i]));
			
	      
	    }       
}
	public Sigs2WordsList(File file) {
		super(file);
		// TODO Auto-generated constructor stub
	}

}
