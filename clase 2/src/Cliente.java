
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import objetos.Conejo;

public class Cliente{
    
    public static void main( String args [] ) throws Exception{
        
            ObjectInputStream objectInputStream = null;
            ObjectOutputStream objectOutputStream = null;

            Socket socket = null;
        while(true){
            try {
                
                System.out.println("escriba su mensaje aqui: ");
                Scanner mensaje = new Scanner(System.in);
                String mensajeChat = mensaje.nextLine();
                
                socket = new Socket("127.0.0.1", 4500);
                //socket = new Socket("172.16.10.x", 4500);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Conejo miConejo = new Conejo("Juan Pablo");
                miConejo.setMensaje(mensajeChat);
                objectOutputStream.writeObject(miConejo);
                
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
    
}
