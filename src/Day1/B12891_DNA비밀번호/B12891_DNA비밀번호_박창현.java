package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//‘A’, ‘C’, ‘G’, ‘T’
public class B12891_DNA비밀번호_박창현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine(), " ");
        int numA = Integer.parseInt(st.nextToken());
        int numC = Integer.parseInt(st.nextToken());
        int numG = Integer.parseInt(st.nextToken());
        int numT = Integer.parseInt(st.nextToken());

        //System.out.println(numA + " " + numC + " " + numG + " " + numT + " ");
        int count = 0;
        int A = 0, C = 0, G = 0, T = 0;

        for (int i = 0; i < M; i++) {
            if (arr[i] == 'A') A++;
            if (arr[i] == 'C') C++;
            if (arr[i] == 'G') G++;
            if (arr[i] == 'T') T++;
        }
        if (A >= numA && C >= numC && G >= numG && T >= numT) count++;
        //if (numA <= 0 && numC <= 0 && numG <= 0 && numT <= 0) count = 1;
        int s = 0;
        while (s < N-M) {
            switch (arr[s+M]) {
                case 'A':
                    A++;
                    break;
                case 'C':
                    C++;
                    break;
                case 'G':
                    G++;
                    break;
                case 'T':
                    T++;
                    break;
            }
            switch (arr[s]) {
                case 'A':
                    A--;
                    break;
                case 'C':
                    C--;
                    break;
                case 'G':
                    G--;
                    break;
                case 'T':
                    T--;
                    break;
            }
            if (A >= numA && C >= numC && T >= numT && G >= numG) count++;
            //if (A <= 0 && C <= 0 && T <= 0 && G <= 0) count++;
            s++;
        }
        System.out.println(count);
    }
}
        /*

        List<Character> str = new ArrayList<>();

        char[] arr = br.readLine().toCharArray();
        int[] check = new int[4];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M-1; i++) {
            str.add(arr[i]);
        }

        for (int i = 0; i < N - M + 1; i++) {
            str.add(arr[M+i-1]);
            //System.out.println(str);
            for (int j = i; j < M+i; j++) {
                if (arr[j]==)
            }
            if(Collections.frequency(str,'A')>=check[0]&&
                    Collections.frequency(str,'C')>=check[1]&&
                    Collections.frequency(str,'G')>=check[2]&&
                    Collections.frequency(str,'T')>=check[3])
                count++;
            str.remove(0);
        }
        System.out.println(count);//*/