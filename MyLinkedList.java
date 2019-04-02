public class MyLinkedList {
  private int length;
  private Node start, end;

  public static void main(String args[]) {
    MyLinkedList list = new MyLinkedList();
    for(Integer i = 0; i < 10; i++) {
        list.add(i);
    }
    MyLinkedList list2 = new MyLinkedList();
    for (Integer i = 10; i < 20; i++) {
      list2.add(i);
    }
    System.out.println("List1: " + list);
    System.out.println("List2: " + list2);
    list.extend(list2);
    System.out.println("Combined: " + list);
    System.out.println("Updated List2: " + list2);
  }

  public MyLinkedList() {
    length = 0;
    start = new Node(null);
    end = new Node(null);
  }

  public int size() {
    return length;
  }

  public String toString() {
    if (length == 0) return "[]";
    String output = "[";
    Node current = start;
    for (int x = 0; x < length; x ++) {
      output += current.getData() + ", ";
      current = current.next();
    }
    output = output.substring(0, output. length() - 2);
    output += "]";
    return output;
  }

  public boolean add(Integer value) {
    if (length == 0) {
      start.setData(value);
      end.setData(value);
    }
    else if (length == 1) {
      end = new Node(value);
      start.setNext(end);
    }
    else {
      Node newEnd = new Node(value);
      end.setNext(newEnd);
      end = newEnd;
    }
    length ++;
    return true;
  }

  private Node getNthNode(int n) {
    int x = 0;
    Node current = start;
    while (x < n ) {
      current = current.next();
      x ++;
    }
    return current;
  }

  public Integer get(int index) {
    if (index >= length || index < 0) throw new IndexOutOfBoundsException();
    return getNthNode(index).getData();
  }

  public Integer set(int index, Integer value) {
    if (index >= length || index < 0) throw new IndexOutOfBoundsException();
    return getNthNode(index).setData(value);
  }

  public boolean contains(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x ++) {
      if (current.getData().equals(value)) return true;
      current = current.next();
    }
    return false;
  }

  public int indexOf(Integer value) {
    Node current = start;
    for (int x = 0; x < length; x ++) {
      if (current.getData().equals(value)) return x;
      current = current.next();
    }
    return -1;
  }

  public void add(int index, Integer value) {
    if (index >= length || index < 0) throw new IndexOutOfBoundsException();
    if (index == 0) {
      Node newStart = new Node(value);
      start.setPrev(newStart);
      start = newStart;
    }
    else {
      Node oldOne = getNthNode(index);
      Node newOne = new Node(value);
      oldOne.prev().setNext(newOne);
      newOne.setNext(oldOne);
    }
    length ++;
  }

  public Integer remove(int index) {
    if (index >= length || index < 0) throw new IndexOutOfBoundsException();
    Integer output;
    if (index == length - 1) {
      output = end.getData();
      end = end.prev();
    }
    else if (index == 0) {
      output = start.getData();
      start = start.next();
    }
    else {
      Node target = getNthNode(index);
      target.prev().setNext(target.next());
      output = target.getData();
    }
    length --;
    return output;
  }

  public boolean remove(Integer value) {
    System.out.println(contains(value));
    if (! contains(value)) return false;
    remove(indexOf(value));
    return true;
  }

  public void extend(MyLinkedList other) {
    Node otherStart = other.start;
    Node otherEnd = other.end;
    this.end.setNext(otherStart);
    this.end = otherEnd;
    this.length += other.length;
    other.length = 0;
    other.end = null;
    other.end = null;
  }
}
