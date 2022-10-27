package JavaPractice;

public class JavaPractice06_01 {

	public static void main(String[] args) {
		
		String[] testCases = { "()()", "(())()", ")()(", "(()(", "(()())", "(()()((()))", "((()))()()(()))", "((((())))(()(()()))((()))()()((()))(((()()))()()))" };
		
		for (String testCase : testCases) {
			System.out.printf("%s = %b\n", testCase, ParenthesesCheck(testCase));
		}
		
	}
	
	public static boolean ParenthesesCheck(String str) {
		
		int open = 0;
		
		for (char c : str.toCharArray()) {
			if (open < 0) {
				return false;
			}
			if (c == '(') {
				open++;
			} else if (c == ')') {
				open--;
			}
		}
		
		if (open == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
