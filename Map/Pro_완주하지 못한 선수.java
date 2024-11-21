import java.util.*;

class Solution {
    /* 1. 정렬 풀이
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }
    */
    // 2. 해시 풀이
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String parti : participant) map.put(parti, map.getOrDefault(parti, 0) + 1);
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                if(map.get(participant[i]) > 1) map.replace(participant[i], map.get(participant[i]) - 1);
                else map.remove(participant[i]);
            } else {
                answer = participant[i];
            }
        }
        
        return answer;
    }
}
