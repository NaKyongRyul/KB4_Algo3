package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B9742_순열_김현지 {
	
	static int [] select;
	static boolean [] isSelected;
	static int stop;
	static int cnt;
	static char [] chrArr;
	static String [] strArr = new String[2];
//	 StringBuilder 아닌 String 이용했더니 메모리 초과
	static StringBuilder sb = new StringBuilder();
	
	
	public static void permutation(int r) {
		int len = chrArr.length;


		if (r == len) {
			cnt++;
//			System.out.println("cnt: " + cnt);
//			System.out.println("select: " + Arrays.toString(select));
//			System.out.println();
//			String answer = "";
//			for (int j=0; j<len; j++) {
//				answer += chrArr[select[j]];
//			}
			if (cnt == stop) {
//				System.out.println(strArr[0] + " " + stop + " = " + answer);
				System.out.println(String.valueOf(chrArr) + " " + stop + " = " + sb.toString());
			} 
			return;
		}
		
		// 재귀확장
		for (int i=0; i<len; i++) {
			// 선택한 경우 = skip
			if(isSelected[i] == true) continue;
			
			// 선택
//			select[r] =i;
			sb.append(chrArr[i]);
			isSelected[i] = true;
//			System.out.println("r: " + r + ", i:" +i);
//			System.out.println("select: " + Arrays.toString(select));
//			System.out.println("isSelected: " + Arrays.toString(isSelected));
			permutation(r+1);
			
			// 선택 해제
			isSelected[i] = false;
			sb.deleteCharAt(sb.length()-1);
		}


	}
	
	
	
	


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		
		while ((str = reader.readLine()) != null) {
			strArr = str.split(" ");
			chrArr = strArr[0].toCharArray();
			stop = Integer.parseInt(strArr[1]);
			select = new int [chrArr.length];
			isSelected = new boolean [chrArr.length];
			cnt = 0;
			
//			System.out.println("===========================");
//			System.out.println("chrArr: "+ Arrays.toString(chrArr) + ", stop: " + stop);
//			System.out.println("===========================");
			

			permutation(0);
			
			if (cnt < stop)  {
				System.out.println(strArr[0] + " " + stop + " = " + "No permutation");
			}

		}


	}

}
