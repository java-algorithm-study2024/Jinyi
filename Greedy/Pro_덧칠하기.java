class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cover = 0;
        for(int sec : section) {
            if(sec < cover) continue;
            cover = sec + m;
            answer++;
        }
        return answer;
    }
}
