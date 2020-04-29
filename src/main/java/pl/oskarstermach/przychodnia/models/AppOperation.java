package pl.oskarstermach.przychodnia.models;

import java.util.HashMap;
import java.util.Map;

public enum AppOperation {
    ADD("A"), UPDATE("U"), DELETE("D"), TOP_MEDICINES("T"), GET("G"), INVALID("I");

    private final String KEY;

    private static final Map<String, AppOperation> operationsMap = new HashMap<>();

    static
    {
        for(AppOperation env : AppOperation.values())
        {
            operationsMap.put(env.KEY, env);
        }
    }

    public static AppOperation get(String key)
    {
        return operationsMap.get(key);
    }

    AppOperation(String KEY) {
        this.KEY = KEY;
    }


}
