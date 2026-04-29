import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node<Association<K, V>> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

        public void insert(K key, V value) {
        Association<K, V> newAssociation = new Association<>(key, value);
        root = insert(root, newAssociation);
    }

        private Node<Association<K, V>> insert(Node<Association<K, V>> node, Association<K, V> assoc) {
        if (node == null) {
            size++;
            return new Node<>(assoc);
        }

        int cmp = assoc.getKey().compareTo(node.getElement().getKey());

        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), assoc));
        } else if (cmp > 0) {
            node.setRight(insert(node.getRight(), assoc));
        } else {
            node.getElement().setValue(assoc.getValue());
        }

        return node;
    }


    public Association<K, V> search(K key) {
        return search(root, key);
    }

    private Association<K, V> search(Node<Association<K, V>> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getElement().getKey());
        if (cmp < 0) {
            return search(node.getLeft(), key);
        } else if (cmp > 0) {
            return search(node.getRight(), key);
        } else {
            return node.getElement();
        }
    }

    public List<Association<K, V>> inOrder() {
        List<Association<K, V>> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node<Association<K, V>> node, List<Association<K, V>> result) {
        if (node != null) {
            inOrder(node.getLeft(), result);
            result.add(node.getElement());
            inOrder(node.getRight(), result);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
