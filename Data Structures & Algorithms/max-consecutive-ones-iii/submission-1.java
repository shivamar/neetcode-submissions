class Solution {
    public int longestOnes(int[] nums, int k) {
       int result=0;
       for(int i = 0; i < nums.length; i++)
       {
          int tracker=0, countLongest=0,b=i;
          while(b < nums.length && tracker <= k ){
            
            if(nums[b] == 0){
              if(k==tracker) break;
              tracker++;
            } 
              
              countLongest++;
              b++; 
          }


          result = Math.max(result,countLongest);
       }   

       return result;
            
    }
}