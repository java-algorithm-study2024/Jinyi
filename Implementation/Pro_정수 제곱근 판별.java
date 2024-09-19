class Solution {
    public long solution(long n) {
        long answer = (long)Math.sqrt(n);
        if(answer * answer != n) return -1;
        return (answer+1) * (answer+1);
    }
}
