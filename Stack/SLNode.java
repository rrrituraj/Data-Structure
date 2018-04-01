package Stack;

public class SLNode {

    private int data;
    private SLNode next;

    public SLNode(int data) {
        this.data = data;
    }

    public SLNode() {

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }


}
