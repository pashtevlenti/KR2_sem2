package org.example;

import java.io.*;
import java.nio.ByteBuffer;

public class ThreadRead extends Thread{

    private String fileString;
    private int sz;

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getEven() {
        return even;
    }

    public byte[] getBytes() {
        return bytes;
    }

    private int even;
    private int part;
    private byte[] bytes;
    public ThreadRead(String fileString) {
        this.fileString = fileString;
    }

    public int getPart() {
        return part;
    }

    @Override
    public void run(){
        try (DataInputStream file = new DataInputStream(new FileInputStream(new File(fileString)))){
            sz = file.readInt();

            bytes = file.readNBytes(sz);

            even = file.readInt();
            part = file.readInt();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
