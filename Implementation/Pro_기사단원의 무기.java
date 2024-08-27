class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int cnt = count_divisor(i);
            if(cnt > limit) answer += power;
            else answer += cnt;
        }
        
        return answer;
    }
    
    // 약수 개수 구하는 메서드
    public static int count_divisor(int num) {
        /*
            9 : 1, 3, 9
            12 : 1, 2, 3, 4, 6, 12
        */
        int cnt = 0;
        for(int i = 1; i*i <= num; i++) {
            if(i * i == num) cnt++;
            else if(num % i == 0) cnt += 2;
        }
        return cnt;
    }
}
