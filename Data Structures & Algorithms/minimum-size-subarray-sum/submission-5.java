class Solution {
    public int minSubArrayLen(int target, int[] nums) {

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
}