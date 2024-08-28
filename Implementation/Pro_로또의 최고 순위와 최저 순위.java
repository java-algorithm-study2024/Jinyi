import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
		// 일치
		int good = 0;
		// 불일치 개수
		int zero = 0;
		for(int num : lottos) {
			if(num == 0) {
				zero++;
			}
			if(list.contains(num)) {
				good++;
			}
		}
		
		// 최소
		int max = 6;
		int min = 6;
		// 1 0
		if(good + zero > 1) {
			max = 7 - (good + zero);
		}
		if(good > 1) {
			min = 7 - good;
		}
        int[] answer = {max, min};
        return answer;
    }
}
