class Solution {
    int dp[];
    public int rob2(int[] nums) {

       int[] dp = new int[nums.length];
       if(nums.length==1) return nums[0];
       if(nums.length==2) return Math.max(nums[0],nums[1]);

       dp[0]=nums[0];
       dp[1]=Math.max(nums[0],nums[1]);

       for(int i=2;i < nums.length;i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
       }

       return dp[nums.length-1];
    }

    // public int rob(int[] nums) {
    //     dp = new int[nums.length];

    //   return dfs(nums,0);
    // }

    // public int dfs(int[] nums, int index){

    //     if(index > nums.length-1) return 0;

    //     return Math.max(dfs(nums,index+1), nums[index] + dfs(nums,index+2));

    // }

    public int rob(int[] nums) {
      dp = new int[nums.length];
      Arrays.fill(dp, -1);
         
      return dfs(nums,0);
    }

    public int dfs(int[] nums, int index){
        if(index > nums.length-1) return 0;
        if(dp[index] != -1) return dp[index];
        dp[index] = Math.max(dfs(nums,index+1), nums[index] + dfs(nums,index+2));
        return dp[index];
        
    }


}
