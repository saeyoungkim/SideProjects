import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Response {

    private final Request request;
    private final ResponseResult responseResult;
    private final byte[] bytes;

    public Response(ResponseResult responseResult, Request request, byte[] bytes){
        this.responseResult = responseResult;
        this.request = request;
        this.bytes = bytes;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write((this.request.get("Protocol") + " " + this.responseResult.getStatusCode() + " " + this.responseResult.getStatus() + "\r\n").getBytes());
        outputStream.write("Content-Type: text/html\r\n".getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write(this.bytes);
    }

    private String getDateFromHttpFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM YYYY HH:mm:ss z", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(date);
    }
}
