
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import objetos.Conejo;

public class Cliente{
    
    public static void main( String args [] ) throws Exception{
        
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        
        Socket socket = null;
        
        try {
            socket = new Socket("127.0.0.1", 4500);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Conejo miConejo = new Conejo("Juan Pablo");
            objectOutputStream.writeObject(miConejo);
            
            String respuesta = (String) objectInputStream.readObject();
            System.out.println("respuesta: " + respuesta);
            
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
                System.out.println("Conexion cerrada o terminada");
        }
    }
    
}
