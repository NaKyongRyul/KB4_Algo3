

package  Day4.B1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759_암호만들기_김혜인 {
	 static int l, c;
	 static char pwd[] ;
	 static boolean isSelected [] ;
	 
	 
public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken()); 
    
    pwd = new char[c];
    isSelected = new boolean[c];
    
    StringBuilder stringBuilder = new StringBuilder();
    String str = br.readLine();
    for(int i =0; i<c; i++) {
    	pwd[i] = str.charAt(i*2);
    }
    
    Arrays.sort(pwd);
    
    subset(0,0);
	
}

 static void subset(int start, int count) {
	if(count == l) {
		int con = 0; //자음
		int vow = 0; //모음
		
		for(int i =0; i<c; i++) {
			//모음인지 확인
			if(isSelected[i]) {
				if (pwd[i]=='a' || pwd[i]=='e' || pwd[i]=='o' || pwd[i]=='u'|| pwd[i]=='i') {
					vow++;
			}else {
				con++;
			}
		}
	}
		
		//모음이 최소 1개 이상 + 자음 최소 2개 이상
		if (vow>=1 && con>=2) {
			for(int i=0; i<c; i++) {
				if(isSelected[i]) {
					System.out.print(pwd[i]);
				}
			}
			System.out.println();
	}
	}
	
		for(int i=start; i<c; i++) {
			isSelected[i] = true;
			subset(i+1, count+1);
			isSelected[i] = false;
		
	}
}

}

