package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_박상희 {
	static ArrayList<int []> ingredients;
	static int N;
	static boolean [] isSelected;
	static int min = 1000000000;
		
	static void subSet(int num) {				
		int multi = 1;
		int sum = 0;
		
		if (num == N) {
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					if (!ingredients.isEmpty()) {
						multi *= ingredients.get(i)[0];
						sum += ingredients.get(i)[1];
					}
					else {
						multi *= 1;
						sum += 0;
					}
				}
			}
			
			if (!(multi == 1 && sum == 0)) {
				min = Math.min(min, Math.abs(multi - sum));
			}
			
			return;
		}
				
		isSelected[num] = false;
		subSet(num + 1);
		
		isSelected[num] = true;
		subSet(num + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
			
		ingredients = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
			int sour = Integer.parseInt(token.nextToken());
			int bitter = Integer.parseInt(token.nextToken());			
			
			ingredients.add(new int [] {sour, bitter});
		}
		
		isSelected = new boolean [N];
		
		subSet(0);
		
		System.out.println(min);
	}
}
