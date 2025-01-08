class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0){
            return -1;
        }
        int edges = times.length;
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges;i++){
            int node = times[i][0];
            int edge = times[i][1];
            int weight = times[i][2];

            adj.get(node).add(new iPair(edge, weight));
        }
        ArrayList<Integer> result = dijkastra(adj, k);
        
        int max=-1;
        for(int i = 1; i<=n; i++){
            System.out.println(result.get(i));
            if(result.get(i) == Integer.MAX_VALUE){
                return -1;
            }
        }
        for(int i = 1; i<=n; i++){
            max = Math.max(max, result.get(i));
        }
        return max;
    }

    public ArrayList<Integer> dijkastra(ArrayList<ArrayList<iPair>> adj, int source){
        int[] array = new int[adj.size()];

        PriorityQueue<Node> pq = new 
                        PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));

        Arrays.fill(array,Integer.MAX_VALUE);
        array[source] = 0;
        pq.add(new Node(source, array[source]));

        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int currentvertex = temp.vertex;
            int currentdistance = temp.weight;

            for(iPair neighbor: adj.get(currentvertex)){
                int v = neighbor.first;
                int d = neighbor.second;

                if(d+currentdistance<array[v]){
                    array[v] = d + currentdistance;
                    pq.offer(new Node(v, array[v]));    
                }
            }
        }    
        ArrayList<Integer> result = new ArrayList<>();
        for(int dist: array){
            result.add(dist);
        }
        return result;
    }
}

class iPair{
    int first; 
    int second;

    public iPair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Node{
    int vertex;
    int weight;

    public Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
}
