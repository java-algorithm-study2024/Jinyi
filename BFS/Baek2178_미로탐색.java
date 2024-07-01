import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      char[][] miro = new char[N][M];
      int[][] dist = new int[N][M];
      int[] dx = {1, 0 , -1, 0};
      int[] dy = {0, 1, 0, -1};
      Queue<Pair> qu = new LinkedList<>();
      
      for(int i=0; i<N; i++){
          String line = bf.readLine();
          for(int j=0; j<M; j++){
              miro[i][j] = line.charAt(j);
              dist[i][j] = -1;    // 거리를 -1로 세팅하면, 방문여부를 확인가능.
          }
      }
      
      qu.offer(new Pair(0,0));  // 시작점
      dist[0][0] = 0;   // 첫 시작이니까 거리가 0이다.
      
      while(!qu.isEmpty()){
          Pair p = qu.poll();
          
          for(int i=0; i<4; i++){
            int nX = p.x + dx[i];
            int nY = p.y + dy[i];
            
            if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                continue;
            }
            if(miro[nX][nY] == '0' || dist[nX][nY] != -1){
                continue;
            }
            
            qu.offer(new Pair(nX, nY));
            dist[nX][nY] = dist[p.x][p.y] + 1;
          }
      }
      
      System.out.print(dist[N-1][M-1] + 1);
    }
    
    public static class Pair{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }
}
출처: https://iseunghan.tistory.com/312 [iseunghan:티스토리]
