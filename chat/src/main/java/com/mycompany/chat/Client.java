/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String host = "localhost";
    private static final int portNumber = 4444;

    private String userName;
    private String serverHost;
    private int serverPort;
    private Scanner userInputScanner;

    public static void main(String[] args){
        String readName = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor coloca tu nombre de usuario:");
        while(readName == null || readName.trim().equals("")){
            // null, empty, whitespace(s) not allowed.
            readName = scan.nextLine();
            if(readName.trim().equals("")){
                System.out.println("Invalid. Please enter again:");
            }
        }
        System.out.println("las opciones son: \n- escriba setSentimiento, para agregar un sentimiento al conejo");
        Client client = new Client(readName, host, portNumber);
        client.startClient(scan);
    }

    private Client(String userName, String host, int portNumber){
        this.userName = userName;
        this.serverHost = host;
        this.serverPort = portNumber;
    }

    private void startClient(Scanner scan){
        try{
            Socket socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000); // waiting for network communicating.
            Conejo miConejo = new Conejo(userName);
            ServerThread serverThread = new ServerThread(socket, miConejo);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while(serverAccessThread.isAlive()){
                System.out.println("por favor escriba su mensaje");
                if(scan.hasNextLine()){
                    String mensaje = scan.nextLine();
                    switch (mensaje){
                        case "setSentimiento" :
                            System.out.println("por favor indique el sentimiento del conejo");
                            miConejo.setSentimiento(scan.nextLine());
                            break;
                        case "setOrejas" :
                            System.out.println("por favor indique las orejas del conejo");
                            miConejo.setOrejas(scan.nextLine());
                            break;
                        case "setPatas":
                            System.out.println("por favor indique las patas del conejo");
                            miConejo.setPatas(scan.nextLine());
                            break;
                        }
                    serverThread.addNextMessage(mensaje);
                }
                // NOTE: scan.hasNextLine waits input (in the other words block this thread's process).
                // NOTE: If you use buffered reader or something else not waiting way,
                // NOTE: I recommends write waiting short time like following.
                // else {
                //    Thread.sleep(200);
                // }
            }
        }catch(IOException ex){
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
        }catch(InterruptedException ex){
            System.out.println("Interrupted");
        }
    }
}
