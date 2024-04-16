package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    String filepath;
    Map<String, String> init;

    FileKV(String filepath, Map<String, String> map) {
        this.filepath = filepath;
        this.init = new HashMap<>(map);

        String json = Utils.serialize(this.init);
        Utils.writeFile(this.filepath, json);
    }

    @Override
    public void set(String key, String value) {
        String textContent = Utils.readFile(this.filepath);
        Map<String, String> datamap = Utils.unserialize(textContent);
        datamap.put(key, value);
        String json = Utils.serialize(datamap);
        Utils.writeFile(this.filepath, json);
    }

    @Override
    public void unset(String key) {
        String textContent = Utils.readFile(this.filepath);
        Map<String, String> datamap = Utils.unserialize(textContent);
        datamap.remove(key);
        String json = Utils.serialize(datamap);
        Utils.writeFile(this.filepath, json);
    }

    @Override
    public String get(String key, String defaultValue) {
        String textContent = Utils.readFile(filepath);
        Map<String, String> datamap = Utils.unserialize(textContent);
        return datamap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String textContent = Utils.readFile(filepath);
        Map<String, String> datamap = Utils.unserialize(textContent);
        return datamap;
    }
}
// END
