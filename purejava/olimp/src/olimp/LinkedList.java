package olimp;

public class LinkedList<E> {

    static class LinkedListNode<E> {
        E data;
        LinkedListNode<E> next;
        
        public void print() {
            LinkedListNode<E> curr = this;
            while(curr.next != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
        }
        
    }

    /**
     * Not exactly the best object orientation, but we'll manage
     */
    static <E> E deleteNode(LinkedListNode<E> node) {
        if(node == null || node.next == null) return null;

        E retval = node.data;
        LinkedListNode<E> next = node.next;
        node.data = next.data;
        node.next = next.next;
        return retval;
    }

    public LinkedListNode<E> head;
    public LinkedListNode<E> tail;

    public LinkedList() {
        this.head = new LinkedListNode<E>();
        this.tail = new LinkedListNode<E>();
        head.next = tail;
    }

    public void addLast(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null
        tail.data = e;
        tail.next = node;
        tail = node;
    }

    public void addFirst(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(); // e and next are null;
        node.next = head.next;
        node.data = e;
        head.next = node;
    }

    public E deleteFirst() {
        LinkedListNode<E> first = head.next;
        head.next = first.next;
        return first.data;
    }

    public E deleteLast() {
        // cannot do without iteration of the list! :-(
        throw new UnsupportedOperationException();
    }

    public LinkedListNode<E> findFirst(E e) {
        LinkedListNode<E> curr = head.next;
        while(curr != null) {
            if(curr.data != null && curr.data.equals(e)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void print() {
        LinkedListNode<E> curr = head.next;
        while(curr.next != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }



}