package Day9.B1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기_유유정 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(bf.readLine());
		int [] arr_N = new int [N];
		String s = bf.readLine();
		String [] strs =s.split(" ");
		for(int i=0;i<N;i++)
			arr_N[i]= Integer.parseInt(strs[i]);
		int M =Integer.parseInt(bf.readLine());
		int [] arr_M = new int [M];	
		s = bf.readLine();
		strs =s.split(" ");
		for(int i=0;i<M;i++)
			arr_M[i]= Integer.parseInt(strs[i]);
		Arrays.sort(arr_N);

		for(int i=0;i<M;i++) {

			if(binarySearch2(arr_N, arr_M[i])>=0)
				System.out.println(1);
			else
				System.out.println(0);
		}
			
	}
	public static int binarySearch2(int [] arr, int n) {
		int low = 0;
		int high = arr.length-1;
		int mid;
		while(low<=high) {
			mid = (low+high)/2;
			if(arr[mid] == n) return mid;
			else if(arr[mid]>n)
				high = mid-1;
			else
				low = mid+1;
		}
		return -1;
	
	}

}
