class Solution {
    public int minSubArrayLen_Brute(int target, int[] nums) {

        //Arrays.sort(nums);

        int currSum=0, resultArrSize= Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
          currSum=nums[i];
          if(currSum >= target){
              resultArrSize = Math.min(resultArrSize, 1);
              break;
          }
          
          for(int j=i+1; j < nums.length; j++){
            if(i==j) continue;
            currSum+=nums[j];

            if(currSum >= target){
              resultArrSize = Math.min(resultArrSize, j-i+1);
              break;
            }
          }
        }

        return resultArrSize == Integer.MAX_VALUE ? 0 : resultArrSize;
    }

    public int minSubArrayLen(int target, int[] nums) {

      int currSum=0, r=0,l=0, minSubArrayLen=Integer.MAX_VALUE;

      for(r=0; r < nums.length; r++){
        currSum += nums[r];
        
        if(currSum >= target)
           minSubArrayLen = Math.min(minSubArrayLen,r-l+1);
        while(currSum >= target){
          currSum -= nums[l];
          l++;                  
          if(currSum >= target)
           minSubArrayLen = Math.min(minSubArrayLen,r-l+1);
        }
        
        // if(currSum >= target)
        //    minSubArrayLen = Math.min(minSubArrayLen,r-l+1);

      }

      return minSubArrayLen == Integer.MAX_VALUE ? 0 : minSubArrayLen;

    }
}