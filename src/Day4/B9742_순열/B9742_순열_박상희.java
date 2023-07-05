package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9742_순열_박상희 {
	static int R;
	static int [] selection;
	static boolean [] isSelected;
	static int count;
	
	public static void permutation(char [] arr, int r, int num) {		
		if (r == R) { // r : 지금 내가 몇 개 골랐는지 보여 주는 변수
			count++;
			
			if (count == num) {
				for (int i = 0; i < R; i++) {
					System.out.print(arr[selection[i]]);
				}

				System.out.println();
			}
			
			return;
		}
		
		for (int j = 0; j < arr.length; j++) {
			if (isSelected[j]) {
				continue;
			}
			
			isSelected[j] = true;
			selection[r] = j;
			permutation(arr, r + 1, num);
			isSelected[j] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = bf.readLine()) != null && !input.isEmpty()) {
			String inputArr[] = new String[2];
			inputArr = input.split(" ");
			
			char pArr[] = new char[inputArr[0].length()];

			for (int p = 0; p < inputArr[0].length(); p++) {
				pArr[p] = inputArr[0].charAt(p);
			}
			int num = Integer.parseInt(inputArr[1]);
					
			R = inputArr[0].length();
			selection = new int [R];
			isSelected = new boolean [pArr.length];
			count = 0;
						
			System.out.print(inputArr[0] + " " + inputArr[1] + " = ");
			permutation(pArr, 0, num);
			if (count < num) {
				System.out.println("No permutation");
			}
		}
	}
}
