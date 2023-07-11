package Day2.B12891_DNA비밀번호;

import java.util.Scanner;

public class B12891_DNA비밀번호_장재은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pw_cnt = 0;
		int s = sc.nextInt();
		int p = sc.nextInt();
		
		String [] pw = sc.next().split("");
		
		int arr [] = new int [4];
		int cnt [] = new int [4];
		for(int i=0; i<4; i++) {
			arr[i] = sc.nextInt();
		}
		
		int start = 0;
		int end = 0;
		
		for(int i=0; i<p; i++) {
			if(pw[i].equals("A")){
				cnt[0] += 1;
			} else if (pw[i].equals("C")) {
				cnt[1] += 1;
			} else if(pw[i].equals("G")) {
				cnt[2] += 1;
			} else if(pw[i].equals("T")) {
				cnt[3] += 1;
			}
			end++;
		}
		
		boolean flag = true;
		for(int i=0; i<4; i++) {
			if(cnt[i] < arr[i]) {
				flag = false;
				break;
			}
		}
		if(flag == true) {
			pw_cnt++;
		}
		
		for(int i=0; i<s-p; i++) {
			if(pw[start].equals("A")){
				cnt[0] -= 1;
			} else if (pw[start].equals("C")) {
				cnt[1] -= 1;
			} else if(pw[start].equals("G")) {
				cnt[2] -= 1;
			} else if(pw[start].equals("T")) {
				cnt[3] -= 1;
			}
			start++;			
			
			if(pw[end].equals("A")){
				cnt[0] += 1;
			} else if (pw[end].equals("C")) {
				cnt[1] += 1;
			} else if(pw[end].equals("G")) {
				cnt[2] += 1;
			} else if(pw[end].equals("T")) {
				cnt[3] += 1;
			}
			end++;
			
			flag = true;
			for(int k=0; k<4; k++) {
				if(cnt[k] < arr[k]) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				pw_cnt++;
			}
		}
		System.out.println(pw_cnt);
		sc.close();
	}
}