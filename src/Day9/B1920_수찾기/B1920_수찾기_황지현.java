
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920_수찾기_황지현 {
	static int [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		arr=new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m=Integer.parseInt(br.readLine());
		StringTokenizer st2= new StringTokenizer(br.readLine());
		int []arr2=new int [m];
		for(int i=0;i<m;i++) {
			int a=Integer.parseInt(st2.nextToken());
			Search(a);
		}
		
		
	}
	
	public static void Search(int x) {
		int low=0;
		int high=arr.length-1;
		
		while(low<high) {
			int mid=(low+high)/2;
			if (arr[mid]==x) {
				System.out.println(1);
				return;
			}
			else if(arr[mid]>x) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		System.out.println(0);
		return;
	}
}
