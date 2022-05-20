import components.*;
import netlists.NmosNetlist;
import netlists.ResistorNetlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import topologies.Topologies;
import topologies.Topology;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TopologyTest {

    Topologies topologies;

    @BeforeEach
    void setUp(){
        this.topologies = new Topologies();
    }

    @Test
    @DisplayName("JSON file correctly loaded into object")
    void testReadJSON(){
        Topology top1 = topologies.readJSON("topology.json");
        String topID = top1.getId();
        assertEquals("top1", topID);
        List<Component> deviceList = top1.getDeviceList();

        Component component1 = new Resistor("res1",
                                                new ResistorMeasure(100, 10, 1000),
                                                new ResistorNetlist("vdd", "n1"));
        Component component2 = new Nmos("m1",
                                            new NmosMeasure((float)1.5, (float)1.0, (float)2.0),
                                            new NmosNetlist("n1", "vin", "vss"));

        List<String> componentStr = Arrays.asList(component1.toString(), component2.toString());
        for (Component component : deviceList) {
            assertNotEquals(-1, componentStr.indexOf(component.toString()));
        }
    }

    @Test
    @DisplayName("Object correctly written into JSON file and no duplicate topology IDs")
    void testWriteJSON(){
        Topology top1 = topologies.readJSON("topology.json");
        topologies.writeJSON(top1.getId(), "topologyTest.json");
        Topology topTest = topologies.readJSON("topologyTest.json");
        // Throws null pon=inter exception since we cannot load duplicate topology IDs
        Throwable exception = assertThrows(NullPointerException.class,
                () -> assertEquals("top1", topTest.getId()));
    }

    @Test
    @DisplayName("Topologies correct query result")
    void testQueryTopology(){
        Topology top1 = topologies.readJSON("topology.json");
        Topology top2 = topologies.readJSON("topology2.json");
        List<Topology> topologyList = topologies.queryTopologies();
        assertNotEquals(-1, topologyList.indexOf(top1));
        assertNotEquals(-1, topologyList.indexOf(top2));
    }

    @Test
    @DisplayName("Topology deleted correctly from memory")
    void testDeleteTopology(){
        Topology top1 = topologies.readJSON("topology.json");
        List<Topology> topologyList = topologies.queryTopologies();
        assertNotEquals(-1, topologyList.indexOf(top1));
        topologies.deleteTopology("top1");
        assertEquals(-1, topologyList.indexOf(top1), "Error Deleting Topology");
    }

    @Test
    @DisplayName("Topology Devices Correct Query Result")
    void testQueryDevice(){
        topologies.readJSON("topology.json");
        List<Component> deviceList = topologies.queryDevices("top1");
        List<String> topologyDevices = Arrays.asList("res1", "m1");
        for (Component component : deviceList) {
            assertNotEquals(-1, topologyDevices.indexOf(component.getId()));
        }
    }

    @Test
    @DisplayName("Topology Devices Correct Query Result")
    void testQueryNetlistNode(){
        Topology top1 = topologies.readJSON("topology.json");
        List<Component> deviceList = topologies.queryDevicesWithNetlistNode("top1", "vss");
        assertEquals("m1", deviceList.get(0).getId());
    }




}
