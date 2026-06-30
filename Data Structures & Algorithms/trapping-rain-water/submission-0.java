class Solution {
    public int trap(int[] height) {
        //0,2,0,1,0,0,3,1,2,3,0,1,1,1
        //-,-,1,-,1,1,-,2,1,-,1,-,-,- = 7 | Area
        // 2,3,2,3,2,3,5
        //3,2,3,2,5

        int l=0,r=height.length-1, result=0,leftMax=0,rightMax=0;

        while(l < r )
        {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            
            if(leftMax < rightMax){
                l++;
                //int min = Math.min(leftMax, height[l]);
                if(leftMax > height[l]) result += leftMax-height[l];
            } else {
                r--;
                if(rightMax > height[r]) result += rightMax - height[r];
            }
        }

        return result;
    }
}
