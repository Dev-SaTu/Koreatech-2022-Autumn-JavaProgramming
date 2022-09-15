import java.util.Scanner;

public class JavaPractice01_02 {

	public static void main(String[] args) {
		
		int x = 0, y = 0, z = 0, reward = 0;
		
		Scanner scan = new Scanner(System.in);
		
		x = scan.nextInt();
		y = scan.nextInt();
		z = scan.nextInt();
		
		if (x == y && y == z) {
			
			reward = 10000 + x * 1000;
			
		} else if (x == y || x == z) {
			
			reward = 1000 + x * 100; 
			
		} else if (y == z) {
			
			reward = 1000 + y * 100;
			
		} else {
			
			reward = Math.max(Math.max(x, y), z) * 100;
			
		}
		
		System.out.println(reward);
		
	}
	
}
