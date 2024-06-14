class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        // 초기화
    		int[] stu = new int[n];
    		for(int i = 0; i < n; i++) {
    			stu[i] = 1; 
    		}
    		for(int i = 0; i < lost.length; i++) {
    			stu[lost[i]-1] -= 1; 
    		}
    		for(int i = 0; i < reserve.length; i++) {
    			stu[reserve[i]-1] += 1; 
    		}
    		// 그리디하게 확인
    		for(int i = 0; i < n; i++) {
    			if(stu[i] == 0) {
    				if(i > 0 && stu[i-1] == 2) {	// 앞쪽 확인
    					stu[i-1] -= 1;
    					stu[i] = 1;
    				} else if(i < n -1 && stu[i+1] == 2) {	// 뒤쪽 확인
    					stu[i+1] -= 1;
    					stu[i] = 1;
    				} else {
    					answer--;
    				}
    			}
    		}
        
        return answer;
    }
}
