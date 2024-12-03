import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int s = 0, e = people.length - 1;
        while(s <= e) {
            // 무게 초과 X = 2명이 같이 탐.
            if(people[s] + people[e] <= limit) {
                s++;
                e--;
            } else {    // 무게 초과 = 혼자 타야 함.
                e--;
            }
            
            answer++;
        }
        
        return answer;
    }
}

/*
    0   1   2   3   4   5   6   7   8
    10, 20, 20, 30, 50, 50, 50, 70, 80 -> 5개
    
    0   1   2   3   4 
    50, 50, 60, 70, 80 -> 
    
    0   1   2   3   4 
    10, 10, 10, 70, 80 -> 
    
    
    0   1   2   3   4   5
    10, 20, 50, 50, 70, 80 -> 3개
    
*/
