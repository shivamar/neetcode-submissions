class Solution {
    public int maxProfit(int[] prices) {
        //...
        int maxProfit=0,maxSellP=0;
        int l=0; // assume l is buy proce and r is sell price ; we keep changing the buy Price if we see a smaller l and compare it with all sell prices in the window and memoize the maxProfit as  r-l;
        for(int r=0; r < prices.length; r++)
        {
            
            if(prices[r] < prices[l]){
                l=r;
            }

            maxProfit = Math.max(prices[r]-prices[l], maxProfit);
        }

        return maxProfit;
    }
}
