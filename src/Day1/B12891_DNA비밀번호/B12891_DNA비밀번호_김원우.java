package Day1.B12891_DNA비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B12891_DNA비밀번호_김원우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int ans = 0;

        String str = br.readLine();

        int[] min = new int[4];
        HashMap<Character, Integer> arr = new HashMap<Character, Integer>();
        arr.put('A', 0);
        arr.put('C', 0);
        arr.put('G', 0);
        arr.put('T', 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < p; i++) {
            arr.put(str.charAt(i), arr.get(str.charAt(i)) + 1);
        }

        if (arr.get('A') >= min[0] && arr.get('C') >= min[1] &&
                arr.get('G') >= min[2] && arr.get('T') >= min[3]) {
            ans++;
        }

        int start = 0;
        int end = start+p;

        for (int i = 0; i < s - p; i++) {
            arr.put(str.charAt(start + i), arr.get(str.charAt(start + i)) - 1);
            arr.put(str.charAt(end + i), arr.get(str.charAt(end + i)) + 1);

            if (arr.get('A') >= min[0] && arr.get('C') >= min[1] &&
                    arr.get('G') >= min[2] && arr.get('T') >= min[3]) {
                ans++;
            }
        }


//        System.out.println(arr.toString());
        System.out.println(ans);
    }
}
