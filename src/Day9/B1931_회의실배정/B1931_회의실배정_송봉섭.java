package Day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1931_회의실배정_송봉섭 {
    static int N;
    static int[][] meetings;

    static int count;

    static int start;
    static int end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(strings[0]);
            meetings[i][1] = Integer.parseInt(strings[1]);
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1]) return a[1] - b[1]; // 뒤
                else return a[0] - b[0];
            }
        });

//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(meetings[i]));
//        }

        start = 0;
        end = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= end) {
                    start = meetings[i][0];
                    end = meetings[i][1];
                    //System.out.println(start + " " +end);
                    count++;
                }
        }
        System.out.println(count);

    }
}
