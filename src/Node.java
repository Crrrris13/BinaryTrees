public class Node<S> {
    protected S element;
    protected Node<S> left;
    protected Node<S> right;

    public Node(S element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public S getElement() {
        return element;
    }

    public void setElement(S element) {
        this.element = element;
    }

    public Node<S> getLeft() {
        return left;
    }

    public void setLeft(Node<S> left) {
        this.left = left;
    }

    public Node<S> getRight() {
        return right;
    }

    public void setRight(Node<S> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
