package Stack;

public class ArrayStack {
    int MAX = 1000;
    int top;
    int arr[] = new int[MAX];

    public ArrayStack() {
        top = -1;
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int value) {
        if (top >= MAX) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = value;
        }
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int value = arr[top--];
            return value;
        }
    }

    public void traverse() {
        if (!isEmpty()) {
            for (int x=0; x<=top;x++) {
                System.out.println(arr[x] + " ");
            }
        } else {
            System.out.println("Stack is Empty");
        }
    }
}
