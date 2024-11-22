import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        
        int min = arr2[0];
        int[] answer = new int[arr.length - 1];
        
        if(answer.length == 0) return new int[] {-1};
        int i = 0;
        for(int num : arr) {
            if(min == num) continue;
            answer[i] = num;
            i++;
        }

        return answer;
    }
}
