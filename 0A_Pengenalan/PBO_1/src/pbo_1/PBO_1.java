package pbo_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PBO_1 {
  private static final int PORT = 12345;
    public static void main(String[] args) {
      String hostName = "localhost";
      
      /*check server*/
      Socket socket = null;
      while(true){
          try{
              socket = new Socket(hostName, PORT);
              break;
          }catch (IOException e){
              System.out.println("Server not running. Starting server ...");
              startServerProcess();
              try{
                  Thread.sleep(1000);
              }catch(InterruptedException ignored) {}
          }
      }
      System.out.println("Connected to Server!");
      
        try (
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){
  
        String userInput;
        while((userInput = stdIn.readLine()) != null){
            if((userInput.equals("EXIT"))){
                break;
            }
            out.println(userInput);
            System.out.println("echo : " + in.readLine());
        }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
  }
    public static void startServerProcess(){
        try {
            // Start server as a new Java process
            String javaHome = System.getProperty("java.home") + "/bin/java";
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder(javaHome, "-cp", classpath, "pbo_1.EchoServer");
            pb.inheritIO(); // optional: server prints go to same console
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
        
  }
  /*done*/
