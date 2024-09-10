import java.util.*;
class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        String answer = Arrays.stream(arr).min().getAsInt() + " " + Arrays.stream(arr).max().getAsInt();
        return answer;
    }
}
