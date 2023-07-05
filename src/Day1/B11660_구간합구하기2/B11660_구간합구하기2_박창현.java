package Day1.B11660_구간합구하기2;

/*
문제
N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.

예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.

1	2	3	4
2	3	4	5
3	4	5	6
4	5	6	7
여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.

표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

입력
첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다. 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)

출력
총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.

1 3 6
3 9 12
예제 입력 1  복사
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
예제 출력 1  복사
27
6
64
예제 입력 2  복사
2 4
1 2
3 4
1 1 1 1
1 2 1 2
2 1 2 1
2 2 2 2
예제 출력 2  복사
1
2
3
4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660_구간합구하기2_박창현 {
    public static void main(String[] args) throws IOException {

        //Scanner sc = new Scanner(System.in);
        //String s1 = sc.nextLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());//Integer.parseInt(s1.split(" ")[0]);
        int M = Integer.parseInt(st.nextToken());//Integer.parseInt(s1.split(" ")[1]);

        int[][] arr = new int[N][N];
        int[][] sum = new int[N][N];
        //System.out.println(N);
        for (int i = 0; i < N; i++) {
            //arr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[i][j] = arr[i][j];
                if ((i - 1) >= 0) sum[i][j] += sum[i - 1][j];
                if ((j - 1) >= 0) sum[i][j] += sum[i][j - 1];
                if ((i - 1) >= 0 && (j - 1) >= 0) sum[i][j] -= sum[i - 1][j - 1];
            }
        }
        int[] ret = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            //int[] xy = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int tx = Integer.parseInt(st.nextToken()) - 1;//xy[0] - 1;
            int ty = Integer.parseInt(st.nextToken()) - 1;//xy[1] - 1;
            int fx = Integer.parseInt(st.nextToken()) - 1;//xy[2] - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;//xy[3] - 1;
            //System.out.println(i+" "+tx+" "+ty+" "+fx+" "+fy+" ");
            ret[i] = sum[fx][fy];
            if ((tx - 1) >= 0) ret[i] -= sum[tx - 1][fy];
            if ((ty - 1) >= 0) ret[i] -= sum[fx][ty - 1];
            if ((tx - 1) >= 0 && (ty - 1) >= 0) ret[i] += sum[tx - 1][ty - 1];
        }
        for (int i : ret) {
            System.out.println(i);
        }
        //*/
    }
}
