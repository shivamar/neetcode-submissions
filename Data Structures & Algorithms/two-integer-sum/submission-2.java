class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for(int num : nums){

            if(!map.containsKey(target-num)){
                map.putIfAbsent(num,index);
                index++;
            }
            else {
                if(num != target-num){
                      return new int[] {map.get(target-num), index};
                    // map.put(num, index);         
                    // int val1 = map.get(num);
                    // int val2 = map.get(target-num);
                    // return new int[] {Math.min(val1,val2), Math.max(val1,val2)};
                } else {
                    return new int[] {map.get(target-num), index};
                }
            }
        } 
        return new int[2];
    }
}
