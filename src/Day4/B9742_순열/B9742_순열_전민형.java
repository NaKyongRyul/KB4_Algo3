package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9742_순열_전민형 {
	
	//static StringBuilder string = new StringBuilder();
	static char [] arr;
	static int num; // arr의 길이 = 받은 인수의 길이
	static int [] select; // 뽑은거 저장
	static boolean [] isSelect; // 이미 뽑았는지 거르기
	static ArrayList <StringBuilder> str = new ArrayList <>(); //ArrayList<String>으로 했더니 메모리초과 나옴;;
	
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String stri;
		
		while((stri = reader.readLine())!=null) {
			
			str.clear();
			st = new StringTokenizer(stri);
			arr = st.nextToken().toCharArray();
			num = Integer.parseInt(st.nextToken());
			select = new int [arr.length];
			isSelect = new boolean [arr.length];
			
			
			permutation(0);
			
			if(str.size() < num) {
				System.out.println(stri + " = No permutation");
				
			}else {
				System.out.println(stri + " = " + str.get(num-1));
			}
			
			
		}
		
		
		
	}
	
	public static void permutation (int start) {

		if(start == arr.length) {
			StringBuilder tem = new StringBuilder(); // 그때그때 생성해서 저장
			//string.setLength(0);		//     =같은거 string.delete(0, num-1);
			for(int i = 0; i<arr.length; i++) {
				
				tem.append(arr[select[i]]);
			}
			str.add(tem);// str.add(string.toString); stringbuilder는 주소값임 그래서 toString 해줘야함
			return;


		}
		
		for(int i = 0; i<arr.length; i++) {
			if(isSelect[i]==true)continue;
			
			select[start] = i;
			isSelect[i]=true;
			permutation(start+1);
			
			isSelect[i]=false;
			
		}
		
	}

}
