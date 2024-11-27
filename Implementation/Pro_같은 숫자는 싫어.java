import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            if(prev == arr[i]) continue;
            answer.add(arr[i]);
        }

        return answer;
    }
}
