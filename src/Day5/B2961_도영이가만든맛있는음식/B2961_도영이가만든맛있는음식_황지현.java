
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class B2961_도영이가만든맛있는음식_황지현 {
	static int N;
	static int R=0;
	static int []S;
	static int []B;
	static boolean [] isSelected;

	static ArrayList<Integer> ans=new ArrayList<>();
	//collections 라이브러리 import해서 Collections.min()이런거 쓰기
	public static void subset(int n) {
		System.out.println("subset실행"+n);
		if (n==N) {
			int s_taste=1;
			int b_taste=0;
			for(int i=0;i<N;i++) {
			if (isSelected[i]) {
				s_taste=s_taste*S[i];
				b_taste+=B[i];
			}
			
		}
//		System.out.println(s_taste);
//		System.out.println(b_taste);
		if(b_taste!=0)ans.add(Math.abs(s_taste-b_taste));
		return;
		}
		isSelected[n]=true;
		subset(n+1);
		
		isSelected[n]=false;
		subset(n+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		S=new int[N];
		B=new int[N];
		isSelected=new boolean [N];
		for (int i=0;i<N;i++){
			String [] str=br.readLine().split(" ");
			S[i]=Integer.parseInt(str[0]);
			B[i]=Integer.parseInt(str[1]);
		}
		
		while(R<N) {
			subset(0);
			R++;
		}
		System.out.println(Collections.min(ans));
	}
}
