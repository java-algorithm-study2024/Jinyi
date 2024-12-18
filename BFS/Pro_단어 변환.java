import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        ArrayDeque<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word str = q.poll();
            if(target.equals(str.getStr())) {
                answer = str.getStep();
                break;
            }
            
            for(int i = 0; i < words.length; i++) {
                int cnt = 0;
                for(int j = 0; j < words[i].length(); j++) {
                    if(str.getStr().charAt(j) != words[i].charAt(j)) cnt++;
                }
                
                if(cnt == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new Word(words[i], str.getStep() + 1));
                }
            }
        }
        
        return answer;
    }
}

class Word {
    String str;
    int step;
    Word(String str, int step) {
        this.str = str;
        this.step = step;
    }
    public String getStr() {
        return this.str;
    }
    public int getStep() {
        return this.step;
    }
}
