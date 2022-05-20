import components.Component;
import components.Resistor;
import topologies.Topologies;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Topologies topologies = new Topologies();
        topologies.readJSON("topology.json");
        System.out.println(topologies);
    }

}
