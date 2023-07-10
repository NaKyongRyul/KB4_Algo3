package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class B10807_개수세기_정지원{
    public static void main(String[] agrs) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(reader.readLine());
				
		String str = reader.readLine();
		String [] strs = str.split(" ");

		int [] arr = new int[n];
		
		for(int i=0;i<strs.length;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int v= Integer.parseInt(reader.readLine());
		
		int count=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==v) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}