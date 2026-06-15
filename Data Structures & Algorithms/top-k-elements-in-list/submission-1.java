class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }

//min queue
        PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);

        for (Map.Entry<Integer,Integer> set : map.entrySet())
        {
            pQ.add(new int[]{set.getValue(), set.getKey()});

            if(pQ.size()>k) pQ.remove();
        }

        int[] result = new int[k];
        for(int i=0; i < k ; i++)
        {
            result[i] = pQ.remove()[1];
        }
        
        return result;
    }
}