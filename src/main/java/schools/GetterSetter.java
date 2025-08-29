package schools;

import java.util.HashMap;
import java.util.Map;

public class GetterSetter implements GetSet{

    Map<String, String> map = new HashMap<>();

    @Override
    public String set(String a, String b){
        return map.put(a, b);
    }

    @Override
    public String get(String a){
        return map.getOrDefault(a, "NONE");
    }

}
