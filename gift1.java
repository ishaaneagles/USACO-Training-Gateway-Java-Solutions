/*
ID: debshan1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;
public class gift1 {

	public static void main(String[] args) throws IOException{
		//file input/output
		 BufferedReader in = new BufferedReader(new FileReader("gift1.in"));   
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		 int NP = Integer.parseInt(in.readLine());
		 //use a hashmap to label each person with their account
		 LinkedHashMap<String, Integer> pList = new LinkedHashMap<String, Integer>();
		 for (int i=0; i<NP; i++) {
			 pList.put(in.readLine(),0);
		 }
		 //loop through the NP people present
		 for (int i=0; i<NP; i++) {
			 String giver = in.readLine();
			 String[] gifts = in.readLine().split(" ");
			 int gift = Integer.parseInt(gifts[0]);
			 int numRec = Integer.parseInt(gifts[1]);
			 pList.put(giver,pList.get(giver) - gift);
			 int moneyPerPerson;
			 if (numRec == 0) moneyPerPerson = 0;
			 else moneyPerPerson = Math.floorDiv(gift, numRec);
			 int change = gift - (moneyPerPerson * numRec);
			 pList.put(giver,pList.get(giver) + change);
			 for (int j=0; j<numRec; j++) {
				 String rec = in.readLine();
				 pList.put(rec, pList.get(rec)+moneyPerPerson);
			 }
		 }
		 for (String key: pList.keySet()) {
			 String pKey = key;
			 int pValue = pList.get(key);
			 out.println(pKey+" "+pValue);
		 }
		 out.close();
		 in.close();
	}

}
