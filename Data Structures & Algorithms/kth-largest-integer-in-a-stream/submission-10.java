class KthLargest {
    PriorityQueue<Integer> pQ1_min = new PriorityQueue<>((a, b) -> a-b);
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;

        for(int n : nums){
            pQ1_min.add(n);
        }
        
        for(int i=0;i<nums.length-k;i++){
            pQ1_min.poll();
        }
    }
    
    public int add(int val) {
        pQ1_min.add(val);
        if(pQ1_min.size() > k) pQ1_min.poll();
        return pQ1_min.peek();
    }
}
