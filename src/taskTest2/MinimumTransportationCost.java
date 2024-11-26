package taskTest2;

import java.util.*;

public class MinimumTransportationCost {

    public static Map<String, Integer> cityIndex = new HashMap<>(); // map of cities with id
    public static List<List<int[]>> graph = new ArrayList<>();
    public static int  n = 0; //Number of cities

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // the number of tests

        while (testCases-- > 0) { // until all tests are completed
            n = scanner.nextInt(); // Number of cities

            // Read cities and build the graph
            for (int i = 0; i < n; i++) {
                String cityName = scanner.next(); // name of city
                cityIndex.put(cityName, i);
                int p = scanner.nextInt(); // number of neighbors
                graph.add(new ArrayList<>());
                for (int j = 0; j < p; j++) {
                    int neighbor = scanner.nextInt() - 1; // Convert to 0-based index
                    int cost = scanner.nextInt();
                    graph.get(i).add(new int[]{neighbor, cost});
                }
            }

            // the number of paths to find
            int r = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // process each path
            for (int i = 0; i < r; i++) {
                String[] path = scanner.nextLine().split(" "); // array of cities to comparison

                // Find the shortest path using Dijkstra's algorithm
                int minCost = dijkstra(cityIndex.get(path[0]), cityIndex.get(path[1]));
                System.out.println(minCost);
            }

            // Consume the empty line between test cases
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    // Dijkstra's algorithm to find the shortest path
    private static int dijkstra(int source, int destination) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); //distance from every source
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); //sorted queue from min to max
        pq.offer(new int[]{source, 0}); //source - is the index of the starting node; 0 - the initial distance to itself

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int cost = current[1];

            if (node == destination) {
                return cost;
            }

            if (cost > dist[node]) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextCost = cost + neighbor[1];
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist[destination];
    }
}
