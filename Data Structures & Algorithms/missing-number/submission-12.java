class Solution {

        public int missingNumber(int[] nums) {
        int max = nums.length;
        long sumOfRange = ((long)max * (max+1)) / 2;

        long sumActual=0;
        for(int n : nums)
        {
           sumActual+=n;
        }

        int ans =  (int)  (sumOfRange - sumActual);
        return ans;
    }

    public int missingNumber_nLogn1(int[] nums) {
        Arrays.sort(nums);
        int k=0;
        for(int n : nums)
        {
           int xor = k ^ n;
           if(xor != 0  ) return k;
           k++;
        }

        return nums.length;
    }

    public int missingNumber_nLogn2(int[] nums) {
    Arrays.sort(nums);
    int k=0;

    for(int n : nums)
    {
        int and = k & n;

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
