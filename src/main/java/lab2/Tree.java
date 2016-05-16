package lab2;

/**
 * Created by pc8 on 16.05.16.
 */
public class Tree {

    private Node root;
    private int max = 0;
    private int min;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Метод выпечатывает все ключи
     * @param node
     */
    public void scanTree(Node node){

        if (node.getLeft() != null){
            scanTree(node.getLeft());
        }

        if (node.getRight() !=null){
            scanTree(node.getRight());
        }

        System.out.println(node.getKey());

    }
    /**
     * Метод выпечатывает все ключи листьев
     * @param node
     */
    public void scanAllLeaf(Node node){

        if (node.getLeft() != null){
            scanAllLeaf(node.getLeft());
        }

        if (node.getRight() !=null){
           scanAllLeaf(node.getRight());
        }

       if (node.getRight() == null && node.getLeft() == null) {
           System.out.println(node.getKey());
       }

    }

    /**
     * Метод возвращает узел по ключу
     * @param key
     * @param node
     * @return
     */
    public Node getNodeByKey(int key, Node node){


            if (node.getKey() == key){
              return node;
        }

        if (node.getLeft() != null){
        if (getNodeByKey(key, node.getLeft()) != null) {
            return getNodeByKey(key, node.getLeft());
        }
        }

        if (node.getRight() !=null){
            if(getNodeByKey(key, node.getRight()) != null) {
                return getNodeByKey(key, node.getRight());
            }
        }

      return null;

    }

    /**
     * Метод возвращает максимальный элемент
     * @param root
     * @return
     */
    public Node getMaxElement(Node root){

        if (root.getRight() == null ){
            return root;
        }

        return getMaxElement(root.getRight());
    }

    /**
     * Метод возвращает минимальный элемент
     * @param root
     * @return
     */
    public Node getMinElement(Node root){
        if (root.getLeft() == null ){
            return root;
        }

        return getMinElement(root.getLeft());
    }

    /**
     * Метод возвращает следующий элемент
     * @param node
     * @return
     */
    public Node getNext(Node node){
        if (node.getRight() != null) {
            return getMinElement(node.getRight());
        }
           Node parent = node.getParent();

        while (parent != null && node.equals(parent.getRight())) {
           node = parent;
        }
        parent = parent.getParent();
        return parent;
    }

    /**
     * Метод возвращает предыдущий элемент
     * @param node
     * @return
     */
    public Node getPrev(Node node){
        if (node.getLeft() != null) {
            return getMaxElement(node.getLeft());
        }
        Node parent = node.getParent();

        while (parent != null && node.equals(parent.getLeft())) {
            node = parent;
        }
        parent = parent.getParent();
        return parent;
    }

    /**
     * Метод удаляет элемент из дерева
     * @param root
     * @param key
     * @return
     */
    public Node delete( Node root , int key) {
        if( root == null) {
            return root;
        }
        if (key < root.getKey())

        {
            root.setLeft(delete(root.getLeft(), key))  ;
        } else if (key > root.getKey()) {

            root.setRight(delete(root.getRight(), key));
        }
        else if (root.getLeft() != null && root.getRight() != null){
            root.setKey(getMinElement(root.getRight()).getKey()) ;
            root.setRight(delete(root.getRight(), root.getRight().getKey()));
        }
        else  if (root.getLeft() != null) {
            root = root.getLeft();
        }
        else {
            root = root.getRight();
        }
            return root;
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        Node node9 = new Node(10);

        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);




        Tree tree = new Tree(node);
        tree.scanTree(node);

//        System.out.println(tree.getMaxElement(node).getKey());
//        System.out.println(tree.getMinElement(node).getKey());
//        System.out.println(tree.getNext(node1).getKey());
//        System.out.println(tree.getPrev(node1).getKey());
        System.out.println("--------");
//       tree.scanAllLeaf(node);

        tree.delete(node, 3);
        tree.scanTree(node);

    }

}
