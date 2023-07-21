package Day10.B1197_최소신장트리;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 간선 클래스 정의 (시작점 , 도착점 , 가중치)
class Edge {
	
	int start;
	int end;
	int weight;
	
	Edge(int start , int end , int weight){
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "[" + this.start + "," + this.end + "," + this.weight + "]";
	}
	
}

public class B1197_최소신장트리_Sol {

	static int [] parent;
	
    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
 
    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(bf.readLine() , " ");
		int V = Integer.parseInt(token.nextToken());
		int E = Integer.parseInt(token.nextToken());
		
		// 유니온 파인드에 사용할 부모 배열 초기화 
		parent = new int [V+1];
		Arrays.setAll(parent, i->i);
		
		// 간선 배열 초기화
		Edge [] edges = new Edge [E];
		
		// 간선 입력 받기 (u v w)
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(bf.readLine() , " ");
			int u = Integer.parseInt(token.nextToken());
			int v = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			
			//  간선 = Edge 클래스로 표현
			edges[i] = new Edge(u,v,weight);					
		}
		
		
		// 크루스칼 알고리즘 사용 => 간선 정렬 (lambda 이용) 
		Arrays.sort(edges , (a,b) -> a.weight - b.weight);

		int ans = 0;				//  MST 의 가중치 합을 저장할 변수
		
		// 간선 탐색
		for(Edge now : edges) {
			
			// 사이클이 형성되지 않는다면 해당 간선 선택 //
			if(find(now.start) != find(now.end)) {
				
				// 연결상태 추가
				union(now.start , now.end);
				
				// 가중치값 추가
				ans += now.weight;
			}
		}
		
		System.out.println(ans);
	}
}

