
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
    
    public static void main( String args [] ) throws Exception{
        
            ObjectInputStream objectInputStream = null;
            ObjectOutputStream objectOutputStream = null;
            Socket socket = null;
            
            System.out.println("escriba su mensaje aqui: ");
            Scanner mensaje = new Scanner(System.in);
            String mensajeChat = mensaje.nextLine();
            socket = new Socket("172.16.100.71", 4700);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(mensajeChat);
        
            try {
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                String respuesta = (String) objectInputStream.readObject();
                System.out.println(respuesta);
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
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
