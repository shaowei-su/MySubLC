import java.util.*;

public class Test {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		String[] arr = stack.toArray(new String[stack.size()]);
		for (String s: arr) {
			System.out.println(s);
		}
	}
}