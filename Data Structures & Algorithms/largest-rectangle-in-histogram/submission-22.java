class Solution {
    public int largestRectangleArea(int[] heights) {
        
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        int n=heights.length, area=0, maxArea=0;

        for(int i=0;i <= n;i++){
            //pop if currValue is smaller or when its past last element

            int h = (i==n)? 0 : heights[i] ; //sentinel 
            while(!arrayDeque.isEmpty() && h < heights[arrayDeque.peek()]){

                int currPointer = arrayDeque.pop();    
                if(!arrayDeque.isEmpty()) area = heights[currPointer]  * (i - arrayDeque.peek()-1);
                else area = heights[currPointer] * (i);
               
                maxArea = Math.max(area, maxArea);
            }
           
            if(i < n) arrayDeque.push(i);
        }

            return maxArea;  
    }
}

       