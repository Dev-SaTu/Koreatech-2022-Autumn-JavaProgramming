package JavaPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaPractice07_01 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();

		Scanner scan = new Scanner(System.in);

		while(true) {

			System.out.print("나라 이름, 인구 >> ");
			String text = scan.nextLine();
			String[] elements = text.split(" "); 

			if (text.equals("그만")) {
				break;
			} else {
				map.put(elements[0], Integer.parseInt(elements[1]));
			}

		}

		while(true) {

			System.out.print("인구 검색 >> ");
			String text = scan.nextLine();

			if (text.equals("그만")) {
				break;
			} else {
				String key = text;
				if (map.containsKey(key)) {
					System.out.printf("%s의 인구는 %d\n", key, map.get(key));
				} else {
					System.out.printf("%s 나라는 없습니다.\n", key);
				}
			}

		}
		
		scan.close();

	}

}
