import java.net.Socket;
import java.nio.file.Path;
import java.net.ServerSocket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;

public class FtpServer{
    private static final int FTP_COMMAND_PORT = 21;
    private static int FTP_DATA_PORT = 20;
    public static final String CRLF = "\r\n";
    private static Path currPath = Paths.get("").toAbsolutePath();
    public static void main(String[] args){        
        try(
            ServerSocket serverSocket = new ServerSocket(FTP_COMMAND_PORT);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
        ){
            boolean conneceted = true;
            while(conneceted){
                // read command from client
                String line = bufferedReader.readLine();
                // process by string
                conneceted = processByCommand(line, outputStream);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean processByCommand(String command, OutputStream outputStream) throws IOException{
        if(command.equals("quit")) return false;

        StringBuilder stringbuilder = new StringBuilder();

        if(command.equals("ls")){
            stringbuilder.append("."+CRLF);
            stringbuilder.append(".."+CRLF);

            File[] files = currPath.toFile().listFiles();
            for(File file: files){
                stringbuilder.append(file.getName()+CRLF);
            }

            stringbuilder.append(ReplyCode.COMMAND_OK.toString());

            outputStream.write(stringbuilder.toString().getBytes());
            outputStream.flush();
        }
        else if(command.equals("cdup")){
            currPath = currPath.getParent();
            stringbuilder.append(ReplyCode.COMMAND_OK.toString());

            outputStream.write(stringbuilder.toString().getBytes());
            outputStream.flush();
        }
        else {
            stringbuilder.append(ReplyCode.COMMAND_NOT_IMPLEMENTED.toString());

            outputStream.write(stringbuilder.toString().getBytes());
            outputStream.flush();
        }

        return true;
    }
}