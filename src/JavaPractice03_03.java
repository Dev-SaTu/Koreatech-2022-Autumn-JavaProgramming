import java.util.Random;
import java.util.Scanner;

public class JavaPractice03_03 {

	public static void main(String[] args) {
		
		Player[] playerArray = new Player[2];
		
		Scanner scan = null;
		
		for (int i = 0; i < 2; i++) {
			
			System.out.print("선수 이름 입력 >> ");
			scan = new Scanner(System.in);
		
			playerArray[i] = new Player(scan.next());
						
		}
		
		while (true) {
			
			boolean done = false;
			
			for (int i = 0; i < 2; i++) {
				
				Player player = playerArray[i];
				System.out.printf("%s씨, <Enter 외 아무키나 치세요>", player.getName());
				
				int[] xArray = new int[3];
				
				for (int j = 0; j < xArray.length; j++) {
					
					xArray[j] = new Random().nextInt(3);
					
				}

				System.out.printf("%d    %d    %d\n", xArray[0], xArray[1], xArray[2]);
				
				if (xArray[0] == xArray[1] && xArray[1] == xArray[2]) {
					
					System.out.printf("%s이 승리하였습니다.\n", player.getName());
					
					done = true;
					break;
					
				}
				
			}
			
			if (done) {
				
				break;
				
			}
			
		}
		
	}
	
}

class Player {
	
	private String name;
	
	public Player(String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
}