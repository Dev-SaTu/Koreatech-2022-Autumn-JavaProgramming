import java.util.Scanner;

public class JavaPractice03_02 {

	// 5 3 2 7 1 5 8 3
	
	public static void main(String[] args) {
	
		Rect[] rectArray = new Rect[4];
		
		System.out.print("input: ");
		
		Scanner scan = new Scanner(System.in);
		
		int areaSum = 0;
		
		for (int i = 0; i < rectArray.length; i++) {
			
			int w = scan.nextInt();
			int h = scan.nextInt();
			
			rectArray[i] = new Rect(w, h);
			
		}
		
		for (int i = 0; i < rectArray.length; i++) {
			
			areaSum += rectArray[i].getArea();
			
		}
		
		System.out.println("areaSum: " + areaSum);
		
	}

}

class Rect {
	
	private int width, height;
	
	public Rect(int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	public int getArea() {
		
		return width * height;
		
	}
	
}