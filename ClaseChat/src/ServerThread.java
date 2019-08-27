
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;
    private String name;
    private BufferedReader serverIn;
    private BufferedReader userIn;
    private PrintWriter out;

    public ServerThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedReader getServerIn() {
        return serverIn;
    }

    public void setServerIn(BufferedReader serverIn) {
        this.serverIn = serverIn;
    }

    public BufferedReader getUserIn() {
        return userIn;
    }

    public void setUserIn(BufferedReader userIn) {
        this.userIn = userIn;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
    
 
    
    @Override
    public void run() {
        try{
            out = new PrintWriter(socket.getOutputStream(),true);
            serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userIn = new BufferedReader(new InputStreamReader(System.in));
            
            while(!socket.isClosed()){
                if(serverIn.ready()){
                    String input = serverIn.readLine();
                    if(input!=null){
                        System.out.println(input);
                    }
                }
                if(userIn.ready()){
                    out.println(name + ">" + userIn.readLine());
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
