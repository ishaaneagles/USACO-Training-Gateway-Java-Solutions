/*
ID: debshan1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;
public class crypt1 {
	static int[] digits;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));   
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
	    int n = Integer.parseInt(in.readLine());
	    digits = new int[n];
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    for (int i=0; i<n; i++) {
	    	digits[i] = Integer.parseInt(st.nextToken());
	    }
	    int cnt = 0;
	    for (int i=100; i<1000; i++) {
	    	for (int j=10; j<100; j++) {
	    		if (goodProduct(i,j)) {
	    			cnt++;
	    		}
	    	}
	    }
	    out.println(cnt);
	    out.close();
	    in.close();
	}
	public static boolean inArray(int[] array, int b) {
		for (int a: array) {
			if (a == b) {
				return true;
			}
		}
		return false;
	}
	//does number n have d digits that are allowed by the input?
	public static boolean goodNumber(int n, int d) {
		if (n == 0) return false;
		while (n > 0) {
			int curr = n%10;
			if (!inArray(digits, curr)) {
				return false;
			}
			n /= 10;
			d--;
		}
		if (d == 0) return true;
		else return false;
	}
	public static boolean goodProduct(int x, int y) {
		if (!goodNumber(x,3) || !goodNumber(y,2) || !goodNumber((x*y),4)) {
			return false;
		}
		while (y > 0) {
			if (!goodNumber((x*(y%10)),3))
				return false;
			y /= 10;
		}
		return true;
	}
}
