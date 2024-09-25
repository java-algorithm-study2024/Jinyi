import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
           public int compare(String s1, String s2) {
               if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
               return s1.charAt(n) - s2.charAt(n);
           }
        });
        return strings;
    }
}

/*
    각 문자열의 index n 을 기준으로 정렬
    
*/
