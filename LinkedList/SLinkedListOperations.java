package LinkedList;

import java.util.HashSet;

public class SLinkedListOperations {

  private SLNode headNode;

  public SLinkedListOperations(int[] arr) {
    SLinkedList list = new SLinkedList();
    for (int i : arr) {
      headNode = list.insertNode(i);
    }
  }

  public void loopedList() {
    headNode = loopedList(headNode);
  }

  private SLNode loopedList(SLNode headNode) {
    SLNode node1 = headNode;
    SLNode node2 = headNode;
    node1 = node1.getNext().getNext().getNext();
    while (node2.getNext() != null) {
      node2 = node2.getNext();
    }
    node2.setNext(node1);
    return headNode;
  }

  public void listTraverse() {
    try {
      SLNode currentNode = headNode;
      while (currentNode != null) {
        System.out.print(currentNode.getData() + "  ");
        currentNode = currentNode.getNext();
      }
      System.out.println();
    } catch (NullPointerException e) {
      System.out.println("List is Empty");
      e.printStackTrace();
    }
  }

  public void doesLoopExist() {
    boolean flag = doesLoopExist(headNode);
    if (flag == true) {
      System.out.println("yes! Absolutely Exist");
    } else {
      System.out.println("Nope Sir!!!");
    }
  }

  /* Floyd method of finding loop in linked list*/
  private boolean doesLoopExist(SLNode headNode) {
    if (headNode == null) {
      return false;
    }
    SLNode slowPtr = headNode;
    SLNode fastPtr = headNode;
    while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      if (slowPtr == fastPtr) {
        return true;
      }
    }
    return false;
  }

  public void doLoopExist() {
    boolean flag = doLoopExist(headNode);
    if (flag == true) {
      System.out.println("yes! Absolutely Exist");
    } else {
      System.out.println("Nope Sir!!!");
    }
  }

  /*Using Hashing to Detect Loop*/
  private boolean doLoopExist(SLNode headNode) {
    if (headNode == null) {
      return false;
    }
    SLNode ptr = headNode;
    HashSet<SLNode> hst = new HashSet<>();
    while (ptr.getNext() != null) {
      hst.add(ptr);
      ptr = ptr.getNext();
      if (hst.contains(ptr)) {
        return true;
      }
    }
    return false;
  }

  public void findBeginOfLoop() {
    SLNode beginNode = findBeginOfLoop(headNode);
    if (beginNode != null) {
      System.out.println("loop starts from the node: " + beginNode.getData());
    } else {
      System.out.println("loop does not exist!!");
    }
  }

  private SLNode findBeginOfLoop(SLNode headNode) {
    SLNode slowPtr = headNode;
    SLNode fastPtr = headNode;
    boolean doesLoopExist = false;
    while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext().getNext();
      if (slowPtr == fastPtr) {
        doesLoopExist = true;
        break;
      }
    }

    if (doesLoopExist) {
      slowPtr = headNode;
      while (slowPtr != fastPtr) {
        fastPtr = fastPtr.getNext();
        slowPtr = slowPtr.getNext();
      }
      return slowPtr;
    }
    return null;
  }
}
