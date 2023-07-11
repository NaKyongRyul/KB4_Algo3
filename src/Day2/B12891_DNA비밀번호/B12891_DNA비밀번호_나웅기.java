package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_나웅기 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
		
        int result = 0;
        char [] arr = reader.readLine().toCharArray();
        
        int [] pass = new int [4];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i<4; i++) {
        	pass[i] = Integer.parseInt(st.nextToken());
        	
        }
        
        int [] password = new int [4];
        
        for (int i = 0; i < p; i++) {
        	switch (arr[i]) {
	        	case 'A':
	        		password[0]++;
	        		break;
	        	case 'C':
	        		password[1]++;
	        		break;
	        	case 'G':
	        		password[2]++;
	        		break;
	        	case 'T':
	        		password[3]++;
	        		break;
        	}

        }
        
        if (password[0] >= pass[0] && password[1] >= pass[1]&& password[2]>=pass[2] && password[3]>=pass[3])
        	result++;

        int start = 0;
        int end = start + p -1;
        while (end < s-1) {
        	end++;
        	switch (arr[start]) {
        	case 'A':
        		password[0]--;
        		break;
        	case 'C':
        		password[1]--;
        		break;
        	case 'G':
        		password[2]--;
        		break;
        	case 'T':
        		password[3]--;
        		break;
        	}

        	switch (arr[end]) {
        	case 'A':
        		password[0]++;
        		break;
        	case 'C':
        		password[1]++;
        		break;
        	case 'G':
        		password[2]++;
        		break;
        	case 'T':
        		password[3]++;
        		break;
        	}

        	start++;
        	
        	if (password[0] >= pass[0] && password[1] >= pass[1]&& password[2]>=pass[2] && password[3]>=pass[3])
            	result++;


        }
        System.out.println(result);
        
	}
}
