import java.util.HashMap;
import java.util.Map;

public class Request {
    private final Map<String, String> requestInfo;

    public Request(){
        this.requestInfo = new HashMap<>();
    }

    public void put(String key, String value){
        this.requestInfo.put(key, value);
    }

    public String get(String key){
        return this.requestInfo.get(key);
    }
}
