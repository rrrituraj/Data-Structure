package LinkedList;

public class TestSLinkedList {

	public static void main(String[] args) {
		SLinkedList t = new SLinkedList();	
		t.insertNode(10);
		t.insertNode(20);
		t.insertNode(30);
		t.insertNode(40);
		t.insertNode(50);
		t.insertNode(60);
		t.insertNode(70);
		t.insertNode(80);
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());
		
		t.insertNode(9, 90);
		
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());
		
		/*t.pop();
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());*/	
		
		/*t.remove();
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());*/
		
		/*t.remove(3);
		t.listTraverse();
		System.out.println("\nLength of the list is ------> "+t.listLength());*/
		
		//System.out.println("value is "+t.listAt(6));
		

	}
}
