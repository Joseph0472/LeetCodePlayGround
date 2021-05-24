public class Node<E> {
    private Node<E> next;//pointer
    private E e;//data

    public Node() {

    }

    public Node(E e) {
        this.e = e;
    }

    public Node<E> getNext() {
        return next;
    }

}
