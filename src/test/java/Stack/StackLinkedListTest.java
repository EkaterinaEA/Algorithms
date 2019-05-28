package Stack;

import Stack.StackLinkedList;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class StackLinkedListTest {

    StackLinkedList<String> stackLinkedList = new StackLinkedList<String>();

    @BeforeAll
    public void beforeAll(){
        assertTrue(stackLinkedList.isEmpty());
        assertEquals("List is empty", stackLinkedList.pop());
        assertEquals(0, stackLinkedList.size());
        assertNull(stackLinkedList.peek());
    }

    @Test
    public void testBeforeAll(){
        assertTrue(stackLinkedList.isEmpty());
     //   assertEquals("List is empty", stackLinkedList.pop());
        assertEquals(0, stackLinkedList.size());
        assertNull(stackLinkedList.peek());
    }

    @Test
    public void testPushAndPop(){
        stackLinkedList.push("0");
        stackLinkedList.push("1");
        stackLinkedList.push("2");
        assertEquals("2", stackLinkedList.pop());
        assertEquals("1", stackLinkedList.pop());
        assertEquals("0", stackLinkedList.pop());
    }

    @Test
    public void testPeek(){
        assertEquals(null, stackLinkedList.peek());
        stackLinkedList.push("0");
        assertEquals("0", stackLinkedList.peek());
    }

}
