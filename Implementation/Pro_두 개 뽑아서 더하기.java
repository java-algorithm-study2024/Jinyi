import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(result.contains(sum)) continue;
                result.add(sum);
            }
        }
        Collections.sort(result);
        //System.out.println(result);
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}

/*
    문제 조건
    1. 서로 다른 n개 중에 2개 조합으로 뽑음
    2. result 에 중복은 없게
    3. result 정렬 후 리턴
    
    경우의 수, 조합
    - 재귀 or 이중 for 문으로 구현 가능
*/
