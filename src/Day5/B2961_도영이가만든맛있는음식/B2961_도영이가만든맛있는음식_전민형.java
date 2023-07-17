package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_전민형 {

	
	static int [] arr1;	//재료 종류 신맛
	static int [] arr2;	//재료 종류 신맛
	static int num;		//재료 개수
	static int [] select; //뽑은거 주소값
	static boolean [] isSelect; //이미 뽑은거 체크
	static int min = Integer.MAX_VALUE;	//최소값 초기화 (최대로)
	static int sour = 1;
	static int bitter = 0;
	
	
	static void flavor (int idx) {
		//종료 조건
		if(idx==num) {
			if(bitter==0)return;
			return;
		}
		//재귀
			
			isSelect[idx] = true;
			sour= sour*arr1[idx];
			bitter = bitter+arr2[idx];
			
			flavor(idx+1);

			sour= sour/arr1[idx];
			bitter = bitter-arr2[idx];
			
			isSelect[idx] = false;
			flavor(idx+1);
			
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		StringTokenizer tok = new StringTokenizer(str);
		num = Integer.parseInt(tok.nextToken());
		
		for(int i = 0; i<num; i++) {
			arr1[i] = Integer.parseInt(tok.nextToken());
			arr2[i] = Integer.parseInt(tok.nextToken());
		}
		
		
		isSelect = new boolean[num];
		
	}
	
	

}
