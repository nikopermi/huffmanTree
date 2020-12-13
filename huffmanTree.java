package HuffmanEncoding;

import java.io.*;
import java.util.*;

public class huffmanTree{
    private tree overallRoot;
    //private static ArrayList<Pair<Character, Integer>> charList = new ArrayList<>();
    private static Queue<Character> charQueue = new PriorityQueue<>();
    private static Queue<tree> treeQueue = new PriorityQueue<>();
    private int size = 0;
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("D:/Extra/Book Projects/src/HuffmanEncoding/test.txt");
        huffmanTree tes = new huffmanTree(input);
        String attempt = tes.compress();
        System.out.print(attempt);
        System.out.print(tes.decompress(attempt));
    }

    public huffmanTree(File input) throws FileNotFoundException {
        findAllPairs(input);
        while(treeQueue.size() != 1){
            tree temp = new tree();
            temp.left = treeQueue.poll();
            temp.right = treeQueue.poll();
            temp.data = temp.left.data+temp.right.data;
            treeQueue.add(temp);
            size++;
        }
        overallRoot = treeQueue.peek();
    }

    public void findAllPairs(File input) throws FileNotFoundException {
        BitInputStream read = new BitInputStream(input);
        BitInputStream read2 = new BitInputStream(input);
        char temp;
        int count;
        for(int i = 0; i < read.getLine().length(); i++){
            count = 0;
            temp = read.nextChar();
            if(!charQueue.contains(temp)) {
                while (read2.hasNext()) {
                    if (read2.nextChar() == temp) {
                        count++;
                    }
                }
                read2.reset();
                treeQueue.add(new tree(new Pair(temp, count)));
                charQueue.add(temp);
            }
        }
    }

    public String compress() {
        //return compress(overallRoot);

        return compress(overallRoot);
    }

    private String compress(tree root) {
        StringBuilder compressStream = new StringBuilder();
        for(int i = 0; i < size; i++) {
            tree current = root;
            while (current.left != null && current.right != null) {
                if(current.left.pair == null) {
                    current = current.left;
                    compressStream.append(0);
                }
                else if(current.right.pair == null){
                    current = current.right;
                    compressStream.append(1);
                }
            }
        }
        return compressStream.toString();
    }

    public String decompress(String input){
        StringBuilder decompressedAnswer = new StringBuilder();
        int n = input.length();
        for(int i = 1; i < n; i++){
            tree current = overallRoot;
            while(current.left != null && current.right != null) {
                if (input.charAt(i) == '0')
                    current = current.left;
                else
                    current = current.right;
                i++;
            }
            decompressedAnswer.append(current.pair.getX());
        }
        return decompressedAnswer.toString();
    }
}




   // public String decompress(tree root, String stream){

  //  }







    // read file
    // count characters
    // build a binary tree

