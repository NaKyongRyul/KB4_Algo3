package Day7.B1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1991_트리순회_박창현 {
    static int[][] arr;
    static StringBuilder sb;

    static void dfs(int nodeidx, int logic) {
        // '.'-'A' 값은 -19
        // 로직: 0-전위순회 1-중위순회 2-후위순회
        if (logic == 0) sb.append((char) (arr[nodeidx][0] + 'A'));
        if (arr[nodeidx][1] >= 0) dfs(arr[nodeidx][1], logic);
        if (logic == 1) sb.append((char) (arr[nodeidx][0] + 'A'));
        if (arr[nodeidx][2] >= 0) dfs(arr[nodeidx][2], logic);
        if (logic == 2) sb.append((char) (arr[nodeidx][0] + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = st.nextToken().charAt(0) - 'A';
            arr[i][1] = st.nextToken().charAt(0) - 'A';
            arr[i][2] = st.nextToken().charAt(0) - 'A';
        }
        // 값이 항상 정렬되어 들어오는것이 아니므로
        // arr[n][0]값과 인덱스를 동일하게 만들기 위해 arr 정렬
        // "노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며" 라는 조건이 있기 때문에
        // 정렬하면 항상 인덱스와 해당 노드의 값이 일치함.
        Arrays.sort(arr, (Comparator.comparingInt(o -> o[0])));
        sb = new StringBuilder();
        // 전위순회
        dfs(0, 0);
        sb.append("\n");
        // 중위순회
        dfs(0, 1);
        sb.append("\n");
        // 후위순회
        dfs(0, 2);
        System.out.println(sb);
    }
}
