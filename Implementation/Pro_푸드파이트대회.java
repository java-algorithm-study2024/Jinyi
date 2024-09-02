import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++) {
            if(food[i] < 2) continue;
            String str = (i + "").repeat(food[i]/2);
            answer += str;
        }
        StringBuilder sb = new StringBuilder(answer);
        String rev = sb.reverse().toString();
        answer += "0";
        answer += rev;
        return answer;
    }
}
