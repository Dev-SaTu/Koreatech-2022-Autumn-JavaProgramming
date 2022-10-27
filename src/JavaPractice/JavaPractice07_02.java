package JavaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaPractice07_02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		for (int i : new int[] { 1, 5, 2, 6, 3, 7, 4 }) {
			list.add(i);
		}

		System.out.printf("%s => %d", list, getNumber(list, 4, 4, 1));

	}

	public static int getNumber(List<Integer> list, int i, int j, int m) {

		List<Integer> list2 = new ArrayList<Integer>();
		
		for (int k = i - 1; k < j; k++) {
			list2.add(list.get(k));
		}
		
		Collections.sort(list2);
		
		return list2.get(m - 1);

	}


}
