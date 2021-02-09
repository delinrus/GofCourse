package adapter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyClassAdapterTest {

    @Test
    public void test() {
        MyClass myClass = new MyClassAdapter(new МойКлас());
        assertEquals("Initialization",myClass.initialize());
        assertEquals("Action",myClass.action());
    }

}