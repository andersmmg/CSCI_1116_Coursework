import java.util.*;

public class Exercise21_07 {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		HashMap<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}

		// Display key and value for each entry
		ArrayList<WordOccurrence> sortList = new ArrayList<WordOccurrence>();
		map.forEach((k, v) -> sortList.add(new WordOccurrence(k, v)));
		Collections.sort(sortList);
		sortList.forEach((n) -> System.out.println(n.getWord() + "\t" + n.getNum()));
	}
}