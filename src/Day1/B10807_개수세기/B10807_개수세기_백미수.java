package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B10807_개수세기_백미수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		//BufferedReader가 Scanner보다 읽어오는 시간의 훨씬 빠르다
		
		
		/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); //int형으로 변경해줌
		System.out.println(N);
		
		String str = reader.readLine();
		String[] strs = str.split(" ");//배열로 만들기 위해
		System.out.println(Arrays.toString(strs));
		
		int[] arr = new int [N];
				
		for(int i = 0; i<strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.println(Arrays.toString(arr));
		
		str  = reader.readLine();
		int v = Integer.parseInt(str);
		System.out.println(v);*/
		
		/////////////방법2
		
		/*Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr = new int [N];
		
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();*/
		
		//문제풀이
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(reader.readLine()); //int형으로 변경해줌
		//System.out.println(N);
		
		String str = reader.readLine();
		String[] strs = str.split(" ");//배열로 만들기 위해
		//System.out.println(Arrays.toString(strs));
		
		int[] arr = new int [N];
				
		for(int i = 0; i<strs.length; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		
		//System.out.println(Arrays.toString(arr));
		
		str  = reader.readLine();
		int v = Integer.parseInt(str);
		//System.out.println(v);
		
		int count = 0;
		
		for(int i = 0; i< arr.length; i++) {
			if(arr[i]==v) {
				++count;
			}
		}
		System.out.println(count);
	}
}
	