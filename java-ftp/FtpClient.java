import java.net.Socket;
import java.net.ServerSocket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FtpClient{
    private static final int FTP_COMMAND_PORT = 21;
    private static String HOST = "localhost";
    private static final String CRLF = "\r\n";
    public static void main(String[] args){     
        if(args.length == 1){
            HOST = args[0];
        }   
        try(
            Socket socket = new Socket(HOST, FTP_COMMAND_PORT);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        ){
            boolean connected = true;
            while(connected){
                System.out.print("ftp> ");
                String line = scanner.readLine();
                outputStream.write((line + CRLF).getBytes());
                outputStream.flush();
                connected = printAllBytes(inputStream);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean printAllBytes(InputStream inputStream) throws IOException {
        byte[] bbuf = new byte[65536];
        int readLength = 0;
        while(true){
            readLength = inputStream.read(bbuf, 0, bbuf.length);
            for(int idx = 0; idx < readLength; ++idx){
                System.out.print((char)bbuf[idx]);
            }
            if(readLength == -1) return false;
            if(readLength < bbuf.length) break;
        }
        return true;
    }
}