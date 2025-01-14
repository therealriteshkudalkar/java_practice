package problem99;

import java.util.ArrayList;
import java.util.List;

public class Problem99 {
    record Pair(int x, int y){}
    record Edge(int indexA, int indexB, int wt){}

    private int getDistance(Pair pointA, Pair pointB) {
        return Math.abs(pointA.x - pointB.x) + Math.abs(pointA.y - pointB.y);
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int[] rank, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);

        if (xParent != yParent) {
            // Which ever node's depth is more, make that as the parent
            if (rank[xParent] > rank[yParent]) {
                parent[yParent] = xParent;
            } else if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else {
                parent[xParent] = yParent;
                rank[yParent]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        // Create an edge list from these points
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            Pair pointA = new Pair(points[i][0], points[i][1]);
            for(int j = i + 1; j < points.length; j++) {
                // For each such point pair, we need to add edges in the graph
                Pair pointB = new Pair(points[j][0], points[j][1]);
                int distance = getDistance(pointA, pointB);
                edges.add(new Edge(i, j, distance));
            }
        }

        // Sort the edges according to edge weights
        edges.sort((o1, o2) -> Integer.compare(o1.wt, o2.wt));

        // Perform Kruskal's Algorithm on these
        int[] parent = new int[points.length];
        int[] rank = new int[points.length];

        // Initialize parent
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int sumOfEdgeWeights = 0;
        for (Edge edge: edges) {
            // Find parents
            int parentPointA = find(parent, edge.indexA);
            int parentPointB = find(parent, edge.indexB);

            // if parents are equal, then skip
            if (parentPointA != parentPointB) {
                union(parent, rank, parentPointA, parentPointB);
                sumOfEdgeWeights += edge.wt;
            }
        }
        return sumOfEdgeWeights;
    }
}
