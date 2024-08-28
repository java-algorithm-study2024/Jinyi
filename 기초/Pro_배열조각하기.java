import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int s = 0, e = arr.length - 1;
        for(int i = 0; i < query.length; i++) {
            if(i % 2 == 0) e = s + query[i];
            else s += query[i];
        }
        //System.out.println(s + " " + e);
        int[] answer = Arrays.copyOfRange(arr, s, e+1);
        return answer;
    }
}
/*
          0  1  2  3  4  5  6
    arr = 0, 1, 2, 3, 4, 5, 6
    query = 4, 1, 2, 2
    e : 6 -> 4 -> 3 : s + query[]
    s : 0 -> 1 -> 3 : s + query[]
    0, 1, 2, 3, 4
    1, 2, 3, 4
    1, 2, 3
    3
*/
