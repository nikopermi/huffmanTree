package HuffmanEncoding;

import java.util.Comparator;

public class pairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        return java.lang.Integer.compare(o1.getY(), o2.getY());
    }
}
