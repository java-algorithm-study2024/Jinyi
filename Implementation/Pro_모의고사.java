import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = answers.length;
        int cnt2 = answers.length;
        int cnt3 = answers.length;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] != p1[i % p1.length]) cnt1--;
            if(answers[i] != p2[i % p2.length]) cnt2--;
            if(answers[i] != p3[i % p3.length]) cnt3--;
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        int[] cnts = {cnt1, cnt2, cnt3};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(cnts[i] == max) list.add(i+1);
        }
        return list;
    }
}
