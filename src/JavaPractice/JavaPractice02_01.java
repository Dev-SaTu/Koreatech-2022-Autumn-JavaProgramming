package JavaPractice;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaPractice02_01 {

	public static void main(String[] args) {

		// 56 7 12 34 75 86 23 65 12 6
		
		/*
		 * #1
		 */

		System.out.print("input: ");

		Scanner scan = new Scanner(System.in);

		int[] array = new int[10];

		for (int i = 0; i < array.length; i++) {

			array[i] = scan.nextInt();

		}

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] >= array[j]) {

					array[i] ^= array[j];
					array[j] ^= array[i];
					array[i] ^= array[j];

				}

			}

		}

		for (int i = 0; i < array.length; i++) {

			System.out.printf("%d ", array[i]);

		}

		System.out.println();

		/*
		 * #2
		 */

		int[][] matrix = Make2DArray(5);

		System.out.printf("%d, %d\n", matrix.length, matrix[0].length);

		/*
		 * #3
		 */

		System.out.print("input: ");

		Scanner scan2 = new Scanner(System.in);

		try {

			System.out.println(1 / scan2.nextInt());

		} catch (ArithmeticException e) {

			if (e.getMessage().contains("zero")) {

				System.out.println("0으로 나눌 수 없습니다.");

			}

		} catch (InputMismatchException e) {

			System.out.println("정수가 아닙니다.");

		}

		scan.close();
		scan2.close();
		
	}

	static int[][] Make2DArray(int num) {

		return new int[num][num];

	}

}
