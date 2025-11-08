package lists;

public class Test {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();
        list.addLast("apple");
        list.addLast("banana");
        list.addLast("cherry");

        System.out.println("Index of banana: " + list.indexOf("banana"));
        System.out.println("Index of apple: " + list.indexOf("apple"));
        System.out.println("Index of cherry: " + list.indexOf("cherry"));
        System.out.println("Index of mango: " + list.indexOf("mango"));
    }
}

