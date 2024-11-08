package CustomerApp;

public class Node {
    Node next;
    Node prev;
    int id;
    String name;
    String surname;

    public Node(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

}
