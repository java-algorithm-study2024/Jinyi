import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]) + 1);
                continue;
            }
            map.put(nums[i], 1);
        }
        
        //System.out.println(map);
        
        if(map.size() >= nums.length/2) return nums.length/2;
        return map.size();
    }
}

/*
    1, 2, 3 => 2
    2, 3, 4 => 3
    2, 3 => 2
*/
