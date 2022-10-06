package JavaPractice;
import java.util.Random;
import java.util.Scanner;

public class JavaPractice02_02 {

	public static void main(String[] args) {

		/*
		 * #1
		 */

		int r = new Random().nextInt(101);

		System.out.println(r);
		
		Scanner scan = null; 

		boolean win = false;

		for (int i = 0; i < 7; i++) {

			System.out.print("input: ");

			scan = new Scanner(System.in);

			int x = scan.nextInt();

			if (x > r) {

				System.out.println("추측한 숫자가 생성된 숫자보다 높다.");

			} else if (x < r) {

				System.out.println("추측한 숫자가 생성된 숫자보다 낮다.");

			} else {

				System.out.println("승리!");

				win = true;
				
				break;

			}

		}

		if (!win) {

			System.out.println("패배!");

		}

	}

}
