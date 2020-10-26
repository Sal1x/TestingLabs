package SkewHeap;

public class SkewNode {
    int element;
    SkewNode left, right;

    public SkewNode(int value){
        this.element = value;
        this.right = null;
        this.left = null;
    }
}
