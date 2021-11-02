import java.util.*;

public class Exercise22_01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> current = new LinkedList<>();
        LinkedList<String> maximum = new LinkedList<>();
        
        System.out.print("Enter a string: ");
        String entry = input.nextLine().trim();
        
        for (int i = 0; i < entry.length(); i++) {
            if (current.size() > 1 
                && entry.charAt(i) <= current.getLast().charAt(0) 
                && current.contains(String.valueOf(entry.charAt(i)))) {
                current.clear();
            }

            current.add(String.valueOf(entry.charAt(i)));

            if (current.size() > maximum.size()) {
                maximum.clear();
                maximum.addAll(current);
            }
        }
        
        System.out.print("Maximum consecutive substring is ");
        for (String i : maximum) {
            System.out.print(i);
        }
    }
}