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

  public void isSnakeOrSnail() {
    SLNode node = findBeginOfLoop(headNode);
    if (node == headNode) {
      System.out.println("is Snake");
    } else if (node == null) {
      System.out.println("loop does not exist!!");
    } else {
      System.out.println("is Snail");
    }
  }

  public int lenghtOfLoop() {
    SLNode ptr1 = findBeginOfLoop(headNode);
    SLNode ptr2 = ptr1;
    int counter = 0;
    while (ptr2.getNext() != ptr1) {
      counter++;
      ptr2 = ptr2.getNext();
    }
    counter++;
    System.out.println("length of loop is: " + counter);
    return counter;
  }

  /*Reversing a single Linked List*/
  public void reverseList() {
    headNode = reverseList(headNode);
    this.listTraverse();
  }

  private SLNode reverseList(SLNode headNode) {
    SLNode prev = null;
    SLNode next = null;
    SLNode curr = headNode;
    while (curr != null) {
      next = curr.getNext();
      curr.setNext(prev);
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public void intersectNode() {
    SLinkedList sLinkedList1 =
        new SLinkedList(new int[]{2, 3, 5, 9, 8, 7, 6, 3, 2, 1, 4, 5, 6, 3, 2, 4});
    SLinkedList sLinkedList2 =
        new SLinkedList(new int[]{2, 3, 5, 9, 6, 7, 2, 3, 5, 5, 6, 3, 2, 4});
    SLNode node1 = sLinkedList1.getHeadNode();
    SLNode node2 = sLinkedList2.getHeadNode();
    SLNode q = node2.getNext().getNext().getNext().getNext();
    SLNode p = node1;
    while (p.getNext() != null) {
      p = p.getNext();
    }
    p.setNext(q);

    findIntersectNode(node1, node2);
  }

  private boolean findIntersectNode(SLNode node1, SLNode node2) {
    HashSet<SLNode> nodeSet = new HashSet<>();
    while (node1 != null) {
      nodeSet.add(node1);
      node1 = node1.getNext();
    }
    while (node2 != null) {
      if (nodeSet.contains(node2.getNext())) {
        System.out.println("intersecting node is:   " + node2.getNext().getData());
        return true;
      }
      node2 = node2.getNext();
    }
    return false;
  }
}
