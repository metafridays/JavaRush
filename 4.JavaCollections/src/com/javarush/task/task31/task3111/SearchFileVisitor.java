package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<Path>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String stringContent = new String(content);

        boolean containsName = false;
        if (partOfName == null || file.getFileName().toString().contains(partOfName)) containsName = true;
        boolean containsContent = false;
        if (partOfContent == null || stringContent.contains(partOfContent)) containsContent = true;
        boolean haveMinSize = false;
        if (minSize == -1 || content.length > minSize) haveMinSize = true;
        boolean haveMaxSize = false;
        if (maxSize == -1 || content.length < maxSize) haveMaxSize = true;

        if (containsName && containsContent && haveMinSize && haveMaxSize) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return this.foundFiles;
    }
}
