import java.util.*;

public class CloneDirectedGraph {
    static class Graph {
        int V;
        int E;
        Map<Integer, List<Integer>> adjacenyList;

        public void setV(int v) {
            V = v;
        }

        public void setE(int e) {
            E = e;
        }

        public int getV() {
            return V;
        }

        public int getE() {
            return E;
        }

        int getNumberOfVertices() {
            return adjacenyList.size();
        }

        public void setAdjacenyList(Map<Integer, List<Integer>> adjacenyList) {
            this.adjacenyList = adjacenyList;
        }
    }

    Graph g;

    public CloneDirectedGraph(Graph g) {
        this.g = g;
    }

    Graph cloneGraph(Graph g, int source) {

        boolean[] isVisited = new boolean[g.getNumberOfVertices()];
        return dfs(source, isVisited, g);

    }

    Graph dfs(int source, boolean[] isVisited, Graph g) {
        Graph gPrime = new Graph();
        Map<Integer, List<Integer>> adjPrime = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        isVisited[source] = true;
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            for (int current : g.adjacenyList.get(vertex)) {
                if (!isVisited[current]) {
                    isVisited[current] = true;
                    stack.push(current);
                    List<Integer> neighbors = adjPrime.get(vertex);
                    if (neighbors == null) {
                        neighbors = new ArrayList<>();
                    }
                    neighbors.add(current);
                    adjPrime.put(vertex, neighbors);
                }
            }
        }

        gPrime.setAdjacenyList(adjPrime);
        gPrime.setV(adjPrime.size());
        return gPrime;
    }

}
