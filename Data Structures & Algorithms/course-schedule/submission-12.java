class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length==0) return true;

        HashMap<Integer, Integer> inVectorCounts = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> depMap = new HashMap<>();
        int finishedCounts=0;
        Queue<Integer> queue = new LinkedList<Integer>();

    for(int[] pair : prerequisites)
    {
    //iterate all pairs - add invectorCounts n create dep maps
    inVectorCounts.put(pair[0], inVectorCounts.getOrDefault(pair[0], 0)+1);
    inVectorCounts.putIfAbsent(pair[1], 0); //put the reverse so we have a counterkey for it

    depMap.putIfAbsent(pair[1], new ArrayList<Integer>());
    ArrayList<Integer> arrLi = depMap.get(pair[1]);
    arrLi.add(pair[0]);
    
    // ArrayList<Integer> arrList = depMap.put(pair[1], depMap.getOrDefault(pair[1], new ArrayList<Integer>()));
    // arrList.add(pair[0]);
    // depMap.put(pair[1], arrList);
    }

    for(int i=0;i<numCourses; i++)
    {
      inVectorCounts.putIfAbsent(i,0);
    }

    for(Map.Entry<Integer, Integer> verticeInVector : inVectorCounts.entrySet() )
    {
        int vertice = verticeInVector.getKey();
        int counter = verticeInVector.getValue();

        if(counter==0) {
            queue.add(vertice);
        }
    }

    while(!queue.isEmpty()){
        int removedDep = queue.poll();
        finishedCounts++;
        // List<Integer> dependencies =  depMap.get(removedDep); 
        // if(dependencies==null) continue;
        List<Integer> dependencies = depMap.getOrDefault(removedDep, new ArrayList<Integer>());
        

       // System.out.println( removedDep + " " + dependencies.toString());

        for(int dep : dependencies)
        {
            inVectorCounts.put(dep, inVectorCounts.get(dep)-1);

            if(inVectorCounts.get(dep).equals(0)) {
                queue.add(dep);
            }
        }
    }

    if(finishedCounts == numCourses) return true;

        //iterate map for 0, if not-return false, 
            //if u find 0 , remove it in invec_map, move it to result set, 
            // then get subtract invector count of dependencies from depMap 
            // and if we dont find anything as a zero, then break, 
            // else add to result set and get its depArray n subtract and keep going

       // if result_set size != cumCourses, return false else true;
        return false;
    }
}
