class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int get = 0;
        while(n >= a) {
            get = (n / a) * b;
            answer += get;
            n = (n % a) + get;
        }
        return answer;
    }
}
