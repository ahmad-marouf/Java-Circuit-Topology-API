package components;

import netlists.Netlist;
import org.json.simple.JSONObject;

import java.util.List;

public abstract class Component {

    private String type;
    private String id;
    private Measure measure;
    private Netlist netlist;

    public Component(String type, String id, Measure measure, Netlist netlist) {
        this.type = type;
        this.id = id;
        this.measure = measure;
        this.netlist = netlist;
    }
    public Component(String type, String id) { this.type = type; this.id = id; }

    public JSONObject formatJSON() {
        JSONObject compObj = new JSONObject();
        compObj.put("type", this.type);
        compObj.put("id", this.id);
        compObj.put(this.measureType(), this.measure.formatJSON());
        compObj.put("netlist", this.netlist.formatJSON());
        return compObj;
    }

    public boolean checkNetlistNode(String NetlistNodeID) {
        List<String> nodeList = this.netlist.getNetlistNodes();
        return nodeList.contains(NetlistNodeID);
    }

    public abstract String measureType();
    public abstract void parseJSONMeasure(JSONObject jsonObject);
    public abstract void parseJSONNetlist(JSONObject jsonObject);

    public void setMeasure(Measure measure) { this.measure = measure; }
    public void setNetlist(Netlist netlist) { this.netlist = netlist; }

    public String getType() { return type; }
    public String getId() { return id; }
    public Measure getMeasure() { return measure; }
    public Netlist getNetlist() { return netlist; }

    @Override
    public String toString() {
        String component =  "\tComponent Type: " + this.type + "\n" +
                            "\tComponent ID: " + this.id + "\n" +
                            "\t"+ this.measureType() + ": " + this.measure.toString() + "\n" +
                            "\tNetlist: " + this.netlist.toString() + "\n";
        return component;
    }
}
