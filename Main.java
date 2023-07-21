public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);

        System.out.println("Size: " + myList.size());
        System.out.println("Element at index 2: " + myList.get(2));

        myList.remove(1);
        System.out.println("Size after removal: " + myList.size());
    }
}