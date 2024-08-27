import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= answer) break;
            else answer--;
        }
        return answer;
    }
}
/*
    [1,10,11] return 2
    [10,11] return 2
    [0,0,0,0,0] return 0
    [0,1,3,5,6] return 3
*/





// 아래는 이분탐색으로 잘못 푼 풀이
// 문제 제대로 이해해야 하눈뎁..
/*
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int start = 0, end = citations.length - 1;
        int mid = 0;
        while(start < end) {
            if(start + 1 == end) {
                answer = citations[mid];
                break;
            }
            mid = (start + end)/2;
            
            if(citations.length - mid == citations[mid]) {
                answer = citations[mid];
                break;
            } else if(citations.length - mid < citations[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return answer;
    }
}
*/
/*
    정렬
    0  1  2  3  4  5  6   7   8
    0, 1, 3, 5, 6, 7, 10, 11, 12
*/
