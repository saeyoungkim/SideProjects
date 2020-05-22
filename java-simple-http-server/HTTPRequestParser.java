import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequestParser {

    public HTTPRequestParser(){ }

    public void parseFrom(Request request, InputStream inputStream) throws IOException, RuntimeException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;

        if((line = bufferedReader.readLine()) == null) throw new IOException("There is no data in buffer.");

        String[] splitLine = line.split(" ");

        request.put("Method", splitLine[0]);
        request.put("Target", splitLine[1]);
        request.put("Protocol", splitLine[2]);

        while((line = bufferedReader.readLine()) != null) {
            if(line.isEmpty()) break;
            splitLine = line.split(": ");
            if(splitLine.length != 2) throw new RuntimeException("socket data is not received completely");
            request.put(splitLine[0], splitLine[1]);
        }
    }
}
