import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine) {
            if(map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Collections.reverseOrder());
        
        int i = 0;
        int sum = 0;
        int answer = 0;
        while(sum < k) {
            sum += values.get(i);
            i++;
            answer++;
        }
        
        return answer;
    }
}

/*
    1, 2, 2, 3, 3, 4, 5, 5
    Map = 1: 1, 2: 2, 3: 2, 4: 1, 5:2
    value 배열로 가져와서 정렬 = 2, 2, 2, 1, 1
    k = 6일 때, 앞에서부터 2 + 2 + 2 끝 => 총 3번 더함 return 3
    k = 5일 때, 앞에서부터 2 + 2 + 2 > 5 => 총 3번
*/
