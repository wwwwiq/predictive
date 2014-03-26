package predictive;

public class Sigs2WordsProto extends PredictivePrototype {
	
	public static void main(String[] args) {
		
			for (int i=0;i<args.length;i++) {
				
				System.out.println(args[i] + " = " + signatureToWords(args[i]));
				
		      
		    }       
	}
}
