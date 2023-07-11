package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B12891_DNA비밀번호_오원식 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = bf.readLine().split(" ");
		int	 S = Integer.parseInt(strs[0]);
		int P = Integer.parseInt(strs[1]);
		
		String dna = new String(bf.readLine());
		String [] dnas = dna.split("");
		
		String[] cntArr = bf.readLine().split(" ");
		int A = Integer.parseInt(cntArr[0]);
		int C = Integer.parseInt(cntArr[1]);
		int G = Integer.parseInt(cntArr[2]);
		int T = Integer.parseInt(cntArr[3]);
		
		int i= 0;
		int cnt = 0;
		
		String [] arr = Arrays.copyOfRange(dnas, i, P);
		int cntA = Collections.frequency(Arrays.asList(arr), "A");
		int cntC = Collections.frequency(Arrays.asList(arr), "C");
		int cntG = Collections.frequency(Arrays.asList(arr), "G");
		int cntT = Collections.frequency(Arrays.asList(arr), "T");
		
		while(i<=S-P) {
			if(i!=0) {
			if(dnas[i-1].equals("A")) cntA--;
			else if(dnas[i-1].equals("C")) cntC--;
			else if(dnas[i-1].equals("G")) cntG--;
			else if(dnas[i-1].equals("T")) cntT--;
				
			if(dnas[P+i-1].equals("A")) cntA++;
			else if(dnas[P+i-1].equals("C")) cntC++;
			else if(dnas[P+i-1].equals("G")) cntG++;
			else if(dnas[P+i-1].equals("T")) cntT++;
			}
			
			if(cntA >= A && cntC >= C && cntG >= G && cntT >= T) 
				cnt++;

			i++;
		}
		
		System.out.println(cnt);
	}
}
