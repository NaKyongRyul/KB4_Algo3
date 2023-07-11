package Day2.B12891_DNA비밀번호;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_Sol {

	public static boolean checkPassword(int [] dnaRule , int [] nowDNA  ) {
		for(int i=0; i<4; i++){
			if(dnaRule[i] > nowDNA[i]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력 처리 //
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] strs = bf.readLine().split(" ");
        int S = Integer.parseInt(strs[0]);
        int P = Integer.parseInt(strs[1]);
        char [] dna = bf.readLine().toCharArray();


        // 비밀번호 규칙 받아오기 (각 dna 개수 -> 순서대로 'A' , 'C' , 'G' , 'T')
        int [] dnaRule = new int [4]; 
        strs = bf.readLine().split(" ");
        for(int j=0; j<4; j++) dnaRule[j] = Integer.parseInt(strs[j]);
        
        int [] nowDNA = new int [4];     // 현재 DNA 개수 카운트 배열
        int ans = 0;  					 // 정답
        
        
        // 초기화 //
        for(int i = 0; i < P; i++) {
        	char v = dna[i];
            if(v=='A') nowDNA[0] += 1;
            else if(v=='C') nowDNA[1] +=1;
            else if(v=='G') nowDNA[2] +=1;
            else if(v=='T') nowDNA[3] +=1;
        }
        
        if(checkPassword(dnaRule , nowDNA) == true) ans +=1;
        
        
        // 탐색 // 
        for(int c = 1; c<S-P+1; c++ )
        {
        	// 삭제 dna 와 추가할 dna 확인
            char remove = dna[c-1];
            char add = dna[P+c-1];
            
            // 삭제
            if(remove=='A') nowDNA[0] -= 1;
            else if(remove=='C') nowDNA[1] -=1;
            else if(remove=='G') nowDNA[2] -=1;
            else if(remove=='T') nowDNA[3] -=1;

            // 추가
            if(add=='A') nowDNA[0] += 1;
            else if(add=='C') nowDNA[1] +=1;
            else if(add=='G') nowDNA[2] +=1;
            else if(add=='T') nowDNA[3] +=1;
         
            // 비밀번호 확인
            if(checkPassword(dnaRule , nowDNA) == true) ans +=1;
        }
        System.out.println(ans);
    }
}


