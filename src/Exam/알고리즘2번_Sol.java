package Exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


// 02. 코로나 바이러스
// 2차원 배열에 시작점이 주어지는 경우 탐색을 하면서 최대탐색깊이를 구하는 문제
//
// 코로나에 걸릴 마지막 학생이 코로나에 걸리는데 필요한 날짜 = 첫 코로나 교육생 좌표로부터 얼마나 떨어져있는지 = 탐색에 필요한 비용 or 깊이
// 코로나에 걸리고 퇴소하는데 3일이 필요하므로 최대탐색깊이 + 3 을 출력하면 됨

// 1. 입력으로 주어진 코로나 시작점으로부터 인접한 상하좌우 좌표로 탐색 구현하기
// 2. 탐색 하면서 다음 3가지 변수를 업데이트
//		a) dist 배열 (시작좌표로부터 탐색거리 기록)  ~ 동적 프로그래밍 (Memorization)
//		b) board 배열 (교육장 상태 표현)  : 탐색한 교육생 좌표는 비어있도록 처리
//		c) ans 변수 = 최대탐색깊이
// 3. 탐색 종료 후 교육장에 남아있는 교육생의 수를 카운트 및 출력
 

// 좌표를 표현할 클래스 정의
class Pos{
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class 알고리즘2번_Sol {
	
    static int N;							// 전체 열 N				
    static int M;							// 전체 행 M
    static int [][] board;					// 교육장 표현할 2차원 배열
    static int [][] dist ;					// 첫 코로나 교육생 좌표로부터 얼마나 떨어져있는지 마킹할 배열 (초기값 = -1)
    static int [] dx = {1,-1,0,0};			// 상하좌우 이동 표현
    static int [] dy = {0,0,1,-1};			// 상하좌우 이동 표현
    static int ans = 0;						// 마지막 학생이 코로나에 걸리는데 필요한 날짜

    // 배열의 좌표 바운더리 검사 
    static boolean checkValid(int x , int y) {
        if(x<0 || x>= N || y<0 || y>=M) return false;
        return true;
    }

    // BFS 탐색
    static void BFS(int x , int y) {
    	
    	// 초기화 - Queue , dist 배열 , board 배열
    	Queue <Pos> que = new ArrayDeque<>();
    	que.add(new Pos(x,y));
    	dist[y][x] = 0;
    	board[y][x] = 0;
    	
    	// while 문 탐색
    	while(!que.isEmpty()) {
    		
    		// 큐에서 현재 좌표 꺼내기
    		Pos now = que.poll();
    		
    		// 다음 탐색 좌표 선언
    		int next_x , next_y;
    		
            for(int i=0; i<4; i++) {
                next_x = now.x + dx[i];
                next_y = now.y + dy[i];
                
                // 좌표가 유효하지 않거나 board 배열이 비어있는 경우 skip
                if( (!checkValid(next_x , next_y)) || board[next_y][next_x] == 0 ) continue;
                
                // 이미 방문한적 있다면 skip
                if(dist[next_y][next_x]!=-1) continue;
                
                // 해당 좌표에 대해 dist 배열 업데이트 
                dist[next_y][next_x] = dist[now.y][now.x] + 1;
                
                // 해당 좌표에 대해 board 배열 업데이트 (퇴소처리)
                board[next_y][next_x] = 0;
                
                // 정답값 업데이트 (마지막 학생이 코로나에 걸리는데 필요한 날짜 = 코로나 시작점 으로부터 거리)
                ans = Math.max(dist[next_y][next_x], ans);
                
                // 큐에 다음에 방문할 좌표 추가
                que.offer(new Pos(next_x,next_y));
            }
    	}
    }
    

    // 코로나에 걸리지 않은 학생 수 구하기 (board[y][x] == 1 인 경우 카운트)
    static int countRemain() {
    	int remain = 0;
    	for(int y=0;  y<M;y++) 
    		for(int x=0; x<N;x++) if(board[y][x] == 1) remain++;
    	return remain;
    }


    public static void main(String[] args) throws IOException {

    	// 입력 처리 및 초기화 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] splits = bf.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        
        board = new int [M][N];
        dist = new int [M][N];
        
        for(int y=0; y<M; y++) {
            char [] temp = bf.readLine().toCharArray();
            for(int x=0; x<N; x++) {
                board[y][x] = temp[x] - '0';
            }
        }

        splits = bf.readLine().split(" ");
        int start_x = Integer.parseInt(splits[0]) - 1;
        int start_y = Integer.parseInt(splits[1]) - 1;
        
        // -1 로 dist 배열 초기화
        for(int i=0; i<M; i++) Arrays.fill(dist[i], -1);
        
        // 코로나가 시작될 좌표에 BFS 탐색
        BFS(start_x , start_y);
        
        // 정답 = 마지막 학생이 코로나에 걸릴 날짜 + 퇴소하는데 필요한 3일 
        System.out.println(ans + 3);
        
        // 코로나에 걸리지 않을 학생 수 출력
        System.out.println(countRemain());

    }
}
