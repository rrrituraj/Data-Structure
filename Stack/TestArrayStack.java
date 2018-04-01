package Stack;

/**
 * Created by RITURAJ on 26-02-2017.
 */
public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack st=new ArrayStack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);
        st.traverse(); //10,20,30,40,50,60,70,80,90,100
        st.pop(); //Poping value 100
        System.out.println("\npoping");
        st.traverse(); //10,20,30,40,50,60,70,80,90

    }
}
