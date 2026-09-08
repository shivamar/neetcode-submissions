class Solution {
    HashMap<Integer,Integer> rank;
    public int[] findRedundantConnection(int[][] edges){
    HashMap<Integer,Integer> parent = new HashMap<Integer,Integer>();
    rank = new HashMap<Integer,Integer>();
    //reverse(edges);
    int n = edges.length;

    for(int i=1; i< n+1; i++)
    {
        parent.put(i,i);
        rank.put(i,1);
    }

    for(int[] edge : edges)
    {
        if(!union(edge[0],edge[1], parent))
           return edge;
    }

    return null;

    }

    public int findRoot(int val, HashMap<Integer,Integer> parent)
    {
        int x=val;
        while(parent.get(x)!=x) 
            x=parent.get(x);

        int root=x;
        x=val;

        while(parent.get(x)!=x) {
             int temp = parent.get(x);
             parent.put(x,root);
             x=temp;
        }

        return root;
            
    }

    public boolean union (int a, int b, HashMap<Integer,Integer> parent)
    {   
        //System.out.println(" "+a+" "+b);
        int rootA=findRoot(a, parent);
        int rootB=findRoot(b, parent);
       // System.out.println(" "+rootA+" "+rootB);

        if(rootA==rootB) return false;

        if(rank.get(rootA) > rank.get(rootB)){
                parent.put(rootB,rootA);
        } else if(rank.get(rootB) > rank.get(rootA)){
                parent.put(rootA,rootB);
        } else { // equal so rootA grows
                parent.put(rootB,rootA);
                rank.put(rootA,rank.get(rootA)+1);
        }
        
        return true;
    }


//     public  void reverse(int[][] array) {
//     int start = 0;
//     int end = array.length - 1;
    
//     while (start < end) {
//         // Swap elements
//         int[] temp = array[start];
//         array[start] = array[end];
//         array[end] = temp;
        
//         // Move pointers toward the center
//         start++;
//         end--;
//     }
// }
}
