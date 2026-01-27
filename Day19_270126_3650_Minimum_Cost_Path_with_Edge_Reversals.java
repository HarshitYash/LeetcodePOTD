public class Day19_270126_3650_Minimum_Cost_Path_with_Edge_Reversals {
    HashMap<Integer, List<int[]>> map;
    public int minCost(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, 2*w});
        }
        return calculate(n);
    }
    //Dijkstra Algo
    private int calculate(int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );

        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int costSoFar = curr[1];

            if (node == n - 1) return costSoFar;
            if (visited[node]) continue;
            visited[node] = true;

            for (int[] edge : map.getOrDefault(node, Collections.emptyList())) {
                int next = edge[0];
                int newCost = costSoFar + edge[1];

                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new int[]{next, newCost});
                }
            }
        }
        return -1;
}
