class Solution {
    public int[][] merge(int[][] intervals) {

      Arrays.sort(intervals, (s1,s2) -> Integer.compare(s1[0],s2[0]));
        
        //loop thru all intervals and 
        // if u find min of i interval < max of prev interval then merge the list n call min n max
        // go to the next interval

        //int[][] result = new int[intervals.length][intervals[0].length];
        List<int[]> resultList = new ArrayList<int[]>();
        int[] resArr = intervals[0];  
        resultList.add(resArr);

        int maxPrevInt = resArr[1], minCurrInt = resArr[0];

        for(int i=1; i < intervals.length; i++ ){
         resArr = resultList.get(resultList.size()-1);

          maxPrevInt = resArr[1];
          minCurrInt = intervals[i][0];

          if(minCurrInt <= maxPrevInt){
            // its a collision, 
            // remove the prevList from resultArr and merge with currArr n 
            // recreate the resultArr
            resArr[1] = Math.max(maxPrevInt, intervals[i][1]);  
          } else {            
            int[] newArr = new int[2];
            newArr[0] = intervals[i][0];
            newArr[1] = intervals[i][1];

            resultList.add(newArr);
          }
        }

        return resultList.toArray(new int[0][]);
    }
}
