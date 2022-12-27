package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;


    public class Server {
        private static ArrayList<Client> users = new ArrayList<Client>();
        private static ArrayList<Client> admins = new ArrayList<Client>();

        public static void main(String[] args) throws IOException {
            try (ServerSocket socket = new ServerSocket(3001)) {
                while (true) {
                    System.out.println(Instant.now() + " Waiting for client...");
                    Socket clientSocket = socket.accept();
                    Client clientManager = new Client(clientSocket); 
                    clientManager.start();
                }
            }
        }

        public static void addUserManager(Client clientManager){
            users.add(clientManager);
        }
        public static void addAdminManager(Client adminManager){
            admins.add(adminManager);
        }
    }


