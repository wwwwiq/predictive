package predictive;

public class Words2SigsProto extends PredictivePrototype {
	
	public static void main(String[] args) {
		
			for (int i=0;i<args.length;i++) {
				
				System.out.println(args[i] + " = " + wordToSignature(args[i]));
				
		      
		    }       
	}
}
