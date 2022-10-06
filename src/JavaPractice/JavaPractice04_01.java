package JavaPractice;

public class JavaPractice04_01 {

	public static void main(String[] args) {

		StringStack stringStack = new StringStack(3);
		stringStack.push("A");
		stringStack.push("B");
		stringStack.push("C");
		
		
		for (String s : stringStack.stringArray) {
			System.out.println(s);
		}

	}

}

interface StackInterface {

	int length();
	String pop();
	boolean push(String ob);

}

class StringStack implements StackInterface {

	public String[] stringArray = null;
	private int size = 0;

	public StringStack(int length) {
		stringArray = new String[length];
	}

	@Override
	public int length() {
		return this.size;
	}

	@Override
	public String pop() {
		if (size > 0) {
			String r = stringArray[size -1];
			stringArray[size - 1] = null;
			size--;
			return r;
		} else {
			return null;
		}
	}

	@Override
	public boolean push(String ob) {
		if (size < stringArray.length) {
			stringArray[size] = ob;
			size++;
			return true;
		} else {
			return false;
		}
	}

}