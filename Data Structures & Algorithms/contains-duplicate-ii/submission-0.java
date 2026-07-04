class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0,r=k-1;
        Set<Integer> set = new HashSet<Integer>();

// add k elements to set
        for(int i=0;i < k;i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }

        r++;
        while(r < nums.length){
            if(set.contains(nums[r])) return true;

            set.remove(nums[r-k]);
            set.add(nums[r]);
            r++;
        }

        return false;
    }
}