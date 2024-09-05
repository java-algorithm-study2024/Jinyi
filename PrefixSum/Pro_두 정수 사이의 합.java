class Solution {
    public long solution(int a, int b) {
        //return sum1(a, b);
        return sum2(a, b);
    }
    
    // 풀이 1 : 합의 공식 이용
    public static long sum1(int a, int b) {
        if(a > b) return (((long)a * (a + 1)) - ((long)b * (b - 1))) / 2l;
        else return (((long)b * (b + 1)) - ((long)a * (a - 1))) / 2l;
    }
    
    // 풀이 2 : 누적합 이용
    // 근디 누적합이 의미가 있는 문제인지 모르겠넹..
    public static long sum2(int a, int b) {
        // 항상 b가 더 크게
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // 누적합 완성
        int size = b - a + 2;
        long[] ps = new long[size];
        for(int i = 1; i < size; i++) {
            ps[i] = (long)a + ps[i-1];
            a++;
        }

        return ps[size-1];
    }
}
/*
    문제 조건
    1. a, b는 누가 더 큰지 모름
    2. a, b는 음수가 될 수 있다. -> index로 사용시 주의
    
    a = -5, b = 3 일 때, size = 10
         -5, -4, -3, -2, -1, 0, 1, 2, 3
    ps 0  1  2  3   4    5   6   7   8   9
       0 -5 -9 -12  -14 -15 -15 -14 -12 -9
*/
