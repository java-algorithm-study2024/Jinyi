// 풀이 1
import java.util.*;

class Solution {
    public int solution(String s) {
        String num_str = "";
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(0 <= ch - '0' && ch - '0' <= 9) answer += ch;
            else {
                num_str += ch;
                if(map.containsKey(num_str)) {
                    answer += map.get(num_str);
                    num_str = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }
}

// 풀이 2
class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < nums.length; i++) {
            // i+"" 대신 Integer.toString(i) 가능
            s = s.replaceAll(nums[i], i + "");
        }
        //System.out.println(s);
        return Integer.parseInt(s);
    }
}
