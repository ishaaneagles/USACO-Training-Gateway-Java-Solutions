/*
ID: debshan1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
public class palsquare {
	
	public static void main(String[] args) throws IOException{
		//file i/o, read in base B
		BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int b = Integer.parseInt(in.readLine());
		//loop through the range and find our posisble solutions
		for (int n=1; n<=300; n++) {
			int sqN = n*n;
			//we can use this convenient automatic base converter
			//(minimum base is 2 and maximum base is 36, so we're
			//within the necessary range)
			String curr = Integer.toString(n,b);
			String currSquared = Integer.toString(sqN, b);
			if (isPalindrome(currSquared)) {
				//we need to write both numbers in base B
				//Also uppercase the letters since toString
				//doesn't do that :(
				out.println(curr.toUpperCase()+" "+currSquared.toUpperCase());
			}
		}
		//close the outputs and inputs
		out.close();
		in.close();
	}
	//check if requested string is a palindrome or not
	public static boolean isPalindrome(String s) {
		int len = s.length();
		for (int i=0; i<len/2; i++) {
			if (s.charAt(i) != s.charAt(len-i-1)) {
				return false;
			}
		}
		return true;
	}
}
