/**
 * Created with IntelliJ IDEA.
 * User: Graf
 * Date: 21.04.14
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
public class RBTree{
    final boolean RED = false;
    final boolean BLACK = true;

    Node root;

    public void insert(int value){
        //usual SBTee insert
        Node newNode = new Node(value);
        if (root == null){
            newNode.color = BLACK;
            root = newNode;
        }
        if (newNode.value == root.value){
            //do nothing
            root.value = value;
        } else {
            insertTo(newNode, root);
            ensureBalance(newNode);
        }
    }

    private void insertTo(Node newNode, Node parent){

        if (newNode.value < parent.value){
            if (parent.left == null){
                parent.left = newNode;
                newNode.parent = parent;
            }else{
                insertTo(newNode, parent.left);
            }
        }else{
            if (parent.right == null){
                parent.right = newNode;
                newNode.parent = parent;
            }else{
                insertTo(newNode, parent.right);
            }
        }
    }

    private void ensureBalance(Node node){
        if (breaksTree(node)){
            balance(node);
        }
    }

    private boolean breaksTree(Node node){
        if (node.parent == null){
            return  false;
        } else {
            return  node.isRed() && node.parent.isRed();
        }
    }

    private void balance(Node node){
        //this node is red and it’s parent is red

        Node uncle = getUncle(node); //!!!!
        if (uncle == null){}//there’s somehting wrong and we’ll have a null pointer exception

        if (uncle.isRed()){//case 1 - uncle is red - repaint, recheck
            node.parent.color = BLACK;
            node.parent.parent.color = RED;
            ensureBalance(node.parent.parent);
        }else{ //case 2 - uncle is black:
            if (node.isRight()){
                if (uncle.isRight()){
//subcase 2.1 - we’re on the same side as uncle - rotate, rotate, repaint
                    rotateLeft(node);
                }
                rotateRight(node);
                node.color = BLACK;
                node.right.color = RED;

            } else { //node is left
                if (!uncle.isRight()){ //uncle is left
                    rotateRight(node);
                    rotateLeft(node);
                    node.color = BLACK;
                    node.right.color = RED;
                } else {
                    rotateLeft(node);
                    node.color = BLACK;
                    node.right.color = RED;
                }
            }
        }

    }

    private Node getUncle(Node node) {
        if (node.parent.isRight()){
            return node.parent.parent.left;
        }else{
            return node.parent.parent.right;
        }
    }

    private void rotateRight(Node node){
        Node temp = node.left;
        node.left = node.parent;
        node.left.right = temp;
        node.parent = node.left.parent;
        node.left.parent = node;
    }


    private void rotateLeft(Node node){
        Node temp = node.right;
        node.right = node.parent;
        node.right.left = temp;
        node.parent = node.right.parent;
        node.right.parent = node;
    }



    public void delete(int value){}

    public int[] toArray(){
        return new int[1];
    } //returns a sorted array


    class Node{

        int value;
        Node right;
        Node left;
        Node parent;
        boolean color;

        Node(int value){
            this.value = value;
            color = RED; //TODO: red or black by default?
        }

        boolean isRed(){
            return color == RED;
        }

        boolean isRight(){
            //parent is not null
            return value == parent.right.value;
        }

    }

}
