package Stack;

import LinkedList.SLNode;

@SuppressWarnings("ALL")
public class LinkedListStack {
    private SLNode headNode;

    @SuppressWarnings("unused")
	public LinkedListStack() {

    }

    public boolean isEmpty() {
        if (headNode == null) {
            return true;
        } else
            return false;
    }

    public void push(int data) {
        SLNode nd = new SLNode();
        nd.setData(data);
        if (headNode == null) {
            headNode = nd;
        } else {
            SLNode currentNode = headNode;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(nd);
        }
    }

    public int pop() {
        SLNode currentNode = headNode,endNode=headNode;
        while(endNode.getNext()!=null){
            endNode=endNode.getNext();
        }
        while(currentNode.getNext()!=endNode){
            currentNode=currentNode.getNext();
        }
        currentNode.setNext(null);
        return endNode.getData();
    }

    public void traverse() {
        try {
            SLNode currentNode = headNode;
            while (currentNode != null) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNext();
            }
        } catch (NullPointerException e) {
            System.out.println("List is Empty Bro, Go get some Data");
            e.printStackTrace();
        }
    }


}
