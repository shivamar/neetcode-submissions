class Solution {
    public int trap(int[] height) {
        int start=0, end=height.length-1, rightMax=-1, leftMax=-1, area=0;
//iterate with 2 pointers, Area at i spot = i - min(maxRight,maxRight)
        while(start < end ){
            
            leftMax = Math.max(height[start],leftMax);
            rightMax = Math.max(height[end],rightMax);

            area += Math.min(leftMax,rightMax) - height[start] > 0 ? Math.min(leftMax,rightMax) - height[start] : 0;
            area += Math.min(leftMax,rightMax) - height[end] > 0 ? Math.min(leftMax,rightMax) - height[end] : 0;

            if(height[start] > height[end]) end--;
            else start++;
        }

        return area;   
    }
}
