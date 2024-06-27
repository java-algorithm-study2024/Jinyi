import java.util.LinkedList;
import java.util.Queue;
class Solution {
    // 상 하 좌 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
    public static int bfs(int x, int y, int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;	
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			// 현재 노드 기준 상하좌우 확인
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;	// 범위를 벋어난 경우
				if(maps[nx][ny]==0) continue;	// 벽인 경우
				if(maps[nx][ny] == 1) {	// 처음 방문하는 경우
					q.offer(new Node(nx, ny));
					maps[nx][ny] = maps[x][y] + 1;
					if(nx == n-1 && ny == m-1) break;
				}
			}
		}
        if(maps[n-1][m-1] == 1) return -1;
		return maps[n-1][m-1];
	}
    
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        return answer;
    }
}

class Node {
	public int x;
	public int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
