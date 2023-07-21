package Day9.B1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1931_회의실배정_최예빈 {

    static int N;
    static List<Meeting> meetings;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        meetings = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(
                    new Meeting(Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())));
        }

        // 빨리 시작하는
        meetings.sort(Comparator.comparingInt(o -> o.start));
        // 빨리 끝나는
        meetings.sort(Comparator.comparingInt(o -> o.end));

        int count = greedy();
        System.out.println(count);
    }

    private static int greedy() {
        int count = 0;
        int finish = 0;

        for (int i = 0; i < N; i++) {
            // 빨리 끝나는 걸 최대한 많이 바로 시작
            if (finish <= meetings.get(i).start) {
                count++;
                finish = meetings.get(i).end;
            }
        }

        return count;
    }

    private static class Meeting {
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
