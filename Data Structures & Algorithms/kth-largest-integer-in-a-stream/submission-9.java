class KthLargest {
    PriorityQueue<Integer> pQ1_min = new PriorityQueue<>((a, b) -> a-b);
    //PriorityQueue<Integer> pQ2_max = new PriorityQueue<>((a, b) -> b-a);

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

      //  System.out.println(pQ1_min.size() + " "+ pQ1_min.peek()+" "+k);

        // if(pQ1_min.size() < k){

        //     pQ1_min.add(val);
        // }
        // else if(pQ1_min.peek() >= val){

        //     pQ2_max.add(val);
        // } else {

        //     pQ2_max.add(pQ1_min.poll());
        //     pQ1_min.add(val);
        // }   

       // System.out.println(pQ1_min.size() + " "+ pQ1_min.peek());

        pQ1_min.add(val);
        if(pQ1_min.size() > k) pQ1_min.poll();
        return pQ1_min.peek();
    }
}
