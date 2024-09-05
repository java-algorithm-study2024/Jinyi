class Solution {
    public long solution(int price, int money, int count) {
        // long 이나 float을 사용할 때는 L, f 를 붙여주는 습관을 들이자. or 형변환해주거나
        // 안 그러면 오버플로 난다.
        long answer = (long)price * (long)((count * (count+1)) / 2);
        System.out.println(answer);
        answer -= money;
        if(answer <= 0) return 0;
        else return answer;
    }
}
/*
    등비수열의 합
    3 + 6 + 9 + 12
    = 3 * (1 + 2 + 3 + 4) = 3 * (1 ~ 4 까지의 합)
    
    최악의 경우 비용이 78억 이상이라서 long 타입 필요
*/
