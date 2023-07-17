package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1068_트리_김진형 {
    public class Main {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deleteNodeNum = Integer.parseInt(br.readLine());
            int nodeNum = 1;
            ArrayList<Integer>[] adList = new ArrayList[N];
            for (int i = 0; i < N; ++i) {
                adList[i] = new ArrayList<>();
            }
            int root = -1;
            for (int i = 0; i < N; ++i) {
                int parent = Integer.parseInt(st.nextToken());
                if (parent == -1) {
                    root = i;
                    continue;
                }
                adList[parent].add(i);
            }

            Stack<Integer> stk = new Stack<>();

            if (deleteNodeNum == root) {
                System.out.println(0);
                return;
            }

            stk.push(root);
            int ans = 0;
            while (!stk.isEmpty()) {
                int currNode = stk.pop();
                for (int i = 0; i < adList[currNode].size(); ++i) {
                    int childNode = adList[currNode].get(i);

                    if (childNode == deleteNodeNum) {
                        if (adList[currNode].size() == 1) {
                            ans++;
                        }
                        continue;
                    }
                    stk.push(childNode);
                }
                if (adList[currNode].isEmpty()) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
