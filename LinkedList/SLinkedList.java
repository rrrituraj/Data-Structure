package LinkedList;

public class SLinkedList {

  private SLNode headNode;

  public SLinkedList(int[] arr) {
    for (int i : arr) {
      this.insertNode(i);
    }
  }

  public SLinkedList() {
  }

  // insert node at begening
  public void insertAtFirst(int data) {
    SLNode node = new SLNode();
    node.setData(data);

    if (headNode == null) {
      headNode = node;
    } else {
      node.setNext(headNode);
      headNode = node;
    }
  }

  // overloaded insertNode(int pos , int data) method
  public void insertNode(int pos, int data) {
    SLNode node = new SLNode();
    node.setData(data);
    int length = 0;
    SLNode currentNode = headNode;
    while (currentNode.getNext() != null) {
      length++;
      if (length == pos - 1) {
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
      } else {
        currentNode = currentNode.getNext();
      }
    }
    if (pos > listLength()) {
      insertNode(data);
    }
  }

  // insert node at the end
  public SLNode insertNode(int data) {
    SLNode node = new SLNode();
    node.setData(data);

    if (headNode == null) {
      headNode = node;
    } else {
      SLNode currentNode = headNode;
      while (currentNode.getNext() != null) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(node);
    }
    return headNode;
  }

  // Delete First Node , we call it pop() method like in stack
  public void pop() {
    SLNode currentNode = headNode, q = headNode;
    currentNode = headNode.getNext();
    headNode = currentNode;
    q.setNext(null);
  }

  // Delete Last Node, We call it remove() method
  public int remove() {
    SLNode currentNode = headNode, endNode = headNode;
    while (endNode.getNext() != null) {
      endNode = endNode.getNext();
    }
    while (currentNode.getNext() != endNode) {
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(null);
    return endNode.getData();
  }

  // Delete a Node in Middle or at a position, overloaded remove method
  public void remove(int pos) {
    SLNode temp = headNode;
    int length = 0;
    if (pos == 1) {
      headNode = temp.getNext();
      temp.setNext(null);
    } else if (pos < listLength() && pos != 1) {
      while (temp.getNext() != null) {
        length++;
        if (length == pos - 1) {
          SLNode p = temp.getNext();
          temp.setNext(p.getNext());
          p.setNext(null);
        }
        temp = temp.getNext();
      }
    } else if (pos == listLength()) {
      while (temp.getNext().getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(null);
    } else {
      System.out.println("index you set is out of linked list length, please correct it");
    }
  }

  // Show the data at a given index
  public int listAt(int pos) {
    SLNode temp = headNode;
    int length = 0, x = 0;

    if (pos == 1) {
      x = headNode.getData();
    } else if (pos < listLength() && pos != 1) {
      while (temp.getNext() != null) {
        length++;
        if (length == pos) {
          x = temp.getData();
        }
        temp = temp.getNext();
      }
    } else if (pos == listLength()) {
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      x = temp.getData();
    } else {
      System.out.println("index out of bounds, returning 0");
    }
    return x;
  }

  // traverse the list
  public void listTraverse() {
    try {
      SLNode currentNode = headNode;
      while (currentNode != null) {
        System.out.println(currentNode.getData());
        currentNode = currentNode.getNext();
      }
    } catch (NullPointerException e) {
      System.out.println("List is Empty");
      e.printStackTrace();
    }
  }

  public int listLength() {
    int length = 0;
    SLNode currentNode = headNode;
    // System.out.println(headNode.getData());
    while (currentNode != null) {
      length++;
      currentNode = currentNode.getNext();
    }
    return length;
  }
}
