package JavaPractice;

import java.util.Scanner;

import app.MyCalc;

public class JavaPractice05_01 {

	public static void main(String[] args) {
		
		/*
		 * #1
		 */
		
		MyPoint a = new MyPoint(3, 20);
		System.out.println(a);
		
		/*
		 * #2
		 * I love java programming.
		 * Am I love java programming?
		 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,
		 * exit
		 */
		
		Scanner scanner = new Scanner(System.in);
		String line = null;
		while(!(line = scanner.nextLine()).equals("exit")) {
			System.out.println("어절 개수는 " + line.split(" ").length);
		}
		System.out.println("종료합니다..");
		
		scanner.close();
		
		/*
		 * #3
		 */
		
		MyCalc calc = new MyCalc();
		System.out.println(calc.add(5, 7));
		System.out.println(calc.sub(7, 5));
		System.out.println(calc.mult(7, 8));
		System.out.println(calc.div(9, 2));
		System.out.println(calc.abs_value(-24));
		System.out.println(calc.power(2, 4));
		System.out.println(calc.avg(new int[] {3, 6, 4, 8, 9}));
		
	}
	
}

class MyPoint {
	
	int x, y;
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d,%d)", this.getClass().getSimpleName(), this.x, this.y);
	}
	
}