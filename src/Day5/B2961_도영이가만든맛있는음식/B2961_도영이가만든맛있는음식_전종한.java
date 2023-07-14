package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Flavor{
	public int s;
	public int b;

	public Flavor(int s, int b) {
		this.s = s;
		this.b = b;
	}
}

public class B2961_도영이가만든맛있는음식_전종한 {
	static Flavor [] flavor;
	static Flavor [] select;
	static boolean [] isSelected;
	static int N;
	static int min;

	static void find_min(int idx, int size, int R) {
		if(size == R) {
			int s=1;
			int b=0;
			for(int i=0; i<R; i++) {
				s *= select[i].s;
				b += select[i].b;
			}
			if(min > Math.abs(s-b)) min = Math.abs(s-b);
			return;
		}
		for(int i=idx; i<N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[size] = flavor[i];
			find_min(i, size+1, R);
			isSelected[i]= false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		flavor = new Flavor [N];
		select= new Flavor [N];
		min = 1000_000_000;
		for(int i=0; i<N; i++) {
			String [] strs = bf.readLine().split(" ");
			flavor[i] = new Flavor(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
		}

		isSelected = new boolean[N];

		for(int i=1; i<=N; i++) {
			find_min(0,0,i);
		}

		System.out.println(min);

	}
}

