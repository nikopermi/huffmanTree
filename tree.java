package HuffmanEncoding;

public class tree implements Comparable<tree> {
    public int data;
    public Pair pair;
    public tree right;
    public tree left;

    public tree(){
        this(null, null, null);
    }
    public tree(Pair pair){
        this(pair,null, null);
    }
    public tree(Pair pair, tree left, tree right) {
        this.pair = pair;
        this.data = (pair != null) ? pair.getY() : 0;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if(pair != null){
            return pair.toString();
        }
        return ((data != 0 ? data : "null") + "->{" + (left != null ? (left.pair != null ? left.pair.toString() : left.data) : "null")+", " + (right != null ? (right.pair != null ? right.pair.toString() : right.data) : "null")+ "}");
    }
    public int compareTo(tree o) {
            return java.lang.Integer.compare(this.data, o.data);
    }



}
