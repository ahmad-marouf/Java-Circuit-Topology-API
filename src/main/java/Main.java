import topologies.Topologies;
import topologies.Topology;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Topologies topologies = new Topologies();
        topologies.readJSON("topology.json");

        List<Topology> topologyList = topologies.queryTopologies();
        System.out.println(topologies);
        topologies.deleteTopology("top1");
        System.out.println("After Delete");
        System.out.println(topologies);
    }

}
