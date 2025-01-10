class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
            if(board[h][w].equals(board[nx][ny])) answer++;
        }
        return answer;
    }
}
/*
9:04 ~ 9:09
    1. board[h][w] 기준 상하좌우 반복문으로 본다.
        1-1) 단 범위 벗어나는 경우 조건 처리
    2. 끝
*/
