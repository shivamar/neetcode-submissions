class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> resList = new ArrayList<int[]>();

    resList.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] lastResArray = resList.get(resList.size() - 1);

      if (lastResArray[1] >= intervals[i][0]) {
        lastResArray[1] = Math.max(lastResArray[1], intervals[i][1]);
      } else {
        resList.add(intervals[i]);
      }
    }

    return resList.stream().toArray(int[][] ::new);

    //  return resList.toArray(new int[0][]);
  }
}
