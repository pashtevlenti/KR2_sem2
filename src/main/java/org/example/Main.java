package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ThreadRead> threads = new ArrayList<>();
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\1abd143c-59ad-4e5f-80f5-3cce23213c8d"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\7d7b85c2-77d3-485a-aa57-74a2f03848fb"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\46fee1c6-c9ee-4642-8fda-3e7dd69d4bcd"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\131c71a8-0179-4e54-a436-035c7a9450b8"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\3639bf74-31a3-4736-abea-182785169798"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\501012be-9767-49b9-b5fc-fcf56d05758d"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\c60f7225-4080-4480-a842-17b88eb35579"));
        threads.add(new ThreadRead("C:\\Users\\79195\\Desktop\\IdeaProjects\\KR2_sem2\\src\\main\\java\\org\\example\\v23\\ac78e569-b3bd-442f-9614-9983ccf32b98"));

        for (ThreadRead thread : threads){
            thread.start();
        }
        for (ThreadRead thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        threads.sort(Comparator.comparingInt(t -> t.getPart()));

        writer(threads,"C:\\\\Users\\\\79195\\\\Desktop\\\\IdeaProjects\\\\KR2_sem2\\\\src\\\\main\\\\java\\\\org\\\\example\\\\v23.png");

        for (ThreadRead thread : threads){
            byte count = check(thread.getBytes());
            System.out.println("У " +thread.getPart() + " части картинки контрольное число четности " + (count == (thread.getEven())));
        }

    }




    public static void writer(List<ThreadRead> threads, String path){
        try (DataOutputStream fileWrite = new DataOutputStream(new FileOutputStream(new File(path)))) {
            for (ThreadRead thread : threads){
                fileWrite.write(thread.getBytes());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte check(byte[] a){
        int count = 0;
        for (int i = 0; i < a.length; ++i){
            String str = Integer.toBinaryString(a[i]);
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == '1') count++;
            }
        }
        return (byte) (count % 2);
    }
}
