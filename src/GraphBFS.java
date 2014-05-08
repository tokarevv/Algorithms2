import java.util.*;

public class GraphBFS {

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
        System.out.println(bfs(graph.nodes.get(from), graph.nodes.get(to)));
        printPath(path.get(to)); //the rest of the path
        System.out.println(to);
    }

    private static boolean bfs(GraphNode from, GraphNode to) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        visited.add(from);
        q.add(from);
        while (!q.isEmpty()){
            GraphNode top = q.poll();
            if (top.equals(to)){
                return true;
            }
            for (GraphNode child : top.adjacentNodes){
                if (!visited.contains(child)){
                    q.add(child);
                    visited.add(child);
                    path.put(child.name, top.name);//where we came from (the closest to the start)
                }
            }


        }
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static void printPath(String nodeName) {
        if (nodeName == null){
            return;
        }

        printPath(path.get(nodeName));
        System.out.println(nodeName);
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

//    private static boolean dfs(GraphNode from, GraphNode to) {
////        System.out.println(from.name);
//        path.add(from.name);
//        if (from.equals(to)){
//            return true;
//        }
//        for (GraphNode adjNode : from.adjacentNodes){
//            if (!visited.contains(adjNode)){
//                visited.add(adjNode);
//                if (dfs(adjNode, to)){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
}
