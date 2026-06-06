class Solution {
    public int removeDuplicates(int[] nums) {
      int left=0; //marker which is next position for change

      for (int i=1; i < nums.length; i++){
         if(nums[i]==nums[i-1]){
           continue;
         }

         if(nums[i]!=nums[i-1]){
            //swap with marked duplicate value position marked by left pointer
               // int temp = nums[left];
    
                nums[++left]=nums[i];
         }
       }
       return left+1;
    }

    //2,10,10,10,30,30,40 left=0,i=1 | left=1,i=1
// 2,10,10 left=1, i=2 | left=2,i=2
// left=2,i=3 | left=2,i=3
// left=2,i=4 | left=3,i=4  // 2,10,30,10,30,30,40
// left=3,i=5 | left=3 i=5
//left=3,i=6 | left=4,i=6 //2,10,30,40,30,40

}