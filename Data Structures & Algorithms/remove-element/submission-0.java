class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] == val) {
                // Found element to remove, swap with right element
                nums[left] = nums[right];
                right--;  // Shrink the valid range
            } else {
                // Current element is good, move to next
                left++;
            }
        }
        
        return left;  // left now points to the count of valid elements
    }
}