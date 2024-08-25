// 런타임에러가 나는 이유는 시간 초과 뿐 아니라 자료형 크기 초과 등이 원인일 수도 있다.
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i < t.length() - p.length() + 1; i++) {
            long sub = Long.parseLong(t.substring(i, i+p.length()));
            long p_num = Long.parseLong(p);
            if(p_num >= sub) answer++;
        }
        return answer;
    }
}
