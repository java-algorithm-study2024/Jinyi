class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer;
        if(arr.length % 2 == 1) answer = odd(arr, n);
        else answer = even(arr, n);
        return answer;
    }
    
    public static int[] odd(int[] arr, int n) {
        for(int i = 0; i < arr.length; i+=2) {
               arr[i] += n;
        }
        return arr;
    }
    
    public static int[] even(int[] arr, int n) {
        for(int i = 1; i < arr.length; i+=2) {
               arr[i] += n;
        }
        return arr;
    }
}
