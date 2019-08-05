package cn.wishhust.io.disk;

import java.io.*;

/**
 *
 * 需求：因为项目中加入gradle后，项目结构发生变化，原来的包为main.java.cn.wishhust, 现在的包为cn.wishhust,
 * 故需要将文件中的 打包的 package main.java.cn.wishhust 改为 package cn.wishhust
 *
 */

public class FileManage {

    public static void getFile(String path) {
        final File file = new File(path);
        final File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                handle(f);
            } else if (f.isDirectory()) {
                getFile(f.getPath());
            }
        }
    }

    public static void handle(File file) {
        try {
            final FileReader read = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(read);

            String line;
            StringBuilder sbAll = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {

                if (line.startsWith("package main.java")) {
                    StringBuilder sb = new StringBuilder(line);
                    int start = sb.indexOf("main");
                    sb.delete(start, start+10);
                    sbAll.append(sb);
                } else {
                    sbAll.append(line);
                    sbAll.append("\n");
                }

                System.out.println(line);
            }
            bufferedReader.close();

            final FileWriter write = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(write);

            bufferedWriter.write(sbAll.toString());

            bufferedWriter.close();
            System.out.println("finsh "+file.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
//        String path = "D:\\workspace2\\small_demo\\src\\main\\java\\cn\\wishhust";
        String path = "/users/harman/IdeaProjects/small_demo/src/main/java/cn/wishhust";
        getFile(path);
    }
}
