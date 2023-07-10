package Day1.B10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기_전종한 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader 사용
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());

		String str = reader.readLine();
		String [] strs = str.split(" ");

		int [] arr = new int[N];

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}

		int v = Integer.parseInt(reader.readLine());

		int count = 0;

		for(int item : arr){
			if(item == v) count++;
		}

		System.out.print(count);
	}
}
