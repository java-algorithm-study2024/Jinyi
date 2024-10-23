import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        
        int cam = routes[0][0];
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] <= cam && routes[i][1] >= cam) continue;
            else {
                answer++;
                cam = routes[i][0];
            }
        }
        return answer;
    }
}

/*
    1. 정렬
    2. (-20, -15) 저장 & answer++
    3. (-19, -17) 이 위의 범위에 겹친다? -> 저장되는 범위 교집합으로 줄임(-19, -17)
    4. (-16, 0) 이 위의 교집합 범위와 겹치는 지 확인
        -> 겹치면 3번과 동일한 과정 거치기
        -> 겹치지 않으면 2번 과정 거치기
    5. 반복
*/
