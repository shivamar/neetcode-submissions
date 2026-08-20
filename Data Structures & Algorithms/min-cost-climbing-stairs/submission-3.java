class Solution {
    // public int minCostClimbingStairs(int[] cost) {

    //     for(int i=cost.length-3;i>=0;i--)
    //     {
    //         cost[i] += Math.min(cost[i+1],cost[i+2]);
    //     }

    //     return Math.min(cost[0],cost[1]);
        
    // }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int [cost.length];
        Arrays.fill(dp,-1);
        return Math.min(dfs(cost,dp, 0), dfs(cost,dp, 1));
        
    }

    public int dfs(int[] cost, int[] dp, int index){
        if(index > cost.length-1){
            return 0;
        }

        if(dp[index]!=-1) return dp[index];

        dp[index] = cost[index] + Math.min(dfs(cost, dp, index+1), dfs(cost,dp, index+2));

        
        return cost[index] + Math.min(dfs(cost, dp, index+1), dfs(cost,dp, index+2));

    }

    // public int dfs(int[] cost, int index){
    //     if(index > cost.length-1){
    //         return 0;
    //     }

    //     return cost[index] + Math.min(dfs(cost, index+1), dfs(cost, index+2));

    // }
}
