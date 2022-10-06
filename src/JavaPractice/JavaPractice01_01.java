package JavaPractice;
import java.util.Scanner;

public class JavaPractice01_01 {

	public static void main(String[] args) {
		
		/*
		 * Q1
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input KRW : ");
		System.out.println("Output Dollar : $" + (scan.nextInt() / 1100));
		
		/*
		 * Q2
		 */
		
		scan = new Scanner(System.in);
		System.out.print("Input Month : ");

		int month = scan.nextInt();
		
		if (month >= 3 && month <= 5) {
			
			System.out.println("봄");
			
		} else if (month >= 6 && month <= 8) {
			
			System.out.println("여름");
			
		} else if (month >= 9 && month <= 11) {
			
			System.out.println("가을");
			
		} else if (month == 12 || (month >= 1 && month <= 2)) {
			
			System.out.println("겨울");
			
		} else {
			
			System.out.println("잘못입력");
			
		}
		
		/*
		 * Q3
		 */
		
		switch (month) {
		
		case 1:
		case 2: System.out.println("겨울"); break;
		
		case 3:
		case 4:
		case 5: System.out.println("봄"); break; 
		
		case 6: 
		case 7:
		case 8: System.out.println("여름"); break; 
			
		case 9: 
		case 10:
		case 11: System.out.println("가을"); break;
		
		case 12: System.out.println("겨울"); break;
		
		default: System.out.println("잘못입력");
		
		}
		
		scan.close();
		
	}
	
}
