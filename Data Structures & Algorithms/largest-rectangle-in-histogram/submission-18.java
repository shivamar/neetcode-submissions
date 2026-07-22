class Solution {
    public int largestRectangleArea(int[] heights) {
        
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        int n=heights.length,area=0,maxArea=0;

        for(int i=0;i <= n;i++)
        {
            //pop if currValue is smaller or when its past last element
            while(i==n || (!arrayDeque.isEmpty() && heights[i] < heights[arrayDeque.peek()])){

              if(!arrayDeque.isEmpty()){
                int currPointer = arrayDeque.pop();

                 
                if(!arrayDeque.isEmpty())area = heights[currPointer]  * (i - arrayDeque.peek()-1);
                else area = heights[currPointer] * (i);
              } 
               
               maxArea = Math.max(area, maxArea); 

               if(i==n && arrayDeque.isEmpty()) break;
            }
           
            if(i < n) arrayDeque.push(i);
        }

            return maxArea;
       
        }
}

        //[7,1,7,2,2,4]

        //  for(int i=0;i <= heights.length;i++){

        //     int h = (i == heights.length) ? 0 : heights[i];  

        //     while(!arrayDeque.isEmpty() && h < heights[arrayDeque.peek()] ){
        //         currIndexRightBoundary = i;
        //         int currValue = heights[arrayDeque.pop()];

        //         // while(!arrayDeque.isEmpty() && currValue ==  heights[arrayDeque.peek()])  
        //         //     arrayDeque.pop();
                
        //     int leftIndexBoundary = arrayDeque.isEmpty() ? 0 : arrayDeque.peek();
        //     int width = currIndexRightBoundary-leftIndexBoundary-1;
        //      width = width==0?  heights.length : width;
        //     maxArea = Math.max(maxArea, currValue * width);
            
        //     }
        //     arrayDeque.push(i);

    //    currIndexRightBoundary = heights.length-1;

    //     while(!arrayDeque.isEmpty()){
    //         int currIndex = arrayDeque.pop();
    //         int currValue = heights[currIndex];

    //         //  while(!arrayDeque.isEmpty() && currValue ==  heights[arrayDeque.peek()])  
    //         //         arrayDeque.pop();

    //         int leftIndexBoundary = arrayDeque.isEmpty() ? 0 : arrayDeque.peek();
    //         int width = currIndexRightBoundary-leftIndexBoundary;
      
    //         maxArea = Math.max(maxArea, currValue * width);
    //     }

    //     return maxArea;
    // }
//}
