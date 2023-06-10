import javafx.scene.layout.VBox;
import model.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GroupChatServer {
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        final int port = 6000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket localsocket;

            while(true){
                System.out.println("Waiting for client");
                localsocket = serverSocket.accept();

                //connect wena clientge port number ekai ip address ekai gannawa me deken
                System.out.print("port " + localsocket.getPort());
                System.out.println("IP " + localsocket.getInetAddress());

                System.out.println("Client connected");
                Client clientThread = new Client(localsocket, clients);
                clients.add(clientThread);
                clientThread.start();
            }

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}