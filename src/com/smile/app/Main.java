package com.smile.app;

import java.io.File;

public class Main {

    private static int fileNum = 0;
    private static int dirNum = 0;

    public static void moveFile(String orgDir,String tarDir){
        File file = new File(orgDir);
        if(file.exists()){
            File[] files = file.listFiles();
            if(files.length>0) {
                System.out.println(orgDir+"目录下文件数："+files.length);
                for (int i = 0; i < files.length; i++) {
                    File tempFile = files[i];
                    if(tempFile.isDirectory()){
                        dirNum++;
                        moveFile(orgDir+"\\"+tempFile.getName(),tarDir);
                    }else{
                        fileNum++;
                        File newFile = new File(tarDir+"\\"+tempFile.getName());
                        System.out.println(orgDir+"\\"+tempFile.getName());
                        tempFile.renameTo(newFile);
                    }
                }
            }else{
                System.out.println(orgDir+"目录下没有文件");
            }
        }else{
            System.out.println(orgDir+"目录下没有文件");
        }
    }
    public static void main(String[] args) {
        String orgDir = "D:\\Ebook\\编程书籍";
        String tarDIr = "D:\\Ebook\\test";
//        String orgDir = args[0];
//        String tarDIr = args[1];

        moveFile(orgDir,tarDIr);
        System.out.println("读取到文件数："+fileNum);
        System.out.println("读取到文件夹数："+dirNum);
    }
}
