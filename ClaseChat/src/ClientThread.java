
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread extends ChatServer implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientThread> lista;

    public ClientThread(Socket socket, ArrayList<ClientThread> listClients) {
        this.socket = socket;
        this.lista = listClients;
    }
    
    @Override
    public void run() {
        try{
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(!socket.isClosed()){
                String input = in.readLine();
                if(input!= null){
                    for(ClientThread client: lista){
                        client.getOut().write(input);
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public ArrayList<ClientThread> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ClientThread> lista) {
        this.lista = lista;
    }

 
    
    
    
    
    
}
