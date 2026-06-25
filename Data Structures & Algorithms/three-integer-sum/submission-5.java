class Solution {

    //-1 -1 0 0 1 1 2 3
   //[-1, -1,2], [-1, 0,1] [0,-> quit]

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int first=0, tempSum;

        List<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            first=nums[i];

            if(i > 0 && first == nums[i-1]) continue;
            tempSum=0-first;
            if(first > 0) break;

            for(int j=i+1,  k=nums.length-1; j < k;){
                if(nums[j] + nums[k] == tempSum){
                   List<Integer> list = new ArrayList<>();
                   list.add(Integer.valueOf(first));
                   list.add(Integer.valueOf(nums[j]));
                   list.add(Integer.valueOf(nums[k]));

                    result.add(list); 

                    // you can move 1 ptr down or another up, 
                    //if they are duplicates move along until next unique value

                        while(k > j && nums[k]==nums[k-1]){
                            k--;
                        }
                        while(k > j && nums[j]==nums[j+1]){
                            j++;
                        }

                     k--;
                     j++;
                }
                else if(nums[j] + nums[k] > tempSum){
                    k--;
                }
                else if(nums[j] + nums[k] < tempSum){
                    j++;
                }
            } 
        }

        return result;
    }
}
