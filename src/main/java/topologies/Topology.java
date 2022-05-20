package topologies;

import components.Component;

import java.util.ArrayList;
import java.util.List;

public class Topology {

    private String id;
    private List<Component> components = new ArrayList<>();

    public Topology(String id, List<Component> components) {
        this.id = id;
        this.components = components;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        String topology = "Topology ID: " + this.id + "\n";
        for (Object component : this.components) {
            topology += component.toString() + "\n";
        }
        return topology;
    }
}
