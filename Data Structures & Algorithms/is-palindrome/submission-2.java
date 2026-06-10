class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] charArr = s.toCharArray();
        int L=0, R=charArr.length-1;
        while(L < R){
            if(!Character.isLetterOrDigit(charArr[R])) {
                R--;
                continue;
            }

            if(!Character.isLetterOrDigit(charArr[L])) {
                L++;
                continue;
            }

            if(charArr[L] == charArr[R]){
                L++;
                R--;
            } else {
                return false;
               // break;
            }
        }

        if(L==R || L==R-1 || L==R+1) return true;
        else return false;
        
    }
}
