import topologies.Topologies;
import topologies.Topology;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Topologies topologies = new Topologies();
        topologies.readJSON("topology.json");
        topologies.readJSON("topology2.json");

        List<Topology> topologyList = topologies.queryTopologies();
        System.out.println(topologyList);
//        topologies.deleteTopology("top1");
//        System.out.println("After Delete");
//        System.out.println(topologyList);

//        topologies.writeJSON("top1", "topology2.json");
    }

}
