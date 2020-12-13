package HuffmanEncoding;

public class Pair implements Comparable<Pair>{
    private final char x;
    private final int y;
    public Pair(char x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public char getX(){
        return x;
    }
    public String toString(){
        return x + ":" + y;
    }

    public int compareTo(Pair other){
        return java.lang.Integer.compare(this.getY(), other.getY());
    }
}
