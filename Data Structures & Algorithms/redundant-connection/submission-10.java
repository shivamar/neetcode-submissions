class Solution {
    HashMap<Integer,Integer> rank;
    public int[] findRedundantConnection(int[][] edges){
    int[] parent = new int[edges.length+1];
    rank = new HashMap<Integer,Integer>();
    //reverse(edges);
    int n = edges.length;

    for(int i=1; i< n+1; i++)
    {
        parent[i]=i;
        rank.put(i,1);
    }

    for(int[] edge : edges)
    {
        if(!union(edge[0],edge[1], parent))
           return edge;
    }

    return null;

    }

    public int findRoot(int val, int[] parent)
    {
        int x=val;
        while(parent[x]!=x) 
            x=parent[x];

        int root=x;
        x=val;

        while(parent[x]!=x) {
             int temp = parent[x];
             parent[x] = root;
             x=temp;
        }

        return root;
            
    }

    public boolean union (int a, int b, int[] parent)
    {   
        //System.out.println(" "+a+" "+b);
        int rootA=findRoot(a, parent);
        int rootB=findRoot(b, parent);
       // System.out.println(" "+rootA+" "+rootB);

        if(rootA==rootB) return false;

        if(rank.get(rootA) > rank.get(rootB)){
               parent[rootB] = rootA;
        } else if(rank.get(rootB) > rank.get(rootA)){
                 parent[rootA] = rootB;
        } else { // equal so rootA grows
                parent[rootB] = rootA;
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
