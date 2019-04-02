public class Node {
  private Integer data;
  private Node next, prev;

  public Node(Integer value) {
    data = value;
  }

  public Node next() {
    return next;
  }

  public Node prev() {
    return prev;
  }

  public void setNext(Node other) {
    this.next = other;
    other.prev = this;
  }

  public void setPrev(Node other) {
    this.prev = other;
    other.next = this;
  }

  public Integer getData() {
    return data;
  }

  public Integer setData(Integer i) {
    Integer output = this.data;
    data = i;
    return output;
  }

  public String toString() {
    return data + "";
  }
}
