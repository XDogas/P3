package aula13.Ex2;

import static java.lang.System.out;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test {
	
	public static void main(String[] args) throws IOException {

		Map<String, TreeMap<String, Integer>> map = Pares.readFile("src//aula13//Ex2//Policarpo.txt");
		
		for (String key : map.keySet()) {
			
			out.print(key + "={");
			Iterator<Entry<String, Integer>> iterator = map.get(key).entrySet().iterator();
			
			while (iterator.hasNext()) {
				
				Entry<String, Integer> entry = iterator.next();
				
				if (!iterator.hasNext()) out.print(entry.getKey() + "=" + entry.getValue() + "}");
				else out.print(entry.getKey() + "=" + entry.getValue() + ", ");
			}
			
			out.println();
		}

	}
}
