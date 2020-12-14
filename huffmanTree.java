package HuffmanEncoding;

import java.io.*;
import java.util.*;

public class huffmanTree{
    private tree overallRoot;
    private static Queue<Character> uniqueChars = new PriorityQueue<>();
    private static Queue<tree> treeQueue = new PriorityQueue<>();
    private static ArrayList<Pair> charList = new ArrayList<>();

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
            if(!uniqueChars.contains(temp)) {
                while (read2.hasNext()) {
                    if (read2.nextChar() == temp) {
                        count++;
                    }
                }
                read2.reset();
                treeQueue.add(new tree(new Pair(temp, count)));
                uniqueChars.add(temp);
            }
            charList.add(new Pair(temp, count));
        }
    }

    public String compress() {
        StringBuilder compressStream = new StringBuilder();
        for (Pair i : charList) {
            tree current = overallRoot;
            while (current != null) {
                if (i.getY() < current.data) {
                    current = current.left;
                    compressStream.append(0);
                } else if(i.getY() > current.data) {
                    current = current.right;
                    compressStream.append(1);
                }
            }
        }
        return compressStream.toString();
    }

    private String compress(tree root, StringBuilder ans, String a, int index){
        if(charList.get(index).getX() == root.pair.getX()){
            ans.append(a);
            a = "";
        }
        if(index == charList.size()-1)
            return a;
        else if(root.left != null && root.right != null){
            index++;
            root = root.left;

        }
        return compress(root.left, ans, a, index) + compress(root.right, ans, a, index);
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

