/*
ID: debshan1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;
public class milk {
//Clearly, from the output format, MMM exhausted the supply of the
//cheapest stores before moving onto bigger things. We'll do just that.
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));   
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    Farmer[] farmers = new Farmer[m];
	    for (int i=0; i<m; i++) {
	    	st = new StringTokenizer(in.readLine());
	    	farmers[i] = new Farmer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(farmers);
	    //exhaust the little guy's supplies, and work our way up
	    //to the more expensive farmers
	    int res = 0;
	    for (int i=0; i<m && n>0; i++) {
	    	int amt = farmers[i].amount;
	    	//if we get an amt greater than n, we limit our aim
	    	if (amt > n) {
	    		amt = n;
	    	}
	    	res += (amt*farmers[i].price);
	    	n -= amt;
	    }
	    
	    out.println(res);
	    out.close();
	    in.close();
	}
	//compare farmers based on the price of their milk
	static class Farmer implements Comparable<Farmer> {
		int price;
		int amount;
		Farmer (int price, int amount) {
			this.price = price;
			this.amount = amount;
		}
		public int compareTo(Farmer o) {
			return this.price - o.price;
		}
	}
}
