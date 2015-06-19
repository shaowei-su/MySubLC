package leetcode;

import java.net.*;
import java.io.*;

class WhiteHouse {
 public static void main(String[] arg) throws Exception {
	 URL u = new URL("http://www.google.com/");
	 InputStream ins = u.openStream();
	 InputStreamReader isr = new InputStreamReader(ins);
	 BufferedReader whiteHouse = new BufferedReader(isr);
	 System.out.println(whiteHouse.readLine());
 }
}
