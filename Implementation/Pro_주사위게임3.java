import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c, d));
        Map<Integer, Integer> map = new HashMap<>();
        // map : key 값은 주사위 숫자 + value 값은 해당 숫자가 나온 횟수
        for(int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            if(map.containsKey(key)) {
                int value = map.get(key);
                map.replace(list.get(i), value+1);
            }
            else map.put(key, 1);
        }
        //System.out.println(map);
        
        int answer = 0;
        int key_num = map.keySet().size();
        //System.out.println(key_num);
        // 경우 1 : key 값 1개
        if(key_num == 1) {
            for(int key : map.keySet()) {
                answer = 1111* key;
            }
        } else if(key_num ==2) {        
            if(map.get(a) == 2) {       // 경우 2 : 키값 2개 & value 구성 3, 1
                int p = 0, q = 0;
                for(int key : map.keySet()) {
                    if(p == 0) p = key;
                    else q = key;
                }
                answer = (p + q) * Math.abs(p - q);
            } else {                    // 경우 3 : 키값 2개 & value 구성 2, 2
                int p = 0, q = 0;
                for(int key : map.keySet()) {
                    if(map.get(key) == 3) p = key;
                    else q = key;
                }
                answer = (10 * p + q) * (10 * p + q);
            }
        } else if(key_num == 3) {           // 경우 4 : 키값 3개
            int p = 0, q = 0, r = 0;
            for(int key : map.keySet()) {
                if(map.get(key) == 2) p = key;
                else if(q == 0) q = key;
                else r = key;
            }
            answer = q * r;
        } else {                            // 경우 5 : 키값 4개
            int min = 10;
            for(int key : map.keySet()) {
                if(key < min) min = key;
            }
            answer = min;
        }
        
        return answer;
    }
}

/*
    경우 1 : key 값 1개
    경우 2 : 키값 2개 & value 구성 3, 1
    경우 3 : 키값 2개 & value 구성 2, 2
    경우 4 : 키값 3개
    경우 5 : 키값 4개
*/
