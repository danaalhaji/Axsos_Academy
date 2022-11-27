import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class TestSLL {
    
    public SinglyLinkedList sll;
    @Before
    public void setUp() throws Exception {
        sll = new SinglyLinkedList();
    }
    @Test
    public void testHeadForNull() {
        assertNull(sll.head);
    }
    
    @Test
    public void testHeadForNode() {
        sll.addNode(8);
        assertNotNull(sll.head);
    }
    
    @Test
    public void testHeadNextVal() {
        sll.addNode(5);
        sll.addNode(10);
        assertTrue(sll.head.next.data == 10);
    }
    
    @Test
    public void testHeadAfterRemove() {
        sll.addNode(10);
        sll.deleteFromStart();
        // write test first, then write code to pass the test.
    }
}

