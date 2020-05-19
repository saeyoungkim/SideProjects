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

    private static String getDateFromHttpFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM YYYY HH:mm:ss z", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }

    private static void writeTo(OutputStream outputStream, byte[] b) throws IOException {
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        // Date
//        outputStream.write("Date: ".getBytes());
//        outputStream.write(getDateFromHttpFormat(new Date()).getBytes());
//        outputStream.write("\r\n".getBytes());
        // Content Type
        outputStream.write("Content-Type: ".getBytes());
        outputStream.write("text/html;charset=utf-8".getBytes());
        outputStream.write("\r\n".getBytes());
        // Content length
        outputStream.write("Content-Length: ".getBytes());
        outputStream.write(Integer.toString(getLength(b)).getBytes());
        outputStream.write("\r\n".getBytes());
        // Connection
        outputStream.write("Connection: ".getBytes());
        outputStream.write("Close".getBytes());
        outputStream.write("\r\n".getBytes());
        // CRLF
        outputStream.write("\r\n".getBytes());
        // body
        outputStream.write(b);
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

                byte[] b = readFrom(inputStream,1024);

                writeTo(outputStream , Files.readAllBytes(Paths.get("public/index.html")));

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
