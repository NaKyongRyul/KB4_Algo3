package Day4.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_신선영 {
    static int[] I;
    static int N;

    static int[] S;
    static int[] B;

    static long ansS;
    static long ansB;

    static long ans;
    static boolean[] included;

    static void subset(int n) {
        if (n == N) {
            ansS = 1;   // 곱하는 값은 1로 시작
            ansB = 0;
            for (int i = 0; i < N; i++) {
                // 만든 부분집합의 인덱스에 포함되면 계산 시작
                if (included[i]) {
                    ansS *= S[I[i]];
                    ansB += B[I[i]];

                }
            }
            // 공집합 제외 조건
            // 현재 답보다 작은 경우 답 변경
            if (ansS != 0 && ansB != 0 && (Math.abs(ansS - ansB)) < ans) {
                ans = Math.abs(ansS - ansB);
            }
            return;
        }

        included[n] = true;
        subset(n + 1);

        included[n] = false;
        subset(n + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = Long.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        I = new int[N];
        // 부분집합은 인덱스로 만들 것
        for (int i = 0; i < N; i++) {
            I[i] = i;
        }

        S = new int[N];
        B = new int[N];

        // 신맛, 쓴맛을 저장하는 배열을 만들고 인덱스를 통해 계산
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            S[n] = Integer.parseInt(st.nextToken());
            B[n] = Integer.parseInt(st.nextToken());
        }

        included = new boolean[N];
        subset(0);
        System.out.println(ans);
    }
}
