import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class SimpleHttpServer {

    public static void main(String[] args) {

        // get port number from args
        int port = Integer.parseInt(args[0]);
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try(
                // create new server socket
                ServerSocket serverSocket = new ServerSocket(port);
                ){
            System.out.println("now listen on " + port + " ...");
            // listen...
            socket = serverSocket.accept();
            System.out.println("connected on " + port + " !!!");

            // if connected, set inputstream and outputstream
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            byte[] bytes = new byte[1024];

            inputStream.read(bytes);

            // if conneteced, write hello world
            outputStream.write("hello world".getBytes());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                socket.close();
                inputStream.close();
                outputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }


    }

}