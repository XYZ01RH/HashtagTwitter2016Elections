//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//import java.util.Set;
//import java.util.Scanner;

/**
 * @author rileyZ
 *
 */
public class FinalProject {
	
	@SuppressWarnings("static-access")
	public static String removePunctuation(String str) {
		String s = "";
		str.toLowerCase();
		for(Character c : str.toCharArray()) {
			if(Character.isDigit('#')) {
				continue;
			} else if(Character.isDigit('.') || Character.isDigit(',')) {
				break;
			}
			else if(Character.isLetterOrDigit(c)) {   //still a hashtag #BlackMirrorthis that is now BlackMirrorthis
				s += c.toLowerCase(c);							// also still might be getting a #something #else as one #
			}
		} 
		return s;
	}
	
	/**
	 * @param args
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ParseException, IOException, FileNotFoundException, NullPointerException {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String input = null;
		File output = new File("magaafter.csv");
		String line = null;
		//String regex = " ";
		String r = "#";
		String target = "maga";
		int tCount = 0;
		
		/**
		 *  Read csv file and initiate City objects for each entry in file
		 *  Put each entry into the HashMap
		 */
		if( args[0] != null ) {
			input = args[0];
			//BufferedReader br;
			try {
				Scanner sc = new Scanner(new FileReader(input));
				while(sc.hasNext()) { 
					line = sc.next();
					for(int i = 0; i < line.length(); i++) { 
						if(line.startsWith(r)) {
							line = removePunctuation(line);
							if(line.equals(target)) {
								tCount++;
								map.put(line, tCount);
							} else if(map.containsKey(line)) {
								map.put(line, map.get(line) + 1);
							} else {
								int x = 1;
								map.put(line, x);
							}
						} else {
							continue;
						}
					}
				}
				
				Object[] a = map.entrySet().toArray();
				Arrays.sort(a, new Comparator() {
					public int compare(Object o1, Object o2) {
						return ((Map.Entry<String, Integer>) o2).getValue()
								.compareTo(((Map.Entry<String, Integer>) o1).getValue());
					}
				});
				PrintWriter pw = new PrintWriter(output);
				for(Object e : a) {
					pw.println(target + "," + ((Map.Entry<String, Integer>) e).getKey() + "," + 
							((Map.Entry<String, Integer>) e).getValue());
				}
				
				//Set<Map.Entry<String, Integer>> set = map.entrySet();
				//Iterator<Map.Entry<String, Integer>> it = set.iterator();
				//while(it.hasNext()) {
					//Map.Entry<String, Integer> element = it.next();
					//pw.println(element.getKey() + " " + element.getValue());			
				//}
				pw.close();
				sc.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch(NullPointerException e) {
				e.printStackTrace();
			}
		} 
	}

//	@Override
//	public int compare(Object o1, Object o2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}	
}
