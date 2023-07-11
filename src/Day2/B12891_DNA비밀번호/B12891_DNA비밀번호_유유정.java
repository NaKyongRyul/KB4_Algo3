package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12891_DNA비밀번호_유유정 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String []strs = str.split(" ");
		int S = Integer.parseInt(strs[0]);
		int P = Integer.parseInt(strs[1]);
		str = bf.readLine();
		String [] dna = str.split("");

			
		str = bf.readLine();
		strs = str.split(" ");
		int numA = Integer.parseInt(strs[0]);
		int numC = Integer.parseInt(strs[1]);
		int numG = Integer.parseInt(strs[2]);
		int numT = Integer.parseInt(strs[3]);
		int answer = 0;
		int start = 0;
		int end =0;
		bf.close();
		int countA =0; int countC =0; int countG=0; int countT =0;
		while(start != S-P+1) {
			if(dna[end].equals("A"))
				countA++;
			else if(dna[end].equals("C")) 
				countC++; 
			else if(dna[end].equals("G")) 
				countG++;
			else if(dna[end].equals("T")) 
				countT++; 

			if(end - start == P-1) {
				if ((countA >= numA) && (countC >= numC) && (countG >= numG) && (countT >= numT))
					answer++;
				 if(dna[start].equals("A"))
					 countA--;
				 else if(dna[start].equals("C")) 
					 countC--; 
				 else if(dna[start].equals("G")) 
					 countG--;
				 else if(dna[start].equals("T")) 
					 countT--; 
				start++;
				end++;
			}
			else {
				end ++;
			}
		}
		System.out.println(answer);
	}
}
	
