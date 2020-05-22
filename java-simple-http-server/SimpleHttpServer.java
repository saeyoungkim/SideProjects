import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class SimpleHttpServer {

    private static int getLength(byte[] b){
        int count = 0;
        for(byte b_ : b){
            if(b_ == (byte)0) break;
            ++count;
        }
        return count;
    }

    private static byte[] readFrom(InputStream inputStream, int length) throws IOException {
        byte[] bytes = new byte[length];

        inputStream.read(bytes);
        return bytes;
    }


    public static void main(String[] args) {

        // get port number from args
        int port = 8000;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try(
                // create new server socket
                ServerSocket serverSocket = new ServerSocket(port);
                ){

            while(true) {
                System.out.println("now listen on " + port + " ...");
                // listen...
                socket = serverSocket.accept();
                System.out.println("connected on " + port + " !!!");

                // if connected, set inputstream and outputstream
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                HTTPRequestParser httpRequestParser = new HTTPRequestParser();
                Request request = new Request();
                HTTPRequestHandler httpRequestHandler = new HTTPRequestHandler();

                httpRequestParser.parseFrom(request, inputStream);
                Response response = httpRequestHandler.handleRequest(request);
                response.writeTo(outputStream);

                socket.close();
                inputStream.close();
                outputStream.close();
            }

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
