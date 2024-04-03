package ru.sgu;

import java.io.*;
import java.util.zip.*;

public class Task2 {

    private final File workDir;
    private final String targetStr;

    public Task2(String dirName, String target) {
        this.workDir = new File(dirName);
        this.targetStr = target.toLowerCase();
    }

    private boolean isCorrectName(File file) {
        return file.getName().toLowerCase().contains(targetStr);
    }

    private int fileCount = 0;

    private void zipFile(ZipOutputStream zout, File file, String entryName) {
        fileCount++;
        System.out.printf("Выбран файл %d: '%s'%n", fileCount, file.getName());
        try (FileInputStream fis = new FileInputStream(file)) {
            zout.putNextEntry(new ZipEntry(entryName));
            fis.transferTo(zout);
            zout.closeEntry();
        } catch (IOException e) {
            System.out.printf("Не удалось добавить %s в архив%n", file.getName());
        }
    }

    private void zipDirectory(ZipOutputStream zout, File directory, String entryName) {
        System.out.printf("Архивирование '%s'%n", directory.getName());
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                String entry = entryName + file.getName();
                if (file.isDirectory()) {
                    if (isCorrectName(file)) {
                        zipDirectory(zout, file, entry + "/");
                    }
                } else if (isCorrectName(file)) {
                    zipFile(zout, file, entry);
                }
            }
        }
    }

    public void start() {
        if (!workDir.isDirectory()) {
            System.out.printf("Директории `%s` неn или к ней неверно указан путь%n", workDir);
            return;
        }
        try (FileOutputStream fout = new FileOutputStream(workDir.getName() + ".zip");
             ZipOutputStream zout = new ZipOutputStream(fout)) {
            zipDirectory(zout, workDir, "");
        } catch (IOException e) {
            System.out.printf("Не удалось создать архив %s.zip%n", workDir.getName());
            return;
        }
        System.out.println("Архивация выбранных файлов прошла успешно");
    }
}
