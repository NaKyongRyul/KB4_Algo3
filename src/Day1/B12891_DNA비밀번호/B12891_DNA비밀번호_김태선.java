package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_김태선 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		String DNA = st.nextToken();
		
		int check [] = new int [4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		int check2 [] = {0, 0, 0, 0};
		
		List<Character> array = new LinkedList<> ();
		for (int i = 0; i < P; i++) {
			array.add(DNA.charAt(i));
			switch(DNA.charAt(i)) {
			case 'A' :
				check2[0]++;
				break;
			case 'C' :
				check2[1]++;
				break;
			case 'G' :
				check2[2]++;
				break;
			case 'T' :
				check2[3]++;
				break;
			}
		}
		if(check2[0] >= check[0] && check2[1] >= check[1] && check2[2] >= check[2] && check2[3] >= check[3]) {
			count++;
		
		}
		
		for(int i = P; i < S; i++) {
			int j = i - P;
			
			array.add(DNA.charAt(i));
			switch(DNA.charAt(i)) {
			case 'A' :
				check2[0]++;
				break;
			case 'C' :
				check2[1]++;
				break;
			case 'G' :
				check2[2]++;
				break;
			case 'T' :
				check2[3]++;
				break;
			}
			switch(DNA.charAt(j)) {
			case 'A' :
				check2[0]--;
				break;
			case 'C' :
				check2[1]--;
				break;
			case 'G' :
				check2[2]--;
				break;
			case 'T' :
				check2[3]--;
				break;
			}
			
			if(check2[0] >= check[0] && check2[1] >= check[1] && check2[2] >= check[2] && check2[3] >= check[3]) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}
