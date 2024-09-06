class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month = new int[13];
        for(int i = 1; i <= 12; i++) {
            if(i < 8) {
                if(i%2 == 1) month[i] = 31 + month[i-1];
                else if(i == 2) month[i] = 29 + month[i-1];
                else month[i] = 30 + month[i-1];
            } else {
                if(i%2 == 0) month[i] = 31 + month[i-1];
                else month[i] = 30 + month[i-1];
            }
        }
        // for(int i = 0; i <= 12; i++) {
        //     System.out.print(month[i] + " ");
        // }
        
        int term = month[a - 1] + b - 1;
        term %= 7;
        return day[term];
    }
}
