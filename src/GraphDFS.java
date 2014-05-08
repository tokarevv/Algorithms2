import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: vito
 * Date: 5/7/14
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphDFS {

    public static Graph graph;
    private static Set<GraphNode> visited;
    private static Map<String, String> path;

    public static void main(String[] args) {
        init();
        testFind("A", "D");
//        testFind("C", "B");
//        visited.clear();path.clear();
//        System.out.println(dfs(graph.nodes.get("C"), graph.nodes.get("B")));
//        printPath();
    }

    private static void testFind(String from, String to) {
        visited.clear();path.clear();
        System.out.println(dfs(graph.nodes.get(from), graph.nodes.get(to)));
        printPath(to);
    }

    private static void printPath(String nodeName) {
        if (nodeName == null){
            return;
        }

        printPath(path.get(nodeName));
        System.out.println(nodeName);
    }


    private static boolean dfs(GraphNode from, GraphNode to) {
//        System.out.println(from.name);

        if (from.equals(to)){
            return true;
        }
        for (GraphNode adjNode : from.adjacentNodes){
//            System.out.println(adjNode.name);
            if (!visited.contains(adjNode)){
                path.put(adjNode.name, from.name);
                visited.add(adjNode);
                if (dfs(adjNode, to)){
                    return true;
                }
            }
        }
        return false;

    }

    private static void init() {
        path = new HashMap<String, String>();
        visited = new HashSet<GraphNode>();
        graph = new Graph();
        addNode("A");
        addNode("B");
        addNode("C");
        addNode("D");
        addNode("E");
        addNode("F");
        addNode("G");

        connect("A", "B", "C", "D");
        connect("C", "D", "E", "F");
        connect("D", "F");
        connect("E", "G");
        connect("F", "G");

    }

    private static void connect(String fromName, String... toNames) {
        GraphNode from = graph.nodes.get(fromName);
        for (String nodeName : toNames){
            from.adjacentNodes.add(graph.nodes.get(nodeName));
        }
    }

    private static void addNode(String name) {
        graph.nodes.put(name, new GraphNode(name));
    }


}
