class KthLargest {
    PriorityQueue<Integer> pQ1_min = new PriorityQueue<>((a, b) -> a-b);
    PriorityQueue<Integer> pQ2_max = new PriorityQueue<>((a, b) -> b-a);

    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;

        for(int n : nums){

            pQ2_max.add(n);
        }
        
        for(int i=0;i<k;i++){

            if(pQ2_max.size() < 1) break;
            pQ1_min.add(pQ2_max.poll());
        }
    }
    
    public int add(int val) {

        System.out.println(pQ1_min.size() + " "+ pQ1_min.peek()+" "+k);

        if(pQ1_min.size() < k){

            pQ1_min.add(val);
        }
        else if(pQ1_min.peek() >= val){

            pQ2_max.add(val);
        } else {

            pQ2_max.add(pQ1_min.poll());
            pQ1_min.add(val);
        }   

        System.out.println(pQ1_min.size() + " "+ pQ1_min.peek());
        return pQ1_min.peek();
    }
}
