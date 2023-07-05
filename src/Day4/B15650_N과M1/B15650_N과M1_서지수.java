package Day4.B15650_N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650_N과M1_서지수 {
	static int arr[];
	static int N;
	static int R;
	static boolean[] isSelected;
	static int[]select;
	
	static void combination(int r, int start) {
		if(r==R) {
			for(int i=0;i<R;i++) {
				System.out.print(arr[select[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			if(isSelected[i]) continue;
			select[r]=i;
			isSelected[i]=true;
			combination(r+1, i);
			isSelected[i]=false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		R=M;
		
		arr=new int[N];
		isSelected=new boolean[N];
		select=new int[R];
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		combination(0,0);
	}

	
}
