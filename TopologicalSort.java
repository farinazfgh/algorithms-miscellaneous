import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//todo just graph is created topological yet to be created
class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        System.out.println(graph);
        List<Integer> sortedOrder = new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        System.out.println(result);
    }

    static Map<Integer, List<Integer>> createGraph(int[][] array) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            List<Integer> neighbors = graph.get(array[i][0]);
            if (neighbors == null) neighbors = new ArrayList<>();
            neighbors.add(array[i][1]);
            graph.put(array[i][0], neighbors);
        }

        return graph;
    }
}