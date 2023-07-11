package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12891_DNA비밀번호_정지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int s, p;
		String str;
		int numA=0, numG=0, numT=0, numC=0;
		int criA, criG, criT, criC;
		int answer=0;
		int i=0, j = 0;
		
		String[] inputStrs = br.readLine().split(" ");
		s = Integer.parseInt(inputStrs[0]);
		p = Integer.parseInt(inputStrs[1]);
		
		str = br.readLine();
		
		inputStrs = br.readLine().split(" ");
		criA = Integer.parseInt(inputStrs[0]);
		criC = Integer.parseInt(inputStrs[1]);
		criG = Integer.parseInt(inputStrs[2]);
		criT = Integer.parseInt(inputStrs[3]);

		//INPUT///
		
		
		
		
		
		
		for(j=0;j<p;j++) {
			switch(str.charAt(j)) {
				case 'A':
					numA++;
					break;
				case 'C' :
					numC++;
					break;
				case 'G':
					numG++;
					break;
				case 'T':
					numT++;
					break;
				default:
					break;
			}
		}
		j--;
		
		if(criA<=numA&&criG<=numG&&criT<=numT&&criC<=numC) {
			answer++;
		}
		
		
	
		while(j<s-1) {		
			
			
			switch(str.charAt(j+1)) {
				case 'A':
					numA++;
					break;
				case 'C' :
					numC++;
					break;
				case 'G':
					numG++;
					break;
				case 'T':
					numT++;
					break;
				default:
					break;
			}
			switch(str.charAt(i)) {
				case 'A':
					numA--;
					break;
				case 'C' :
					numC--;
					break;
				case 'G':
					numG--;
					break;
				case 'T':
					numT--;
					break;
				default:
					break;
			}
			if(criA<=numA&&criG<=numG&&criT<=numT&&criC<=numC) {
				answer++;
			}
			i++;
			j++;
		}
		
		System.out.println(answer);
		

	}
}
