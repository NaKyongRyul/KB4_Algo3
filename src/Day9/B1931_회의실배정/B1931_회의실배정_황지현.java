package day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B1931_회의실배정_황지현 {
	static int N;
	static int [][]list;
	static int end;
	static int ans;
	public static void main(String[] args) throws IOException {
		//값 입력
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		list=new int [N][N];
		for(int i=0;i<N;i++) {
			String []st=br.readLine().split(" ");
			int a=Integer.parseInt(st[0]);
			int b=Integer.parseInt(st[1]);
			list[i][1]=a;
			list[i][0]=b;
		}
		
		//반복하며 회의 끝나는 시간을 기준으로 제일 빠른시간 선택
		end=list[0][0];
		ans=1;
		for(int i=0;i<N-1;i++) {
			if(end<list[i+1][1]) {
				end=list[i+1][0];
				ans+=1;
			}
		
		}
		System.out.println(ans);
		
		
	}
}
