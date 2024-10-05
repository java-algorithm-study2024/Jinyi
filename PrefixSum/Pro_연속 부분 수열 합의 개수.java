import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] ps = new int[elements.length + elements.length - 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        // 누적합 구하기
        for(int i = 1; i < ps.length; i++) {
            ps[i] = ps[i - 1] + elements[(i-1) % elements.length];
        }
        for(int i = 0; i < ps.length; i++) {
            System.out.print(ps[i] + " ");
        }
        
        // i : 1 2 3 4
        for(int i = 1; i < elements.length; i++) {
            // 5번 반복
            for(int j = i; j < i + elements.length; j++) {
                int sum = ps[j] - ps[j - i];
                if(map.containsKey(sum)) continue;
                map.put(sum, 1);
            }
        }
        
        // 길이 = 5
        map.put(ps[elements.length] - ps[0], 1);
        return map.size();
    }
}

/*
    이미 존재하는 합이 있는지 확인
    합을 다 구해야 하는데..
    누적합을 사용할 수 있는가..
    
      7 9  1  1   4  7  9  1 
    0 7 16 17 18  22 29 38 39
    
*/
