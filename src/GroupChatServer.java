import javafx.scene.layout.VBox;
import model.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GroupChatServer {
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            Socket accept;

            while (true){
                System.out.println("Waiting for client");
                accept = serverSocket.accept();
                System.out.println("Client connected");
                Client clientThread = new Client(accept, clients);
                clients.add(clientThread);
                clientThread.start();

            }

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

//        try {
//            ServerSocket serverSocket = new ServerSocket(6000);
//            Socket accept;
//            while (true) {
//                System.out.println("Waiting for Client ...");
//                accept = serverSocket.accept();
//                System.out.println("Client Connected");
//                Client clientThread = new Client(accept, clients);
//                clients.add(clientThread);
//                clientThread.start();
//            }
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

    }
}