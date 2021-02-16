package composite;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompositeTest {

    private Composite topLevel;
    private Composite secondLevel1;
    private Composite secondLevel2;
    private Leaf leaf1;
    private Composite thirdLevel1;
    private Leaf leaf2;

    @Before
    public void setUp() {
        topLevel = new Composite(0);

        secondLevel1 = new Composite(0);
        secondLevel2 = new Composite(0);
        leaf1 = new Leaf(0);

        topLevel.add(secondLevel1);
        topLevel.add(secondLevel2);
        topLevel.add(leaf1);

        thirdLevel1 = new Composite(0);
        leaf2 = new Leaf(0);

        secondLevel2.add(thirdLevel1);
        secondLevel2.add(leaf2);
    }


    @Test
    public void incrementLeaf() {
        leaf1.increment();
        assertEquals(0, topLevel.getValue());
        assertEquals(0, secondLevel1.getValue());
        assertEquals(0, secondLevel2.getValue());
        assertEquals(1, leaf1.getValue());
        assertEquals(0, thirdLevel1.getValue());
        assertEquals(0, leaf2.getValue());
    }

    @Test
    public void incrementAll() {
        topLevel.increment();
        assertEquals(1, topLevel.getValue());
        assertEquals(1, secondLevel1.getValue());
        assertEquals(1, secondLevel2.getValue());
        assertEquals(1, leaf1.getValue());
        assertEquals(1, thirdLevel1.getValue());
        assertEquals(1, leaf2.getValue());
    }

    @Test
    public void incrementBranch() {
        secondLevel2.increment();
        assertEquals(0, topLevel.getValue());
        assertEquals(0, secondLevel1.getValue());
        assertEquals(1, secondLevel2.getValue());
        assertEquals(0, leaf1.getValue());
        assertEquals(1, thirdLevel1.getValue());
        assertEquals(1, leaf2.getValue());
    }

    @Test
    public void decrementBranch() {
        secondLevel2.decrement();
        assertEquals(0, topLevel.getValue());
        assertEquals(0, secondLevel1.getValue());
        assertEquals(-1, secondLevel2.getValue());
        assertEquals(0, leaf1.getValue());
        assertEquals(-1, thirdLevel1.getValue());
        assertEquals(-1, leaf2.getValue());
    }
}