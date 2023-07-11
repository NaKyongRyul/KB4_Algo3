package Day2.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_김철 {
	static int S,P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        S = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        char[] dna = br.readLine().toCharArray();

        int[] dnaRule = new int[4];
        token = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            dnaRule[i] = Integer.parseInt(token.nextToken());
        }

        int[] nowDNA = new int[4];

        for(int i=0; i<P; i++){
            char v = dna[i];
            if(v == 'A') nowDNA[0]++;
            else if(v == 'C') nowDNA[1]++;
            else if(v == 'G') nowDNA[2]++;
            else if(v == 'T') nowDNA[3]++;
        }

        int result = 0; //

        if(check(dnaRule, nowDNA)) result++;

        for(int i=1; i<=S-P; i++){
            char removeChar = dna[i-1];
            char addChar = dna[i + P - 1];

            if(removeChar == 'A') nowDNA[0]--;
            else if(removeChar == 'C') nowDNA[1]--;
            else if(removeChar == 'G') nowDNA[2]--;
            else if(removeChar == 'T') nowDNA[3]--;

            if(addChar == 'A') nowDNA[0]++;
            else if(addChar == 'C') nowDNA[1]++;
            else if(addChar == 'G') nowDNA[2]++;
            else if(addChar == 'T') nowDNA[3]++;

            if(check(dnaRule, nowDNA)) result++;
        }


        bw.write(result + "");
        bw.close();
    }

    static boolean check(int[] dnaRule, int[] nowDNA){

        for(int i=0; i<4; i++){
            if(dnaRule[i] > nowDNA[i]) return false;
        }
        return true;
    }
}
