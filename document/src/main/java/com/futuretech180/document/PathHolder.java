package com.futuretech180.document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathHolder {
    public static void main(String[] args) throws IOException {
        PathHolder p = new PathHolder("user1");
        System.out.println(p.isFolderExisted("user1"));
        System.out.println(p.isFileExisted("sample.json"));
        System.out.println(p.isFileExisted("sample1.json"));
        p.createUserFolder("user1");
    }
    String username;
    PathHolder(String folderName) {
        username = folderName;
    }

    public void createUserFolder(String folderName) throws IOException {
        username = folderName;
        if(!isFolderExisted(folderName))
        {
            Path path = Paths.get(getPath());
            Files.createDirectories(path);
        }
    }

    public String getPath()
    {
        return "/Users/stephenhuang/IdeaProjects/cs180-23-futuretech" +
                "/Users/" + username + "/" ;
    }

    public boolean isFolderExisted(String folderName) throws IOException {
        username = folderName;
//        System.out.println(getPath());
        File file = new File(getPath());
        return file.isDirectory();
    }

    public boolean isFileExisted(String fileName) throws IOException {
        File file = new File(getPath() + fileName);
        return file.exists();
    }
}
