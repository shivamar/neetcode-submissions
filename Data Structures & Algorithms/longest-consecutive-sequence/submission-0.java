class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for(int n : nums){
            set.add(n);
        }

        int longestSeqLen=0, currSeqLen=0;

        for(int i=0; i < nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int startOfSeq = nums[i];
                currSeqLen=1;

                while(set.contains(++startOfSeq)) currSeqLen++; 
                longestSeqLen = Math.max(longestSeqLen, currSeqLen);
            }
        }

        return longestSeqLen;
    }
}
