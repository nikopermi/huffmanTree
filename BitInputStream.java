package HuffmanEncoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BitInputStream {
    private String line;
    private Scanner read;
    private char[] lineInChar;
    private int index = 0;

    public BitInputStream(File input) throws FileNotFoundException {
        read = new Scanner(input);
        line = read.nextLine();
        lineInChar = line.toCharArray();
    }
    public boolean hasNext(){
        return index < lineInChar.length;
    }
    public String getLine(){
        return line;
    }

    public void reset(){
        index = 0;
    }
    public char nextChar(){
        //String s1 = String.format("%8s", Integer.toBinaryString(lineInChar[index] & 0xFF)).replace(' ', '0');
        char ch = lineInChar[index];
        index++;
        return ch;

    }



}
