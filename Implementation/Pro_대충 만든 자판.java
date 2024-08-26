import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for(String str : keymap) {
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(map.containsKey(ch)) {
                    if(map.get(ch) > (i+1)) map.replace(ch, i+1);
                    continue;
                }
                map.put(ch, i+1);
            }
        }
        //System.out.println(map);
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                if(map.containsKey(ch)) sum += map.get(ch);
                else {
                    answer[i] = -1;
                    break;
                }
            }
            if(answer[i] != -1) answer[i] = sum;
        }
        return answer;
    }
}
