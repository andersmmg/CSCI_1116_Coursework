public class WordOccurrence implements Comparable<WordOccurrence> {
	private String word;
	private int num;
	
	public WordOccurrence(String word, int num) {
		this.word = word;
		this.num = num;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int compareTo(WordOccurrence w) {
		if (this.num < w.getNum()) {
			return -1;
		} else if (this.num == w.getNum()) {
			return 0;
		} else {
			return 1;
		}
	}
}