class Solution {
    public int longestOnes(int[] nums, int k) {
       int result=0;
       for(int i = 0; i < nums.length; i++)
       {
          int tracker=0, countLongest=0,b=i;
          for(b=i;b < nums.length;b++){
            
            if(nums[b] == 0)
              tracker++;
            
            if(tracker > k) break;  
                       
            countLongest++;
          }

          result = Math.max(result,countLongest);
       }   

       return result;
            
    }
}