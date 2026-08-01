class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] charArr = s.toCharArray();
        int start=0, end=s.length()-1;

        while(end > start){
          
          while(end > start && !Character.isDigit(charArr[start]) && !Character.isLetter(charArr[start])){

            start++;
          }

        //   while(end > start && !Character.isLetterOrDigit(charArr[end])){
        //     end--;
        //   }

          while(end > start && 
          !(charArr[end] >= 'a' && charArr[end] <= 'z') &&  
          !(charArr[end] >= '0' && charArr[end] <= '9')) {

            end--;
          }

          if(!(end > start)) break;

          if(charArr[start] != charArr[end]){
            return false;
          }
          start++;
          end--;
        }

        return true;

    }
}
