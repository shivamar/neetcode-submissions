class Solution {
    public int missingNumber_nLogn(int[] nums) {
        Arrays.sort(nums);
        
        int k=0;

        for(int n : nums)
        {
             int xor = k ^ n;
             int and = k & n;

             if(xor != 0 || and != k ) return k;

             k++;
        }

        return nums.length;

    }

       public int missingNumber(int[] nums) {
        int max = nums.length;
        int bitMask=0;
        int k=0;

        while(k <= max)
        {
            bitMask = bitMask ^ k;
            k++;
        }
        
      

        for(int n : nums)
        {
             bitMask = bitMask ^ n;
        }

        return bitMask;

    }
}
