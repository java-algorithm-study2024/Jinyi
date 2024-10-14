import java.util.*;
class Solution
{
    public long solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length - 1;
        long answer = 0;
        for(int i = 0; i < A.length; i++) {
            answer += (long)A[i] * B[len - i];
        }
        return answer;
    }
}

/*
    1 4 2
    5 4 4
    => 1, 5 / 4, 4 / 4, 2 = 5 + 16 + 8 
    => 1, 4 / 4, 5 / 2, 4 = 4 + 20 + 8
    => 1, 4 / 4, 4 / 2, 5 = 4 + 16 + 10
*/
