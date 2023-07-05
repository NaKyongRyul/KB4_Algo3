package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_윤소민 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		
		String [] arr = new String[S];
		String str = bf.readLine();
		for(int i=0;i<S;i++) {

			arr[i] = String.valueOf(str.charAt(i));
			}
		
		
		st = new StringTokenizer(bf.readLine());
		int [] num = new int[4];  // {‘A’,‘C’,‘G’,‘T’}
		for(int i=0;i<4;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}


		int [] pnum = new int[4];

		int len = P, cnt=0;
		int start=0, end=start+P-1;
		

		for(int i=start+P-1;i<S;i++) { //while end<=S-1
			String[] copyArr = Arrays.copyOfRange(arr, start,end+1);
			int ccnt=0;
			if(Collections.frequency(Arrays.asList(copyArr), "A")>=num[0]) ccnt++;
			if(Collections.frequency(Arrays.asList(copyArr), "C")>=num[1]) ccnt++;
			if(Collections.frequency(Arrays.asList(copyArr), "G")>=num[2]) ccnt++;
			if(Collections.frequency(Arrays.asList(copyArr), "T")>=num[3]) ccnt++;
			
			if(ccnt == 4) cnt++;
			start++;
			end++;
			
			
		}
		System.out.println("cnt="+cnt);

	}

}

