// 시간복잡도 ok인데 런타임에러 뜨면 -> long 값 고려
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            String bi1 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i]))).toString();
            String bi2 = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr2[i]))).toString();
            
            String str = "";
            for(int j = 0; j < n; j++) {
                if(bi1.charAt(j) == '0' && bi2.charAt(j) == '0') str += " ";
                else str += "#";
            }
            
            answer[i] = str;
        }
        
        return answer;
    } 
}

/*
    # = 벽 = 1 / 공백 = 0
    
    1)
    9 = 01001 이진수 변환 => 1인 idx = 1, 4
    30 = 11110 => idx = 0, 1, 2, 3
    2) set 에 넣어서 n - set의 size
    
    
    20 = 10100 => 1인 idx = 0, 2
    28 = 11100 => 1인 idx = 0, 1, 2
    
*/
