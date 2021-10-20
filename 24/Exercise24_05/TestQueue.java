 public class TestQueue {
	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>();

		queue.enqueue("Tom"); 
		System.out.println("(7) " + queue);

		queue.enqueue("Susan");
		System.out.println("(8) " + queue);

		queue.enqueue("Kim");
		queue.enqueue("Michael");
		System.out.println("(9) " + queue);

		System.out.println("(10) " + queue.dequeue());
		System.out.println("(11) " + queue.dequeue());
		System.out.println("(12) " + queue);
	}
}
