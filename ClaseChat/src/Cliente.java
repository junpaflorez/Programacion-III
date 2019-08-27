
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    
    public static void main(String[] args){
        Socket socket = null;
        int portNumber = 4444;
        System.out.println("Escribe tu nombre de usuario");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close();
        try{
            socket = new Socket("172.16.100.51",portNumber);
            Thread server = new Thread(new ServerThread(socket,name));
            server.start();
        }
        catch(IOException e){
            System.err.println("fallo en la conexion");
            e.printStackTrace();
        }
    }
    
}
