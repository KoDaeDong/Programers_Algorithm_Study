import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
	public int solution(int[][] maps) {
	    int endX = maps.length;
	    int endY = maps[0].length;
	    
	    // 방문 여부와 시작점으로부터의 거리를 저장할 배열
	    int[][] visited = new int[endX][endY];
	    
	    // 상, 하, 좌, 우 이동을 위한 방향 배열
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    
	    Queue<Integer> myQ = new LinkedList<>();
	    
	    // 시작점 (0,0) 설정
	    myQ.add(0);
	    myQ.add(0);
	    visited[0][0] = 1; 

	    while (!myQ.isEmpty()) {
	        int x = myQ.poll();
	        int y = myQ.poll();
	        
	        if (x == endX - 1 && y == endY - 1) {
	        	System.out.println(visited[x][y]);
	            return visited[x][y];
	        }
	        
	        // 상하좌우 4방향 탐색
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            
	            if (nx >= 0 && nx < endX && ny >= 0 && ny < endY) {
	    
	                if (maps[nx][ny] == 1 && visited[nx][ny] == 0) {
	                    myQ.add(nx);
	                    myQ.add(ny);

	                    visited[nx][ny] = visited[x][y] + 1;
	                }
	            }
	        }
	    }
	
	    return -1;
	}
}