import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class B12891_DNA비밀번호_송봉섭 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        System.out.println();

        sc.nextLine(); // Enter

        String str = sc.next();
        String [] strings = str.split(""); // [G, A, T, A]

//        System.out.println("S = " + S + " , " + " P = " + P);
//        System.out.println(Arrays.toString(strings));

        //  {‘A’, ‘C’, ‘G’, ‘T’}
        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();
        //System.out.println(A + " " + C + " " + G +" " + T);

        int aNum = 0 , cNum = 0, gNum= 0, tNum = 0;

        int count = 0;

        int start = 0;
        int end = P;
        // 처음 ~ 끝
        for (int i = start; i < end; i++) {
            if (strings[i].equals("A")) {
                aNum++;
            }
            if (strings[i].equals("C")) {
                cNum++;
            }
            if (strings[i].equals("G")) {
                gNum++;
            }
            if (strings[i].equals("T")) {
                tNum++;
            }
        }

        if (aNum >= A && cNum >= C && gNum >= G && tNum >= T) {
            count++;
        }


        // 초기값 끝

        while (end < S) {
            if (strings[start].equals("A")) {
                aNum--;
            }
            if (strings[start].equals("C")) {
                cNum--;
            }
            if (strings[start].equals("G")) {
                gNum--;
            }
            if (strings[start].equals("T")) {
                tNum--;
            }
            start++;

            end++;
            if(strings[end-1].equals("A")) {
                aNum++;
            }
            if (strings[end-1].equals("C")) {
                cNum++;
            }
            if (strings[end-1].equals("G")) {
                gNum++;
            }
            if (strings[end-1].equals("T")) {
                tNum++;
            }


            if (aNum >= A && cNum >= C && gNum >= G && tNum >= T) {
                count++;
            }
        }
        System.out.println(count);



    }
}
