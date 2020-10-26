package SkewHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class SkewHeap {
    public final List<SkewHeapStates> skewHeapStatesLog = new LinkedList<>();
    private SkewNode root;
    private int size;

    public SkewHeap() {
        this.root = null;
        this.size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
        skewHeapStatesLog.add(SkewHeapStates.rootDeleted);
    }

    public int getSize() {
        return size;
    }

    public void insert(int val) {
        root = merge(root, new SkewNode(val));
        size++;
    }

    public void removeSmallest() {
        if (root == null)
            throw new NoSuchElementException("Element not found");
        root = merge(root.left, root.right);
        skewHeapStatesLog.add(SkewHeapStates.rootDeleted);
        size--;
    }
    private SkewNode merge(SkewNode x, SkewNode y) {
        skewHeapStatesLog.add(SkewHeapStates.treeMerged);
        if (x == null)
            return y;
        if (y == null)
            return x;

        if (x.element < y.element) {
            SkewNode temp = x.left;
            x.left = merge(x.right, y);
            skewHeapStatesLog.add(SkewHeapStates.leftNodeSet);
            x.right = temp;
            return x;
        } else {
            SkewNode temp = y.right;
            y.right = merge(y.left, x);
            skewHeapStatesLog.add(SkewHeapStates.rightNodeSet);
            y.left = temp;
            return y;
        }
    }

    public String displayHeap() {
        StringBuilder message = new StringBuilder();
//        System.out.print("\nHeap : ");
        displayHeap(root, message);
//        System.out.println("\n");
        return message.toString().trim();
    }

    private void displayHeap(SkewNode r, StringBuilder message) {
        if (r != null) {
            displayHeap(r.left, message);
            message.append(r.element).append(" ");
//            System.out.print(r.element + " ");
            displayHeap(r.right, message);
        }
    }

    public void displayLog(){
        System.out.println(skewHeapStatesLog);
    }

    public void clearLog() {
        skewHeapStatesLog.clear();
    }
}