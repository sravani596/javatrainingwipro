package com.wipro.Day_20;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioFileCopy {

    public static void main(String[] args) {
        // Define the source and destination file paths
        Path sourcePath = Paths.get("source.txt"); // Replace with your source file path
        Path destinationPath = Paths.get("destination.txt"); // Replace with your destination file path

        // Copy content from source file to destination file
        copyFile(sourcePath, destinationPath);
    }

    // Method to copy content from source file to destination file
    private static void copyFile(Path sourcePath, Path destinationPath) {
        try (FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
             FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            // Create a ByteBuffer with a capacity of 1024 bytes
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read from source channel and write to destination channel
            while (sourceChannel.read(buffer) > 0) {
                // Prepare buffer for writing
                buffer.flip();
                // Write data to destination channel
                destinationChannel.write(buffer);
                // Clear buffer for the next read
                buffer.clear();
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
