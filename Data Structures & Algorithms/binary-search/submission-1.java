class Solution {

// 1 2 3 4 5 6
// 1 2 3 4 5

    public int search(int[] nums, int target) {
        int lo=0, hi=nums.length-1, mid=0;

        while(lo<=hi)
        {
            mid=lo + (hi-lo)/2;
            if(target==nums[mid]) return mid;
            else if(target > nums[mid]) lo=mid+1;
            else hi = mid-1;
        }

        return -1;
    }
}