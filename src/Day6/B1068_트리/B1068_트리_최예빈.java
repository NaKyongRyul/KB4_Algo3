package Day6.B1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1068_트리_최예빈 {

    static int N;
    static Map<Integer, List<Integer>> tree;
    static int removed;


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            tree.put(i, new ArrayList<>());
        }

        int parent;
        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            parent = Integer.parseInt(strings[i]);
            if (parent != -1) tree.get(parent).add(i);
        }

        removed = Integer.parseInt(br.readLine());

        // 삭제할 노드 이하의 노드 제거
        deleteNode(removed);

        // 리프 노드 세기
        int count = 0;
        int size;
        for (Integer key : tree.keySet()) {
            size = tree.get(key).size();
            if (size == 0) {    // 자식노드가 없음
                count++;
            } else if (size == 1 && tree.get(key).contains(removed)) {  // 자식 노드가 있으나 삭제함
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * 자식 노드르 지우고 자기 자신도 지움
     * @param start 노드 번호
     */
    private static void deleteNode(int start) {
        for (Integer next : tree.get(start)) {
            deleteNode(next);
        }
        tree.remove(start);
    }
}
