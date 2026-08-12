class Solution {
    public int[] topKFrequent(int[] nums, int k) {
   // ArrayList<Integer>[] freqArr =  new ArrayList<Integer>[nums.length];
    ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];


    HashMap<Integer, Integer> map = new HashMap<>();

    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> eSet : map.entrySet()) {
        int num = eSet.getKey();
        int freq = eSet.getValue();

        if(freqArr[freq] == null) {
            freqArr[freq] = new ArrayList<Integer>();
        }     
        freqArr[freq].add(num);
    }

    int[] result = new int[k];
    int counter=0;

    for(int i = nums.length ; i > -1; i--)
    {
        if(freqArr[i]==null) continue;

        for(int val : freqArr[i]){
            result[counter]=val;
            counter++;
            if(counter==k){
                return result;
            }
        }
        
    }

return result;

    }
}
