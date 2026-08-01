class Solution {
  public int longestOnes(int[] nums, int k) {
    int l=0,result=0, tracker=0;

    for(int r=0; r < nums.length; r++)
    {
      if(nums[r]==0) tracker++;

      while(tracker > k){
          // drop the first 0 from window  and set incremented l and update tracker
          if(nums[l] == 0){
            tracker--;
            l++;
            break;
          }  
          l++;
      }
      result =Math.max(result, r-l+1);
    }

    return result;

  }

  public int longestOnes_brute(int[] nums, int k) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      int tracker = 0, countLongest = 0, b = i;
      for (b = i; b < nums.length; b++) {
        if (nums[b] == 0)
          tracker++;

        if (tracker > k)
          break;

        countLongest++;
      }

      result = Math.max(result, countLongest);
    }

    return result;
  }
}