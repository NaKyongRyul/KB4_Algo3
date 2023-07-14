package Day4.B9742_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9742_순열_최예빈 {

    static char[] chars, output;
    static String line;
    static int find, arrSize, count;
    static boolean[] visited;
    static int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((line = br.readLine()) != null) {    // 입력이 들어오는 동안

            st = new StringTokenizer(line);
            chars = st.nextToken().toCharArray();
            find = Integer.parseInt(st.nextToken());

            arrSize = chars.length;
            if (find > factorial[arrSize]) {    // 순열의 길이 초과
                System.out.println(line + " = " + "No permutation");
                continue;
            }

            sb = new StringBuilder();
            visited = new boolean[arrSize];
            output = new char[arrSize];
            count = 0;

            permutation(0);
        }
    }

    private static void permutation(int depth) {
        if (depth == arrSize) {
            if (++count == find) System.out.println(line + " = " + sb);
            return;
        }

        for (int i = 0; i < arrSize; i++) {
            if (visited[i]) continue;

            // 선택
            visited[i] = true;
            sb.append(chars[i]);
            permutation(depth + 1);

            // 선택 해제
            visited[i] = false;
            sb.deleteCharAt(depth);
        }
    }
}
