
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    public static void main (String args []) throws Exception{
        
        //objeto de escucha
        ObjectInputStream objectInputStream = null;
        //objeto de envio de informacion
        ObjectOutputStream objectOutputStream = null;
        //socket
        Socket socket = null;
        //socket con puerto de escucha
        ServerSocket serverSocket = new ServerSocket(4500);
        int i = 0;
        while(true) {
            try{
                //escucha el puerto 5432
                socket = serverSocket.accept();
                //imprime la ip del mensaje que fue recibido en el puerto
                System.out.println("mensaje numero: " + i);
                System.out.println("\nSe conectaron desde la IP: " + socket.getInetAddress()); 
                //obtencion del mensaje
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                //salida del mensaje
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                //desempaquetado de informacion para la obtencion de datos del mensaje
                String nombre = (String) objectInputStream.readObject();
                System.out.println("mensaje de: " + nombre);
                //saludo al cliete, con su nombre y hora de recibido en el servidor
                String saludo = "Hola " + nombre + " tiempo: " + System.currentTimeMillis();

                //envio del mensaje
                objectOutputStream.writeObject(saludo);
                //confirmacion de envio de mensaje en consola
                System.out.println("enviando mensaje al cliente");
                i++;
            }
            catch (Exception ex){
                ex.printStackTrace();    
            }
            finally{
                if(objectOutputStream != null){
                    objectOutputStream.close();
                }
                if(objectInputStream != null){
                    objectInputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
                System.out.println("Conexion cerrada o terminada");
            }
            
        }
        
    }
    
}
