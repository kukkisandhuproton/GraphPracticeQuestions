class Solution {
    int size;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        use Kahn's algo
//      1. set up indegree array for each vertex
        int[] indegree = new int[numCourses];
        int size = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
        for(int i=0;i<size; i++){
            adj.add(new ArrayList<>());
        }
        // graph is going from (A,B) => b -> a
        for(int[]preq: prerequisites){
            int course = preq[0]; // which is 'a'
            int pre = preq[1]; // which is 'pre'
            adj.get(pre).add(course);
            indegree[course]++;
        }

//      2.  Initialize a queue and add when the indegree is zero
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
//      3. now do BFS method 
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            // find the neighbors now
            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}

/*
    public ArrayList<ArrayList<Integer>> prepare(int preq){
        int numOfVertex = preq.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0;i<numOfVertex; i++){
            adj.add(new ArrayList<>());
        }

        for(int source = 0; source<numOfVertex; source++){
            for(int destination = 0; destination<preq[source].length; destination){
                adj.get(source).add(destination);
            }
        }
    }
*/
