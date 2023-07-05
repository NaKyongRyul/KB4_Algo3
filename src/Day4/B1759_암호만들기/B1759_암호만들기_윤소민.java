package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1759_암호만들기_윤소민 {


	static int l;
	static int c;
	static char[] arr;
	
	static int cnt=0;
	
	static ArrayList<String> arrlst=new ArrayList<>();
	static String str;
	
	static boolean [] isSelected;
	
	static void subset(int num) {
		
		// 종료조건
		if(num ==c) {
			cnt =0;
			str = "";
			for(int i=0;i<c;i++) {
				if(isSelected[i]) {
					cnt++;
				}
			}
			if(cnt==l) {
				for(int i=0; i<c; i++) {
					if(isSelected[i]) {
						//System.out.print(arr[i] + " ");
						str += arr[i];
					}
				}
				arrlst.add(str);
				
			}
			//System.out.println();
			return;
		}
		
		isSelected[num] = false;
		subset(num+1);
		
		isSelected[num] = true;
		subset(num+1);
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		isSelected = new boolean[c];

		ArrayList<String> mo =new ArrayList<>();
		
		st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<c;i++) {
			arr[i] = st.nextToken().charAt(0);
			
			if(String.valueOf(arr[i]).equals("a")||String.valueOf(arr[i]).equals("e")||String.valueOf(arr[i]).equals("i")||String.valueOf(arr[i]).equals("o")||String.valueOf(arr[i]).equals("u") ) {
				mo.add(String.valueOf(arr[i]));
			}
		}
		
		
		Arrays.sort(arr);
		subset(0);
		Collections.sort(arrlst);
		//System.out.println(arrlst);
		
		//최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음 조건
		
		ArrayList<String> copylst = new ArrayList<String>();
		for(String s:arrlst) {   //깊은 복사
			copylst.add(s);
		}
		
		int len = arrlst.size();
		for(int i=0;i<len;i++) {
			int []mm =new int[len]; //모음개수 카운트
			for(int j=0;j<mo.size();j++) {
				if(arrlst.get(i).contains(mo.get(j))) mm[i]++;
			}
			if(mm[i]<1) copylst.remove(arrlst.get(i));        //모음개수 <1 : 삭제
			else if(l-mm[i]<2) copylst.remove(arrlst.get(i)); //자음개수 <2 : 삭제
		}   //삭제할때 arrlst의 인덱스를 건들면 반복문에서 오류 -> 복제한 copylst에서 삭제함
		
		//출력
		for(String s:copylst) {
			System.out.println(s);
		}
	}
}
