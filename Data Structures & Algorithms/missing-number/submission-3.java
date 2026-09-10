class Solution {
    public int missingNumber(int[] nums) {
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
}
