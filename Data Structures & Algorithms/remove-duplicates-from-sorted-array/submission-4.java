class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> ansSet = new TreeSet<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(!ansSet.contains(nums[i])){
                ansSet.add(nums[i]);
            }
        }

int io = 0;
for(int indiv : ansSet) nums[io++]=indiv;
        
        return ansSet.size();
    }
}