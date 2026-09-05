class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList [numCourses];
        // model dependcies as DAG and find cycles if found return false.
        //[1,0][2,3][4,5][0,3] | adjList null,{0},{3},{0},{5},null

        for(int[] preReq : prerequisites)
        {
            int i=preReq[0];
            int dep=preReq[1];

            if(adjList[i]==null){
                adjList[i]=new ArrayList<Integer>();
            }
            adjList[i].add(dep);
        }

        Set<Integer> globalSet = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();

        for(int k=0; k < numCourses; k++) {
            if(adjList[k]==null){ 
               globalSet.add(k);
              continue;
            }
            visited.add(k);
            if(isCycleDFS(visited, globalSet, adjList[k] , adjList)) return false;
            visited.remove(k);

            globalSet.add(k);
        }

        return true;
    }

    public boolean isCycleDFS(Set<Integer> visited, Set<Integer> globalSet,ArrayList<Integer> dependencies, ArrayList<Integer>[] adjList){
      for(int dep : dependencies)
      {   
        //  System.out.println(dep +" " +visited.toString());
          if(globalSet.contains(dep)) continue;//return false if already fullyVisited
          if(visited.contains(dep)) return true;

          visited.add(dep);
          if(adjList[dep]!=null){

              boolean isCycle = isCycleDFS(visited, globalSet, adjList[dep], adjList);
              if(isCycle) return isCycle;
              else   globalSet.add(dep);
          }
          visited.remove(dep);

      }
      return false;
    }

   private void printLi(ArrayList<Integer> p) {
        p.forEach(System.out::println);
   }

}