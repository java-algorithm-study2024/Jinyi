class Solution {
    public int[] solution(String s) {
        int cnt_repeat = 0;
        int cnt_0 = 0;
        while(!"1".equals(s)) {
            int decimal = count_1(s);
            cnt_repeat++;
            cnt_0 += (s.length() - decimal);
            
            s = Integer.toBinaryString(decimal);
        }
        //System.out.println(count_1(s));
        return new int[] {cnt_repeat, cnt_0};
    }
    
    public static int count_1(String s) {
        return s.length() - s.replace("1", "").length();
    }
}

/*
    문제 조건
    1. 1 <= s <= 150,000
    2. s에는 '1'이 최소 하나 이상 포함
    3. 출력 : 반복 횟수 , 제거한 0의 개수
*/
