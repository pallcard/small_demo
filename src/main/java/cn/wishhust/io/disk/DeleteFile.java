package cn.wishhust.io.disk;

import java.io.File;


/**
 *
 * 删除文件，若是文件夹，则递归删除
 *
 */

public class DeleteFile {


    public static boolean deleteFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files.length == 0) {
            return file.delete();
        }
        for (File f : files) {
            if (f.isDirectory()) {
                deleteFile(f.getPath());
            } else if (f.isFile()){
                f.delete();
            }
        }
        return file.delete();
    }


    public static void main(String[] args) {
        String path = "/users/harman/test";
        deleteFile(path);
    }
}
