/*
ID: debshan1
LANG: JAVA
TASK: transform
*/
import java.io.*;
public class transform {
	public static void main(String[] args) throws IOException{
		//file input/output
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int n = Integer.parseInt(in.readLine());
        //we'll need two matrices - one for before and one for after
        char[][] before = new char[n][n];
        char[][] after = new char[n][n];
        //read in the 'before' matrix
        for (int i=0; i<n; i++) {
        	before[i] = in.readLine().toCharArray();
        }
        //read in the 'after' matrix
        for (int i=0; i<n; i++) {
        	after[i] = in.readLine().toCharArray();
        }
        int ans = 0;
        //With an if-else loop, we can find the minimum since our
        //judging criteria goes from 1->7
        //Case 1: 90 degree rotation
        if (equal(rotate(before),after)) ans = 1;
        //Case 2: 180 degree rotation
        else if (equal(rotate(rotate(before)),after)) ans = 2;
        //Case 3: 270 degree rotation
        else if (equal(rotate(rotate(rotate(before))), after)) ans = 3;
        //Case 4: reflection
        else if (equal(reflect(before),after)) ans = 4;
        //Case 5: Reflection, then 1 of the 3 cases
        else if (equal(rotate(reflect(before)), after)) ans = 5;
        else if (equal(rotate(rotate(reflect(before))),after)) ans = 5;
        else if (equal(rotate(rotate(rotate(reflect(before)))),after)) ans = 5;
        //Case 6: No change whatsoever
        else if (equal(before, after)) ans = 6;
        else ans = 7;
        //print out our answer, close inputs and outputs
        out.println(ans);
        out.close();
        in.close();
	}
	//reflect function - reflects the matrix
	public static char[][] reflect(char[][] m) {
		int n = m.length;
		char[][] ret = new char[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				char temp = m[i][n-j-1];
				ret[i][j] = temp;
			}
		}
		return ret;
	}
	//rotate function - rotates the matrix 90 degrees clockwise
	//(we'd have to apply this two or three times to get a 180 or
	//270 degree rotation)
	public static char[][] rotate(char[][] m) {
		int n = m.length;
		char[][] ret = new char[n][n];
		for (int i=0; i<n/2; i++) {
			for (int j=i; j<n-i-1; j++) {
				char before = m[i][j];
				ret[i][j] = m[j][n-1-i];
				ret[j][n-1-i] = m[n-1-i][n-1-j];
				ret[n-1-i][n-1-j] = m[n-1-j][i];
				ret[n-1-j][i] = before;
			}
		}
		//what happens if the length of our square matrix is odd?
		if (n % 2 == 1) {
			ret[(n-1)/2][(n-1)/2] = m[(n-1)/2][(n-1)/2];
		}
		return ret;
	}
	//equal function - loops through the two matrices and sees
	//if every element is equal
	public static boolean equal(char[][] a, char[][] b) {
		boolean res = true;
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++) {
				if (a[i][j] != b[i][j]) res = false;
			}
		}
		return res;
	}
}
