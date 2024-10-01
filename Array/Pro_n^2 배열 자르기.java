class Solution {
    public int[] solution(int n, long left, long right) {
        long len = right - left + 1;
        int[] answer = new int[(int)len];
        
        for(int i = 0; i < answer.length; i++) {
            int row = (int)(left / n) + 1;
            int col = (int)(left % n) + 1;
            //System.out.println(row + " " + col);
            answer[i] = Math.max(row, col);
            left++;
        }
        return answer;
    }
}
