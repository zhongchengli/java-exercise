package prgmquestions;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class FolderSearch {

    public static void main(String args[]) {
        searchFiles("src/main/resources", "music.txt", true, true);
    }


    private static void searchFiles(String path, String regex, boolean isDisplayDir, boolean isDisplayFile) {
        if (!(isDisplayDir || isDisplayFile)) {
            throw new IllegalArgumentException("isDisplayDir OR isDisplayFile should be true");
        }
        Queue<File> queue = new LinkedList<>();
        File[] files = new File(path).listFiles();

        for (File file : files) {
            // if this is directory
            if (file.isDirectory()) {
                queue.offer(file);
            }
            // if this is file
            else {
                if (file.getName().matches(regex) && isDisplayFile) {
                    System.out.println(file.getName());
                }
            }
            // after this for loop, every object in queue is folder along with sub folder
            // [folder1, folder2, folder2-subfolder1, folder2-subfolder2, folder3, folder3-subfolder1,...]
        }

        while (!queue.isEmpty()) {
            File tempFile = queue.poll();
            if (isDisplayDir) {
                System.out.println(tempFile.getAbsolutePath());
                if (tempFile.getName().matches(regex)) {

                }
            }

            File[] tempFiles = tempFile.listFiles();
            if (tempFiles == null) {
                // This folder is unaccessable, skip it
                continue;
            }
            for (File f : tempFiles) {
                if (f.isDirectory()) {
                    queue.offer(f);
                } else if (f.getName().matches(regex) && isDisplayFile) {
                    System.out.println(f.getName());
//                    break;
                }
            }
        }
    }
}


