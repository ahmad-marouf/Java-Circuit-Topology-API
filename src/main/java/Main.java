import components.Component;
import topologies.Topologies;
import topologies.Topology;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Topologies topologies = new Topologies();

        // Read JSON
        Topology top1 = topologies.readJSON("topology.json");
        Topology top2 = topologies.readJSON("topology2.json");

        // Write JSON
        topologies.writeJSON("top1", "topologyTest.json");

        // Query Topologies
        System.out.println("Query Topologies");
        List<Topology> topologyList = topologies.queryTopologies();
        System.out.println(topologyList);

        // Delete Topology
        topologies.deleteTopology("top2");
        System.out.println("After Delete");
        System.out.println(topologyList);

         // Query Devices
        System.out.println("Query Devices");
        List<Component> deviceList = topologies.queryDevices("top1");
        System.out.println(deviceList);

        // Query Devices Given Netlist Node
        System.out.println("Query Devices Given Netlist Node");
        List<Component> deviceList2 = topologies.queryDevicesWithNetlistNode("top1", "vss");
        System.out.println(deviceList2);




    }

}
