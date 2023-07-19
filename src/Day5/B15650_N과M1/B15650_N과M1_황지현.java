
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M1_황지현 {
	static int N;
	static int R;
	static int [] arr;
	static boolean [] isSelected;
	static int [] select;
	
	public static void Combination(int idx,int size) {
		if (size==R) {
			for(int i=0;i<R;i++) {
				System.out.print(arr[select[i]]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(isSelected[i]==true)continue;
			
			isSelected[i]=true;
			select[size]=i;
			Combination(i,size+1);
			
			isSelected[i]=false;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String [] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		R=Integer.parseInt(str[1]);
		arr=new int [N];
		for (int i=0;i<N;i++) arr[i]=i+1;
		isSelected=new boolean [N];
		select=new int [R];
		
		Combination(0,0);
	}
}
