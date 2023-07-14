package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2961_도영이가만든맛있는음식_정지원 {
	static Flavor[] arr;
	static int N;
	
	static Flavor[] select;
	static boolean[] isSelected;
	static int min;
	
	public static void combination(int idx, int size, int r) {
		if(size==r) {
			int sour=1;
			int bitter=0;
			for(int i=0;i<r;i++) {
				sour *=select[i].sour;
				bitter += select[i].bitter;
			};
			if(min>Math.abs(bitter -sour)){
				min = Math.abs(bitter-sour);
			}
			return;
		}
		for(int i=idx;i<N;i++) {
			if(isSelected[i])continue;
			isSelected[i] = true;
			select[size] = arr[i];
			combination(i, size+1, r);
			
			isSelected[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		min = 10000000;
		
		arr = new Flavor[N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			arr[i] = new Flavor(Integer.parseInt(str.split(" ")[0]), Integer.parseInt(str.split(" ")[1]));
		}
		
		
		isSelected = new boolean[N];
		
		
		for(int i = 1;i<=N;i++) {
			select = new Flavor[i];
			combination(0, 0, i);
		}
		
		System.out.println(min);
	}
}

class Flavor{
	int sour;
	int bitter;
	Flavor(int s, int b){
		sour = s;
		bitter = b;
	}
}
