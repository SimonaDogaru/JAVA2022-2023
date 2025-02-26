package documentsManagementSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String title, String location, Map<String, Object> tags) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = tags;
    }

    public Document(){

    }

    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}

