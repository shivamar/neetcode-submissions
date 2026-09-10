class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        
        int k=0;

        for(int n : nums)
        {
            // int xor = k ^ n;
             int and = k & n;

           //  if(xor != 0 || and != k ) return k;

           if(and != n ) return k;

             k++;
        }

        return nums.length;

    }

       public int missingNumber_n(int[] nums) {
        int max = nums.length;
        int bitMask=0;

        for(int k=0; k <= max; k++)
            bitMask = bitMask ^ k;

        for(int n : nums)
             bitMask = bitMask ^ n;

        return bitMask;

    }
}
