package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931_회의실배정_조승빈 {
    static int N;
    static int cnt;
    static int endT;

    static int[][] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        cnt = 1;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        sortMeetings();
        endT = meetings[0][1];

        System.out.println(Arrays.deepToString(meetings));

        for (int i = 1; i < N; i++) {
            if (meetings[i][0] >= endT) {
                cnt++;
                endT = meetings[i][1];
            }
        }

        System.out.println(cnt);
    }

    private static void sortMeetings() {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
    }
}
