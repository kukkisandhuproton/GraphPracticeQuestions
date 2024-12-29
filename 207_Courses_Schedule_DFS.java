class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int size = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<size; i++){
            adj.add(new ArrayList<>());
        }
        /*
        graph is represented from b -> a    (for a, b)
        */
        for(int[] preq : prerequisites){
            int course = preq[0]; // a;
            int pre = preq[1]; //b;
            adj.get(pre).add(course);
//            adj.get(preq[0]).add(preq[1]);aa
        }
        // now DFS method to go over the graph
        boolean[] visited = new boolean[size];
        boolean[] inRec = new boolean[size];

        for(int i = 0; i<size; i++){
            if(!visited[i] && dfs(adj, visited, inRec, i)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, 
                        boolean[]visited, boolean[]inRec, int vertex){
    
        visited[vertex] = true;
        inRec[vertex] = true;

        for(int neighbor: adj.get(vertex)){
            if(!visited[neighbor] && dfs(adj,visited,inRec,neighbor)){
                return true;
            }
            else if(inRec[neighbor]){
                return true;
            }
        }                    
        inRec[vertex] = false;
        return false;
    }

}
