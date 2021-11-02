import java.util.*;

class Exercise22_03 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine().trim();		
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine().trim();
		
		int index = -1;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) { // 1 loop, ran n times (linear O(n) )
			if(s1.charAt(i) == s2.charAt(count)) {
				if (count == 0) { // Start here
					index = i;
					count = 1;
				}else{ // Continue scan
					count += 1;
				}
			} else { // No match
				count = 0;
				index = -1;
			}
			
			if (count == s2.length()) {
				break; // Matched
			}
		}
		
		if (index > 1) {
			System.out.println("matched at index "+ index);
		} else {
			System.out.println("no match found");
		}
	}
}