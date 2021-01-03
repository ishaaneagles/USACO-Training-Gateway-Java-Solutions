/*
ID: debshan1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.StringTokenizer;
public class dualpal {

	public static void main(String[] args) throws IOException{
		//file io, read in n, s
		BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		//initialize some variables to help find our answers
		int dualsFounded = 0;
		int[] answers = new int[n];
		//loop until we find n dual palindromes
		while (dualsFounded != n) {
			s++;
			if (isDualPalindrome(s)) {
				answers[dualsFounded] = s;
				dualsFounded++;
			}
		}
		//print out the answers we saved
		for (int a: answers) {
			out.println(a);
		}
		//close the outputs and inputs
		out.close();
		in.close();
	}

	public static boolean isDualPalindrome(int x) {
		//convert the number into a String of base 2-10 using the toString method
		//and add to cnt whenever we find one
		int cnt = 0;
		for (int base = 2; base <= 10; base++) {
			String curr = Integer.toString(x, base);
			if (isPalindrome(curr)) {
				cnt++;
			}
		}
		//if x is a palindrome for >=2 bases, return true (else return false)
		if (cnt >= 2) {
			return true;
		}
		return false;
	}
	//find if a given String is a palindrome or not
	public static boolean isPalindrome(String s) {
		int len = s.length();
		//test if the String ends in 0 at both sides, making
		//it not a palindrome
		if (s.charAt(0) == '0' && s.charAt(len-1) == '0') {
			return false;
		}
		for (int i=0; i<len/2; i++) {
			if (s.charAt(i) != s.charAt(len-i-1)) {
				return false;
			}
		}
		return true;
	}
}
