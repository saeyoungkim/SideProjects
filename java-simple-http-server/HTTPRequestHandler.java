import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HTTPRequestHandler {

    public Response handleRequest(Request request) throws IOException{
        // handle request by target
        Path path = Paths.get(request.get("Target"));

        if(!Files.exists(path)){
            return new Response(ResponseResult.NOT_FOUND, request , Files.readAllBytes(Paths.get("public/404.html")));
        }
        else {
            return new Response(ResponseResult.OK, request, Files.readAllBytes(Paths.get("public/index.html")));
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {

    }

}
