class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> resList = new ArrayList<int[]>();
        int maxCurr=0;

        for(int i=0; i < intervals.length; i++){
           if(i==0) {
            resList.add(intervals[i]);
            continue;
           }
           
          int[] lastResArray = resList.get(resList.size()-1);
          maxCurr = lastResArray[1];

          if(maxCurr >= intervals[i][0]){
            lastResArray[1] = Math.max(maxCurr, intervals[i][1]);
          } else {
            resList.add(intervals[i]);
          }      

        }

        return resList.stream().toArray(int[][]::new);

      //  return resList.toArray(new int[0][]);
    }
}
