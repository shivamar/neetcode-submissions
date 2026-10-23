class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int index = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();

        genSubsets(nums, 0, currentList, result);
        return result;

    }

    private void genSubsets(int[] nums, int index, 
    List<Integer>  currentList, List<List<Integer>> result) {
        //end condtn
        if(index == nums.length){

            result.add(new ArrayList<Integer>(currentList));
            return;
        }

        currentList.add(nums[index]);
        genSubsets(nums, index+1,currentList, result);     
        currentList.remove(currentList.size()-1);
        genSubsets(nums, index+1,currentList, result);

    }
}
