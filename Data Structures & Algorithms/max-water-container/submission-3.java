class Solution {
    public int maxArea(int[] heights) {
        // 3,4,5,1,9,6,1,0
        //tallestNumber , currN , currMaxWater at thisPoint, maxWater
        int l=0, r=heights.length-1;
        int result=0, area=0;

        while(l < r){

        if(heights[l]==0){ ++l; continue;}
        else if (heights[r]==0) { --r; continue; }

        area = (r-l) * Math.min(heights[l],heights[r]);
        result = Math.max(result, area);

        if(heights[l] < heights[r]) l++;
        else if(heights[l] >= heights[r]) r--;
        
        }

        return result;
        
    }
}
