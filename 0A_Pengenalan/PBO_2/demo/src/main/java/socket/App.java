package socket;

import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int PORT = 1245;
    public static void main( String[] args )
    {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println( "Server started on port " + PORT );
    }
}
