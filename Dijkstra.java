import java.util.*;

class DijkstraAdjacencyMatrix {

    private static final int INFINITY = Integer.MAX_VALUE;

    public void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length;
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        Arrays.fill(distances, INFINITY);
        distances[startNode] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int u = findMinDistanceNode(distances, visited, numNodes);
            if (u == -1) { // All remaining nodes are inaccessible
                break;
            }
            visited[u] = true;

            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != INFINITY &&
                        distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }

        printSolution(distances, startNode, numNodes);
    }

    private int findMinDistanceNode(int[] distances, boolean[] visited, int numNodes) {
        int minDistance = INFINITY;
        int minDistanceNode = -1;

        for (int v = 0; v < numNodes; v++) {
            if (!visited[v] && distances[v] <= minDistance) {
                minDistance = distances[v];
                minDistanceNode = v;
            }
        }
        return minDistanceNode;
    }

    private void printSolution(int[] distances, int startNode, int numNodes) {
        System.out.println("Dijkstra Algorithm (Adjacency Matrix):");
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            if (distances[i] == INFINITY) {
                System.out.println("Node " + i + ": Unreachable");
            } else {
                System.out.println("Node " + i + ": " + distances[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage for Adjacency Matrix
        int[][] graphMatrix = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraAdjacencyMatrix dam = new DijkstraAdjacencyMatrix();
        dam.dijkstra(graphMatrix, 0);
    }
}

class DijkstraAdjacencyList {

    private static final int INFINITY = Integer.MAX_VALUE;

    // Inner class to represent a node in the adjacency list
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public void dijkstra(List<List<Node>> adj, int numNodes, int startNode) {
        int[] distances = new int[numNodes];
        Arrays.fill(distances, INFINITY);
        distances[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // If we've already found a shorter path to u, skip
            if (currentWeight > distances[u]) {
                continue;
            }

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (distances[u] != INFINITY && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.add(new Node(v, distances[v]));
                }
            }
        }

        printSolution(distances, startNode, numNodes);
    }

    private void printSolution(int[] distances, int startNode, int numNodes) {
        System.out.println("Dijkstra Algorithm (Adjacency List):");
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            if (distances[i] == INFINITY) {
                System.out.println("Node " + i + ": Unreachable");
            } else {
                System.out.println("Node " + i + ": " + distances[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int numNodes = 9;
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph (same as matrix example)
        // Graph data is defined as a matrix and then used to populate the adjacency list.
        int[][] graphData = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        // Populate the adjacency list 'adj' using the 'graphData' matrix.
        // 'numNodes' (initialized to 9) should match the dimensions of 'graphData'.
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) { // Assuming graphData is numNodes x numNodes
                if (graphData[i][j] != 0) {
                    // 'Node' refers to the static inner class DijkstraAdjacencyList.Node
                    adj.get(i).add(new Node(j, graphData[i][j]));
                }
            }
        }

        DijkstraAdjacencyList dal = new DijkstraAdjacencyList();
        dal.dijkstra(adj, numNodes, 0);

        // To make this file runnable directly, we need a single public class named Dijkstra
        // and a single main method. Let's combine the main methods or make one primary.
        // For now, I will keep the adjacency list's main method and comment out the matrix one.
        // Or, better, create a separate public class Dijkstra with a main method that calls both.
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        // --- Adjacency Matrix Example ---
        int[][] graphMatrix = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraAdjacencyMatrix dam = new DijkstraAdjacencyMatrix();
        dam.dijkstra(graphMatrix, 0);

        // --- Adjacency List Example ---
        int numNodesAdjList = graphMatrix.length; // Use graphMatrix.length for numNodes
        List<List<DijkstraAdjacencyList.Node>> adj = new ArrayList<>();
        for (int i = 0; i < numNodesAdjList; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list 'adj' using the 'graphMatrix'
        // (defined earlier for the Adjacency Matrix Example).
        for (int i = 0; i < numNodesAdjList; i++) {
            for (int j = 0; j < numNodesAdjList; j++) { // Assuming graphMatrix is square
                if (graphMatrix[i][j] != 0) {
                    adj.get(i).add(new DijkstraAdjacencyList.Node(j, graphMatrix[i][j]));
                }
            }
        }

        DijkstraAdjacencyList dal = new DijkstraAdjacencyList();
        dal.dijkstra(adj, numNodesAdjList, 0);
    }
}
