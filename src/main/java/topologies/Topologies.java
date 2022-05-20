package topologies;

import components.Component;
import components.Measure;
import components.Nmos;
import components.Resistor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topologies {

    private List<Topology> topologies = new ArrayList<>();

    public void readJSON(String fileName) {

        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            JSONObject topologyObj = (JSONObject) jsonParser.parse(reader);

            // Get topology id
            String topID = (String) topologyObj.get("id");
//            System.out.println(topID);

            //Get component list
            List<Component> componentList = new ArrayList<>();
            JSONArray componentsArray = (JSONArray) topologyObj.get("components");
            for (Object componentItem : componentsArray) {
                JSONObject compObject = (JSONObject) componentItem;
                String compID = (String) compObject.get("id");
                String compType = (String) compObject.get("type");
//                System.out.println("ID: " + compID + "\t Type: " + compType);
                Component component = null;
                switch (compType) {
                    case "resistor":
                        component = new Resistor(compID, compObject);
                        break;
                    case "nmos":
                        component = new Nmos(compID, compObject);
                        break;
                }

                componentList.add(component);
            }
            Topology topology = new Topology(topID, componentList);
            this.topologies.add(topology);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeJSON(String topID, String fileName) {
        Topology topology = findTopology(topID);
        if (topology == null) {
            System.out.println("Topology ID not found in saved topologies");
            return;
        }

        JSONObject topologyObj = new JSONObject();
        topologyObj.put("id", topID);
        topologyObj.put("components", topology.formatJSON());

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(topologyObj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Topology> queryTopologies() {
        return this.topologies;
    }

    public void deleteTopology(String topID) {
        for (int i = 0; i < this.topologies.size(); i++) {
            if (this.topologies.get(i).getId().equalsIgnoreCase(topID))
                this.topologies.remove(i);
        }
    }

    public Topology findTopology(String topID) {
        for (Object topology : queryTopologies()) {
            Topology top = (Topology) topology;
            if (top.getId().equalsIgnoreCase(topID))
                return top;
        }
        return null;
    }

    @Override
    public String toString() {
        String topologies = "----------------\n";
        for (Object topology : this.topologies) {
            topologies += topology.toString() + "\n";
        }
        topologies += "----------------\n";
        return topologies;
    }
}
