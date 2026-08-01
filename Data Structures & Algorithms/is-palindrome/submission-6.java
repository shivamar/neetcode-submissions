class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]","").toLowerCase();
        char[] charArr = s.toCharArray();
        int start=0, end=s.length()-1;

        while(end > start){
          
        //   while(end > start && !Character.isLetterOrDigit(charArr[start])){
        //     start++;
        //   }

        //   while(end > start && !Character.isLetterOrDigit(charArr[end])){
        //     end--;
        //   }

        //   if(!(end > start)) break;

          if(charArr[start] != charArr[end]){
            return false;
          }
          start++;
          end--;
        }

        return true;

    }
}
