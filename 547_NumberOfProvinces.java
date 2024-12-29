class Solution {
    int size;
    public int findCircleNum(int[][] isConnected) {

        //convert the matrix to the Adjacency list
        // ArrayList<ArrayList<Integer>> adj = adjacencyList(isConnected);
        size = isConnected[0].length;
        // now do DFS method
        boolean[] visited = new boolean[size];
        int count = 0;
        for(int i=0;i<size;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
//              dfs(adj, visited,i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][]isConnected, boolean[]visited, int vertex){
        visited[vertex] = true;

        for(int v = 0; v<size; v++){
            if(!visited[v] && isConnected[vertex][v] == 1){
                dfs(isConnected, visited, v);
            }
        }

    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int vertex){
        visited[vertex] = true;

        for(int neighbor: adj.get(vertex)){
            if(!visited[neighbor]){
                dfs(adj,visited, neighbor);
            }
        }
    }
/*
    public ArrayList<ArrayList<Integer>> adjacencyList(int[][] isConnected){
        int size = isConnected[0].length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<size; i++){
            result.add(new ArrayList<Integer>());
        }
        int i, j;

        for( i=0;i<isConnected[0].length; i++){
            for( j = 0; j<isConnected.length; j++){
                if(isConnected[i][j]!=0){
                    result.get(i).add(j);
                }
            }
        }
        return result;
    }
*/    
/*
    class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visited = new boolean[size];

        int result = 0;
        for(int i=0;i<size; i++){
            if(!visited[i]){
                bfs(isConnected, visited, i);
                result++;
            }
        }
        return result;
    }

    public void bfs(int[][] isConnected, boolean[] visited, int vertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        visited[vertex] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            // i will be the neighbor
            for(int i=0;i<isConnected.length;i++){
                if(!visited[i] && isConnected[node][i] == 1){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
    */
}
