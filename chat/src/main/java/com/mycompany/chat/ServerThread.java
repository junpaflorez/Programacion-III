package com.mycompany.chat;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerThread implements Runnable {
    private Socket socket;
    private Conejo miConejo;
    private boolean isAlived;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;

    public ServerThread(Socket socket, Conejo conejo){
        this.socket = socket;
        this.miConejo = conejo;
        messagesToSend = new LinkedList<String>();
    }

    public void addNextMessage(String message){
        synchronized (messagesToSend){
            hasMessages = true;
            messagesToSend.push(message);
        }
    }

    @Override
    public void run(){
        System.out.println("Welcome :" + miConejo.getNombre());

        System.out.println("Local Port :" + socket.getLocalPort());
        System.out.println("Server = " + socket.getRemoteSocketAddress() + ":" + socket.getPort());

        try{
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), false);
            InputStream serverInStream = socket.getInputStream();
            Scanner serverIn = new Scanner(serverInStream);
            // BufferedReader userBr = new BufferedReader(new InputStreamReader(userInStream));
            // Scanner userIn = new Scanner(userInStream);

            while(!socket.isClosed()){
                if(serverInStream.available() > 0){
                    if(serverIn.hasNextLine()){
                        System.out.println(serverIn.nextLine());
                    }
                }
                if(hasMessages){
                    String nextSend = "";
                    synchronized(messagesToSend){
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty();
                    }
                    serverOut.println("Nombre de usuario: " + miConejo.getNombre() + "\n" + miConejo.getOrejas() + "\n" + miConejo.getSentimiento() + "\n" + miConejo.getPatas() +  "\n"+ "mensaje:> " + nextSend);
                    serverOut.flush();
                }
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
