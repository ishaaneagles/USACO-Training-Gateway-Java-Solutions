/*
ID: debshan1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;
public class combo {
	static int N;
	public static void main(String[] args) throws IOException{
		//file input output
		BufferedReader in = new BufferedReader(new FileReader("combo.in"));   
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
	    //read in n, farmer John (fJohn) and the master lock
	    N = Integer.parseInt(in.readLine());
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    Combination fJohn = new Combination(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    st = new StringTokenizer(in.readLine());
	    Combination master = new Combination(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    int count = 0;
	    //loop through all possible combinations and find the ones that work
	    for (int f=1; f<=N; f++) {
	    	for (int s=1; s<=N; s++) {
	    		for (int t=1; t<=N; t++) {
	    			Combination temp = new Combination(f,s,t);
	    			if (inRange(temp,fJohn) || inRange(temp,master)) {
	    				count++;
	    			}
	    		}
	    	}
	    }
	    out.println(count);
	    out.close();
	    in.close();
	}
	//checks if a combination c1 is within range of a combination c2
	public static boolean inRange(Combination c1, Combination c2) {
		boolean first = isClose(c1.first,c2.first);
		boolean second = isClose(c1.second,c2.second);
		boolean third = isClose(c1.third,c2.third);
		if (first && second && third) {
			return true;
		}
		return false;
	}
	//checks if a number is within range of another number, or loops around
	public static boolean isClose(int x, int y) {
		if (Math.abs(x-y) <= 2) return true;
		//check in case one number loops around (i.e. 50 works from 48 to 2)
		if (Math.abs(x-y) >= N-2) return true;
		return false;
	}

}
//Combination class - (First, Second, Third)
class Combination {
	int first;
	int second;
	int third;
	public Combination(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
}