public class Radix{
  public static void main(String[] args) {
    int[] list = {12,1232341,12323,123235454,-115646456,66664,994};
    //
    radixsort(list);
    for (int x = 0; x < list.length; x ++) {
      System.out.println(list[x]);
    }
  }

  public static void radixsort(int[] data) {
    @SuppressWarnings({"unchecked", "rawtypes"})
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();

    //Initializing
    for (int x = 0; x < 20; x ++) buckets[x] = new MyLinkedList<Integer>();
    int max = 0;

    //First Loop
    for (int x = 0; x < data.length; x ++) {
      if (data[x] > max) max = data[x];
      int value = data[x];
      int digit = Math.abs(value) % 10;
      if (value < 0) buckets[9 - digit].add(value);
      else buckets[digit + 10].add(value);
    }

    //From buckets to list
    for (int x = 0; x < 20; x ++) {
      list.extend(buckets[x]);
      buckets[x] = new MyLinkedList<Integer>();
    }

    //All other loops
    int place = 10;
    while (place <= max) {
      while (list.hasNext()) {
        int value = list.next();
        int digit = (Math.abs(value) / place) % 10;
        if (value < 0) buckets[9 - digit].add(value);
        else buckets[digit + 10].add(value);
      }
      list.clear();
      for (int x = 0; x < 20; x ++) {
        list.extend(buckets[x]);
      }
      place *= 10;
      list.reset();
    }
    int x = 0;

    //From list to data
    while (list.hasNext()) data[x ++] = list.next();
  }

  //Not using in current code
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
