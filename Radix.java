public class Radix{
  public static void main(String[] args) {
    int[] list = {12,1232341,12323,123235454,-115646456,66666,999};
    System.out.println(findBiggest(list));
  }

  public static void radixsort(int[]data) {
    MyLinkedList[] buckets = new MyLinkedList[19];
    int maxDigits = findBiggest(data);

    //First Pass, using data
    for (int x: data) {
      buckets[x / 10 + 9].add(x);
    }
  }

  public static int findBiggest(int[] ary) {
    int biggest = ary[0];
    for (int x: ary) {
      if (x > biggest) biggest = x;
    }
    String help = biggest + "";
    if (help.charAt(0) == '-') return help.length() - 1;
    return help.length();
  }
}
