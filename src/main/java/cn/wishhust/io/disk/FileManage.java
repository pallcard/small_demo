package cn.wishhust.io.disk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileManage {

    public static void getFile(String path) {
        final File file = new File(path);
        final File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else if (f.isDirectory()) {
                getFile(f.getPath());
            }
        }
    }

    public static void handle(File file) {
        try {
            final FileReader read = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(read);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
            StringBuilder sb = new StringBuilder();
//            while (sb = bufferedReader.readLine())
            for (int i = 0; i < 3; i++) {
                sb = new
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        String path = "D:\\workspace2\\small_demo\\src\\main\\java\\cn\\wishhust";
        getFile(path);
    }
}
