package com.mycompany.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    Range r1 = new Range("[1,4]");
    Range r2 = new Range("[1,4)");
    Range r3 = new Range("(1,4]");
    Range r4 = new Range("(1,4)");

    @Test
    public void constructorC1_4C() {
        Range r1 = new Range("[1,4]");
        assertArrayEquals(r1.endPoints, new int[] { 1, 4 });
    }

    @Test
    public void constructorC1_4A() {
        Range r2 = new Range("[1,4)");
        assertArrayEquals(r2.endPoints, new int[] { 1, 3 });
    }

    @Test
    public void constructorC100_400A() {
        Range r2 = new Range("[100,400)");
        assertArrayEquals(r2.endPoints, new int[] { 100, 399 });
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorThrowsIllegalArg() {
        Range r = new Range("{1,4}");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void constructorThrowsIndexOutOfBound() {
        Range r = new Range("[3,2]");
    }

    @Test
    public void constructorA1_4C() {
        Range r3 = new Range("(1,4]");
        assertArrayEquals(r3.endPoints, new int[] { 2, 4 });
    }

    @Test
    public void constructorA1_4A() {
        Range r4 = new Range("(1,4)");
        assertArrayEquals(r4.endPoints, new int[] { 2, 3 });
    }

    @Test
    public void r1Contains2() {
        assertTrue(r1.contains(2));
    }

    @Test
    public void r2Contains2_3() {
        assertTrue(r2.contains(2, 3));
    }

    @Test
    public void r3Contains1() {
        assertFalse(r3.contains(1));
    }

    @Test
    public void r4Contains2_5() {
        assertFalse(r4.contains(2, 5));
    }

    @Test
    public void r1DoesNotContains2() {
        assertFalse(r1.doesNotContains(2));
    }

    @Test
    public void r2DoesNotContains2_3() {
        assertFalse(r2.doesNotContains(2, 3));
    }

    @Test
    public void r3DoesNotContains1() {
        assertTrue(r3.doesNotContains(1));
    }

    @Test
    public void r4DoesNotContains2_5() {
        assertTrue(r4.doesNotContains(2, 5));
    }

    @Test
    public void r1AllPoints() {
        assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, r1.allPoints());
    }

    @Test
    public void r2AllPoints() {
        assertArrayEquals(new Integer[] { 1, 2, 3 }, r2.allPoints());
    }

    @Test
    public void r3AllPoints() {
        assertArrayEquals(new Integer[] { 2, 3, 4 }, r3.allPoints());
    }

    @Test
    public void r4AllPoints() {
        assertArrayEquals(new Integer[] { 2, 3 }, r4.allPoints());
    }

    @Test
    public void r1ContainsRangeC1_2C() {
        assertTrue(r1.containsRange(new Range("[1,2]")));
    }

    @Test
    public void r2ContainsRangeC1_3A() {
        assertTrue(r2.containsRange(new Range("[1,3)")));
    }

    @Test
    public void r3ContainsRangeC1_4C() {
        assertFalse(r3.containsRange(new Range("[1,4]")));
    }

    @Test
    public void r4ContainsRangeC1_3A() {
        assertFalse(r4.containsRange(new Range("[1,3)")));
    }

    @Test
    public void r1DoesNotContainsRangeC1_2C() {
        assertFalse(r1.doesNotContainsRange(new Range("[1,2]")));
    }

    @Test
    public void r2DoesNotContainsRangeC1_3A() {
        assertFalse(r2.doesNotContainsRange(new Range("[1,3)")));
    }

    @Test
    public void r3DoesNotContainsRangeC1_4C() {
        assertTrue(r3.doesNotContainsRange(new Range("[1,4]")));
    }

    @Test
    public void r4DoesNotContainsRangeC1_3A() {
        assertTrue(r4.doesNotContainsRange(new Range("[1,3)")));
    }

    @Test
    public void r1EndPointsShouldBe1_4() {
        assertArrayEquals(r1.endPoints(), new int[] { 1, 4 });
    }

    @Test
    public void r2EndPointsShouldBe1_3() {
        assertArrayEquals(r2.endPoints(), new int[] { 1, 3 });
    }

    @Test
    public void r3EndPointsShouldBe2_4() {
        assertArrayEquals(r3.endPoints(), new int[] { 2, 4 });
    }

    @Test
    public void r4EndPointsShouldBe2_3() {
        assertArrayEquals(r4.endPoints(), new int[] { 2, 3 });
    }

    @Test
    public void r1overlapsA2_9AShouldBeTrue() {
        assertTrue(r1.overlapsRange(new Range("(2,9)")));
    }

    @Test
    public void r2overlapsC2_5AShouldBeTrue() {
        assertTrue(r2.overlapsRange(new Range("[2,5)")));
    }

    @Test
    public void r3overlapsA4_7CShouldBeFalse() {
        assertFalse(r3.overlapsRange(new Range("(4,7]")));
    }

    @Test
    public void r4overlapsC4_10AShouldBeTrue() {
        assertFalse(r4.overlapsRange(new Range("[4,10)")));
    }

    @Test
    public void r1EqualsA0_5AShouldBeTrue() {
        assertTrue(r1.Equals(new Range("(0,5)")));
    }

    @Test
    public void r2EqualsC1_4AShouldBeTrue() {
        assertTrue(r2.Equals(new Range("[1,4)")));
    }

    @Test
    public void r3EqualsC1_4AShouldBeFalse() {
        assertFalse(r3.Equals(new Range("[1,4)")));
    }

    @Test
    public void r4EqualsC10_20CShouldBeFalse() {
        assertFalse(r4.Equals(new Range("[10,20]")));
    }

    @Test
    public void r1notEqualsA0_5AShouldBeFalse() {
        assertFalse(r1.notEquals(new Range("(0,5)")));
    }

    @Test
    public void r2notEqualsC1_4AShouldBeFalse() {
        assertFalse(r2.notEquals(new Range("[1,4)")));
    }

    @Test
    public void r3notEqualsC1_4AShouldBeTrue() {
        assertTrue(r3.notEquals(new Range("[1,4)")));
    }

    @Test
    public void r4notEqualsC10_20CShouldBeTrue() {
        assertTrue(r4.notEquals(new Range("[10,20]")));
    }
}
