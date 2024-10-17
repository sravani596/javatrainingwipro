package com.wipro.Day_20.networking;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {

                    // Read the Operation object from the client
                    Operation operation = (Operation) input.readObject();
                    System.out.println("Received: " + operation);

                    // Perform the operation
                    int result = performOperation(operation);

                    // Send the result back to the client
                    output.writeInt(result);
                    output.flush();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int performOperation(Operation operation) {
        int result = 0;
        switch (operation.getOperation()) {
            case "+":
                result = operation.getNumber1() + operation.getNumber2();
                break;
            case "-":
                result = operation.getNumber1() - operation.getNumber2();
                break;
            case "*":
                result = operation.getNumber1() * operation.getNumber2();
                break;
            case "/":
                if (operation.getNumber2() != 0) {
                    result = operation.getNumber1() / operation.getNumber2();
                } else {
                    throw new ArithmeticException("Division by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation.getOperation());
        }
        return result;
    }
}
