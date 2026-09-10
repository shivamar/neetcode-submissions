class Solution {

        public int missingNumber(int[] nums) {
        int max = nums.length;
        long sumOfRange = ((long)max * (max+1)) / 2;    //This is a genuinely common Java trap and worth locking: the type of an expression is decided by its operands, not by what you assign it to. Same reason int a = 1, b = 2; double d = a / b; gives you 0.0, not 0.5.

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
