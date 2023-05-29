public class Main {
    public static class List{
        private static Node Head;
        private class Node{
            private int value;
            private Node next;
        }
        public static boolean revert() {
            if (Head != null && Head.next != null) {
                Node temp = Head;
                rev(Head.next, Head);
                temp.next = null;
            }
            return false;
        }
        private static void rev(Node currentNode, Node previousNode) {
            if (currentNode.next == null) {
                Head = currentNode;
            } else {
                rev(currentNode.next, currentNode);
            }
            currentNode.next = previousNode;
        }
        void push(int value){
            Node node = new Node();
            node.value = value;
            node.next = Head;
            Head = node;
        }
        Integer pop(){
            if(Head != null) {
                Integer value = Head.value;
                Head = Head.next;
                return value;
            }
            return null;
        }
        void print(){
            Node current = Head;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
        Node find(int value){
            Node current = Head;
            while (current != null) {
                if(current.value == value){
                    return current;
                }
                current = current.next;
            }
            return null;
        }

    }
    public static void main(String[] args) {
        List list = new List();
        list.push(1);
        list.push(2);
        list.push(3);
        list.print();
        List.revert();
        list.print();
    }
}