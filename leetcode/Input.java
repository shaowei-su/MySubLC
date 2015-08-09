package leetcode;

import java.util.HashMap;

public class Input {
	private String color;
 
	public Input(String color) {
		this.color = color;
	}
 
	public boolean equals(Object obj) {
		if (!(obj instanceof Input))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Input) obj).color);
	}
	
	public int hashCode(){
		return this.color.length();	
	}
	
	public static void main(String[] args) {
		Input a1 = new Input("green");
		Input a2 = new Input("red");
 
		//hashMap stores apple type and its quantity
		HashMap<Input, Integer> m = new HashMap<Input, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		System.out.println(m.get(new Input("green")));
	}
}
