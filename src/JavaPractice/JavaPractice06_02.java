package JavaPractice;

import java.util.LinkedList;
import java.util.Queue;

public class JavaPractice06_02 {

	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new LinkedList<Integer>(), queue2 = new LinkedList<Integer>();
		
		for (int i : new int[] {3, 2, 5, 7, 2}) {
			queue1.add(i);
		}
		
		for (int i : new int[] {4, 6, 7, 1, 3}) {
			queue2.add(i);
		}
		
		System.out.println(getMoveCount(queue1, queue2));
		
	}
	
	public static int getMoveCount(Queue<Integer> queue1, Queue<Integer> queue2) {
		
		int sumQ1 = 0, sumQ2 = 0, sumQ = 0;
		
		for (int i = 0; i < queue1.size(); i++) {
			sumQ1 += queue1.peek();
			queue1.add(queue1.poll());
		}
		
		for (int i = 0; i < queue2.size(); i++) {
			sumQ2 += queue2.peek();
			queue2.add(queue2.poll());
		}
		
		sumQ = sumQ1 + sumQ2;
		
		if (sumQ % 2 == 1) {
			return -1;
		}
		
		int count = 0;
		
		System.out.println("queue1: " + queue1 + " = " + sumQ1);
		System.out.println("queue2: " + queue2 + " = " + sumQ2);
		System.out.println("--------");
		
		while (true) {

			if (sumQ1 < sumQ2) {
				queue1.add(queue2.poll());
			} else if (sumQ1 > sumQ2) {
				queue2.add(queue1.poll());
			}
			
			sumQ1 = 0;
			sumQ2 = 0;
			
			for (int i = 0; i < queue1.size(); i++) {
				sumQ1 += queue1.peek();
				queue1.add(queue1.poll());
			}
			
			for (int i = 0; i < queue2.size(); i++) {
				sumQ2 += queue2.peek();
				queue2.add(queue2.poll());
			}
			
			System.out.println("queue1: " + queue1 + " = " + sumQ1);
			System.out.println("queue2: " + queue2 + " = " + sumQ2);
			System.out.println("--------");
			
			count++;
			
			if (sumQ1 == sumQ2) {
				break;
			} else if (count > 100) {
				count = -1;
				break;
			}
			
		}
		
		return count >= 0 ? count : -1;
		
	}
	
}
