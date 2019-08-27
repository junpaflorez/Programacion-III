
import com.sun.xml.internal.ws.handler.ClientSOAPHandlerTube;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    
    public static void main(String [] args){
        ServerSocket serverSocket = null;
        int portNumber = 4444;
        try{
            serverSocket = new ServerSocket(portNumber);
            acceptClients(serverSocket);
        } catch (IOException e) {
            System.err.println("No se pudo escuchar el puerto: " + portNumber);
            System.exit(1);
        }
    }
    
    public static void acceptClients(ServerSocket serverSocket){
        ArrayList<ClientThread> listClients  = new ArrayList<>();
        while(true){
            try{
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket, listClients);
                Thread thread = new Thread(client);
                thread.start();
                listClients.add(client);
            }
            catch(IOException e){
                System.out.println("No se permitio el ingreso");
            }
        }
    }

    
    
}
