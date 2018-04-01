package LinkedList;

public class DLinkedList {
	public DLinkedList(){
	}
	DLLNode headNode;
	
	public void DLLInsert(int position, int data){
		DLLNode nodeToInsert=new DLLNode(data);
		if(headNode==null){
			headNode=nodeToInsert;
		}
		
		int size=listLength();
		if(position>size+1 || position<1){
			System.out.println("Invalid node");
		}
		if(position==1){
			nodeToInsert.setNext(headNode);
			headNode.setPrev(nodeToInsert);
			headNode=nodeToInsert;
		}
		else{
			DLLNode previousNode=headNode;
			int count=1;
			while(count<position-1){
				previousNode=previousNode.getNext();
				count++;
			}
			DLLNode currentNode=previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			if(currentNode!=null){
				currentNode.setPrev(nodeToInsert);
			}
			previousNode.setNext(nodeToInsert);
			nodeToInsert.setPrev(previousNode);
		}
	}
	
	public void DLLInsert(int data) {
		DLLNode nodeToInsert = new DLLNode(data);

		if (headNode == null) {
			headNode = nodeToInsert;
		} else {
			DLLNode temp = headNode;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			nodeToInsert.setPrev(temp);
			temp.setNext(nodeToInsert);
		}
	}
	
	public void DLLDelete(int position) {
		int size = listLength();
		// discard if position is more than list length
		if (position > size || position < 1) {
			System.out.println("Invalid postion, Enter between 1 and " + listLength());
		}
		if(position==1){ //head node deletion
			DLLNode currentNode=headNode.getNext();
			headNode.setNext(null);
			headNode=currentNode;
			headNode.setPrev(null);			
		}
		else{  //At any index
			DLLNode currentNode=headNode;
			int count=1;
			while(count<position){
				currentNode=currentNode.getNext();
				count++;
			}
			currentNode.getPrev().setNext(currentNode.getNext());
			if(currentNode.getNext()!=null){
				currentNode.getNext().setPrev(currentNode.getPrev());
			}
			currentNode=null;
		}
	}
	
	public void listTraverse() {
		try {
			DLLNode currentNode = headNode;
			while (currentNode != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNext();
			}
		} catch (NullPointerException e) {
			System.out.println("List is Empty Bro, Go get some Data");
			e.printStackTrace();
		}
	}
		
	public int listLength() {
		int length = 0;
		DLLNode currentNode = headNode;
		// System.out.println(headNode.getData());
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
}
