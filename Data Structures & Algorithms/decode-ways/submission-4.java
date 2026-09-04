class Solution {

    public int numDecodings(String s) {
        int[]dp = new int[s.length()+1];
        char[] charArr = s.toCharArray();

        dp[0] = 1;
        dp[1] = validSingle(charArr[0]) ? 1 : 0;
        if(s.length() < 2) return dp[1];
        dp[2] += validDouble(""+charArr[0]+charArr[1]) ? dp[0] : 0;
        dp[2] += validSingle(charArr[1]) ? dp[1] : 0;

        for(int i=2; i < s.length(); i++){
            // System.out.println(dp[i]+" "+dp[i-1]);
            dp[i+1] += validSingle(charArr[i]) ? dp[i] : 0;
             // System.out.println(dp[i+1]);
            dp[i+1] += validDouble(""+charArr[i-1]+charArr[i]) ? dp[i-1] : 0; 
                 // System.out.println(dp[i+1]);
        }

        return dp[s.length()];
    }

    private boolean validSingle(char c){

        if(c == '0') {
            return false;
        } 
        return true;
    }

    private boolean validDouble(String str){

       int val = Integer.valueOf(str);
       if(val > 9 && val < 27) return true;
       else return false;
    }
}
