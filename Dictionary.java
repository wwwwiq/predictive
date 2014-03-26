package predictive;

import java.io.File;
import java.math.BigInteger;
import java.util.Map;
import java.util.Set;

public interface Dictionary {
	
	void ReadFile(File _file);
	void printList();
	void printSet(Set<String> set);
//	void printMap(Map<BigInteger,Set<String>> map);
	

}
