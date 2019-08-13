import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import objetos.Conejo;
import objetos.Familia;

public class Servidor{
    
    public static void main (String args []) throws Exception{
        //objeto de escucha
        ObjectInputStream objectInputStream = null;
        //objeto de envio de informacion
        ObjectOutputStream objectOutputStream = null;
        //socket
        Socket socket = null;
        //socket con puerto de escucha
        ServerSocket serverSocket = new ServerSocket(4500);
        while(true) {
            try{
                //escucha el puerto 4500
                socket = serverSocket.accept();
                //imprime la ip del mensaje que fue recibido en el puerto
                //System.out.println("\nSe conectaron desde la IP: " + socket.getInetAddress()); 
                //obtencion del mensaje
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                //salida del mensaje
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                //desempaquetado de informacion para la obtencion de datos del mensaje
                Conejo conejo = (Conejo) objectInputStream.readObject();
                System.out.println( conejo.getOrejas() +  "\tnombre:" + 
                        conejo.getNombre() + "\n" + conejo.getSentimiento() +
                        "\n" + conejo.getPatas() + "\n" + "mensaje: " + 
                        conejo.getMensaje());
                //saludo al cliete, con su nombre y hora de recibido en el servidor
                String saludo = conejo.getOrejas() +  "/tnombre:" + 
                        conejo.getNombre() + "\n" + conejo.getSentimiento() +
                        "\n" + conejo.getPatas() + "\n" + "mensaje: " + 
                        conejo.getMensaje();

                //envio del mensaje
                objectOutputStream.writeObject(saludo);
                //confirmacion de envio de mensaje en consola
                //System.out.println("enviando mensaje al cliente");
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
                //System.out.println("Conexion cerrada o terminada");
            }
            
        }
        
    }
    
    public static String buscarPadreMadre(String nombreConejo, ArrayList<Familia> vecindad){
        Conejo padre = new Conejo("padre");
        Conejo madre = new Conejo("madre");
        for(Familia familia : vecindad){
            if(familia.getPadre() != null){
                padre = familia.getPadre();
                if(padre.getNombre().matches(nombreConejo)){
                    return "El conejo es un padre de la familia: " + familia.getNombre();
                }
            }
            if(familia.getMadre() != null){
                madre = familia.getMadre();
                if(madre.getNombre().matches(nombreConejo)){
                    return "El conejo es una madre de la familia: " + familia.getNombre();
                }
            }
        }
        return "El conejo no es ni una madre ni un padre";
    }
    
}
