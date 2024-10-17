package com.wipro.Day_20.networking;
import java.io.*;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            // Create an Operation object
            Operation operation = new Operation(2, 2, "+");

            // Send the Operation object to the server
            output.writeObject(operation);
            output.flush();

            // Receive the result from the server
            int result = input.readInt();
            System.out.println("Result: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
