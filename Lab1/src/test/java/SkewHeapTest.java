import SkewHeap.SkewHeap;
import SkewHeap.SkewHeapStates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SkewHeapTest {
    SkewHeap heap;

    @BeforeEach
    public void prepare() {
        heap = new SkewHeap();
    }

    @Test
    public void basicFunctions() {
        heap.clear();
        heap.clearLog();

        heap.insert(313);
        heap.insert(4);
        heap.insert(2);

        assertEquals("2 4 313", heap.displayHeap());
        assertEquals(List.of(
                SkewHeapStates.treeMerged, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.rightNodeSet, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.rightNodeSet),
                heap.skewHeapStatesLog);
    }

    @Test
    public void catchExceptionRemovingRoot() {
        heap.clear();
        heap.clearLog();

        heap.insert(42);
        heap.removeSmallest();
        assertEquals(List.of(
                SkewHeapStates.treeMerged, SkewHeapStates.treeMerged, SkewHeapStates.rootDeleted),
                heap.skewHeapStatesLog);
        assertThrows(NoSuchElementException.class, () -> heap.removeSmallest());
    }

    @Test
    public void moreData() {
        heap.clear();
        heap.clearLog();

        heap.insert(3);
        heap.insert(5);
        heap.insert(4);
        heap.insert(8);
        heap.insert(7);

        assertEquals("7 4 3 8 5", heap.displayHeap());
        assertEquals(List.of(
                SkewHeapStates.treeMerged, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.leftNodeSet, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.leftNodeSet, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.treeMerged, SkewHeapStates.leftNodeSet, SkewHeapStates.leftNodeSet,
                SkewHeapStates.treeMerged, SkewHeapStates.treeMerged, SkewHeapStates.treeMerged,
                SkewHeapStates.leftNodeSet, SkewHeapStates.leftNodeSet),
                heap.skewHeapStatesLog);
    }

}
