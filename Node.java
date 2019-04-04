public class Node<E> {
    private E data;
    private Node next, prev;

    public Node(Node last) {
      prev = last;
    }

    public Node(E val) {
      data = val;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public void setNext(Node newNext) {
      next = newNext;
    }

    public void setPrev(Node newPrev) {
      prev = newPrev;
    }

    public boolean hasNext() {
      return next != null;
    }

    public E value() {
      return data;
    }

    public void set(E value) {
      data = value;
    }
}
