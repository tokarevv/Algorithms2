import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: vito
 * Date: 5/7/14
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
   public class GraphNode{

        String name;
        Set<GraphNode> adjacentNodes = new LinkedHashSet<GraphNode>();

        public GraphNode(String name){
            this.name = name;
        }

        public GraphNode(){}

        public int hashCode(){
            return name.hashCode();
        }

        public boolean equals(Object other){
            if (!(other instanceof GraphNode)){
                return false;
            }
            GraphNode otherNode = (GraphNode) other;
            return otherNode.name != null && name != null && otherNode.name.equals(name);
        }

    }