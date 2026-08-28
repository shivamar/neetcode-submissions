class Solution {
    public int rob(int[] nums) {
      if(nums.length==1) return nums[0];
      if(nums.length==2) return Math.max(nums[0],nums[1]);
      
        int[][]dp = new int[nums.length][nums.length];

        dp[0][0]=0;
        dp[0][1]=nums[1];

        dp[1][nums.length-1]=0;
        dp[1][0]=nums[0];
        dp[1][1]=Math.max(nums[0],nums[1]);

        for(int i=2;i < nums.length;i++)
        {
          dp[0][i] = Math.max(dp[0][i-1],nums[i]+dp[0][i-2]);
        }

        for(int i=2;i < nums.length-1;i++)
        {
          dp[1][i] = Math.max(dp[1][i-1],nums[i]+dp[1][i-2]);
        }

        return Math.max(dp[0][nums.length-1],dp[1][nums.length-2]);

    }
}
