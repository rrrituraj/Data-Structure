package LinkedList;

public class TestDLinkedList {

	public static void main(String[] args) {
		DLinkedList t = new DLinkedList();	
		t.DLLInsert(10);
		t.DLLInsert(20);
		t.DLLInsert(30);
		t.DLLInsert(40);
		t.DLLInsert(50);
		t.DLLInsert(60);
		t.DLLInsert(70);
		t.DLLInsert(80);
		t.DLLInsert(90);
		t.DLLInsert(100);
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());
		
		/*t.DLLInsert(2, 35);
		t.listTraverse();
		System.out.println("\nLength of the list is ------> " + t.listLength());*/
		
		/*t.DLLDelete(10);
		t.listTraverse();
		System.out.println("\nLength of the list is ------> " + t.listLength());*/
	}

}
