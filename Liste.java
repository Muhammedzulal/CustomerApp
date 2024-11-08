package CustomerApp;

import java.util.Scanner;

public class Liste {
    Scanner sc = new Scanner(System.in);
    Node head = null;
    Node tail = null;

    void ekle() {
        System.out.print("id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ad: ");
        String name = sc.nextLine();
        System.out.print("Soyad: ");
        String surname = sc.nextLine();
        Node cusNode = new Node(id, name, surname);
        if (head == null) {// Liste boş
            head = cusNode;
            tail = cusNode;
            System.out.println("Listeye ilk müşteri eklendi.");
        } else {
            tail.next = cusNode;
            cusNode.prev = tail;
            tail = cusNode;
            System.out.println("Listeye müşteri eklendi.");
        }
    }

    public void sil(int id) {
        // Başlangıçta head'i geçiyoruz
        Node temp = head;

        // Liste boşsa hiçbir şey yapma
        if (head == null) {
            System.out.println("Liste boş, silme işlemi yapılamaz.");
            return;
        }

        // İlk elemanı silme
        if (temp != null && temp.id == id) { // Başlangıç elemanını kontrol ediyoruz
            head = temp.next; // Başlangıç node'unu bir sonraki node ile değiştiriyoruz
            if (head != null) { // Eğer yeni baş var ise, head'in prev'ini null yapıyoruz
                head.prev = null;
            }
            temp = null; // Silinen elemanı bellekten kaldırıyoruz
            System.out.println("Başlangıç elemanı silindi.");
            return;
        }

        // Sonraki elemanlara git
        while (temp != null && temp.id != id) { // Aradığımız id'yi bulana kadar ilerliyoruz
            temp = temp.next;
        }

        // Eleman bulunamadıysa
        if (temp == null) {
            System.out.println("Eleman bulunamadı.");
            return;
        }

        // Ortada bir eleman silme (önceki ve sonrasını ayarlıyoruz)
        if (temp.next != null) {
            temp.next.prev = temp.prev; // Silinen elemanın sonrasının prev'ini, bir önceki node yapıyoruz
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next; // Silinen elemanın öncesinin next'ini, bir sonraki node yapıyoruz
        }

        // Temp'yi null yaparak, silinen elemanı bellekten kaldırıyoruz
        temp = null;
        System.out.println("Eleman silindi.");
    }

    void yazdir() {
        Node temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Ad: " + temp.name + ", Soyad: " + temp.surname);
            temp = temp.next;
        }
    }
}
