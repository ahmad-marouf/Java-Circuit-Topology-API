package topologies;

import components.Component;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> components = new ArrayList<>();

    public Topology(String id, List<Component> components) { this.id = id; this.components = components; }

    public JSONArray formatJSON() {
        JSONArray componentsArray = new JSONArray();
        for (Object component : this.components) {
            Component comp = (Component) component;
            JSONObject compObj = comp.formatJSON();
            componentsArray.add(compObj);
        }
        return componentsArray;
    }


    public String getId() { return id; }
    public List<Component> getDeviceList() { return this.components; }


    @Override
    public String toString() {
        String topology = "Topology ID: " + this.id + "\n";
        for (Object component : this.components) {
            topology += component.toString() + "\n";
        }
        return topology;
    }

}
