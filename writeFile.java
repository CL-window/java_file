package com.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <p>Description: 读写文件 </p>
 * Created by slack on 2016/9/6 13:18 .
 */
public class writeFile {

    static int count = 1000;
    static long startTime;
    static String filePath = "D:/writeFile.txt";
    static String msg = "hello word...\\r\\n";

//    OutputStreamWriter outputStreamWriter = null;
//    InputStreamReader inputStreamReader = null;

    public static void main(String[] args){
        startTime = System.currentTimeMillis();
//        writeFileWriter(); // 12 - 14 ms
//        readFileReader();
//        writeFileOutputStream(); // 27 - 29 ms
//        readFileInputStream();
//        writeBufferedOutputStream(); // 39 ms
//        readBufferedInputStream();

        writerBufferWriter();
        readBufferReader();
        System.out.println("time:" + (System.currentTimeMillis() - startTime ) + "ms" );
    }

    public static void writeFileWriter(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath); //  ,false);
            for(int i = 0; i < count ; i ++){
                fileWriter.write(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeFileOutputStream(){
        FileOutputStream out = null;
        try {
            out = new FileOutputStream((filePath));
            for(int i = 0; i < count ; i ++){
                out.write(msg.getBytes());
            }

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeBufferedOutputStream(){
        FileOutputStream out = null;
        BufferedOutputStream buff = null;
        try {
            out = new FileOutputStream(filePath);
            buff = new BufferedOutputStream(out);
            for(int i = 0; i < count ; i ++){
                buff.write(msg.getBytes());
            }
            buff.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buff.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //可以换行
    public static void writerBufferWriter(){
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < count ; i ++){
                bufferedWriter.write(msg);
                bufferedWriter.newLine();// 换行
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void readFileReader(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            int ch = 0;
            while ( (ch = fileReader.read()) != -1 ){
                System.out.println((char)ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void readFileInputStream(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            int ch = 0;
            byte b[] = new byte[1024];
            while ((ch = fileInputStream.read(b)) != -1){
                System.out.println((char)ch + "," + new String(b,0,ch));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readBufferedInputStream(){

        BufferedInputStream buffer = null;
        try {
            buffer = new BufferedInputStream(new FileInputStream(filePath));
            int ch = 0;
            byte b[] = new byte[1024];
            while ((ch = buffer.read(b)) != -1){
                System.out.println(new String(b,0,ch));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void readBufferReader(){
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null){
                System.out.println(bufferedReader.readLine());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
