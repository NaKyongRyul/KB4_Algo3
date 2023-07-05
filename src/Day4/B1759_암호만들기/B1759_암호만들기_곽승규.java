package Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_곽승규 {

	static int L;
	static int C;
	static char [] arr;
	static char [] code;
	static int count;
	
	
	static boolean isCodeValid() {
		int mo = 0;
		int ja = 0;
		
		for (char c : code) {
			if ( c == 'a' 
					|| c == 'e' 
					|| c == 'i' 
					|| c == 'o' 
					|| c == 'u') {
				mo++;
			}else {
				ja++;
			}
		}
		
		if (mo >= 1 && ja >= 2) {
			return true;
		}
		return false;
	}
	
	static void codeSubset (int r, int start) {
		if (r == L) {
			if(isCodeValid()) {
				System.out.println(code);
			}
			return;
		}

		for(int i = start; i < C; i++) {
			code[r] = arr[i];
			codeSubset(r+1, i+1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		code = new char[L];
		
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		//사전순으로 우선 정렬
		Arrays.sort(arr);
	
		codeSubset(0,0);	
	}

}
