
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class B2750_버블정렬_황지현 {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int [] arr=new int[n];
//		StringTokenizer str = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(in.readLine());
		
		
		for(int i=0;i<n-1;i++) {
			for (int j=i;j<n;j++) {
				if(arr[i]>arr[j]) {
					
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
		
	}

}
