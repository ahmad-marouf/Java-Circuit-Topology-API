package components;

import netlists.Netlist;
import org.json.simple.JSONObject;

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

    public Component(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public abstract String measureType();
    public abstract void parseJSONMeasure(JSONObject jsonObject);
    public abstract void parseJSONNetlist(JSONObject jsonObject);

    public void setMeasure(Measure measure) { this.measure = measure; }

    public void setNetlist(Netlist netlist) { this.netlist = netlist; }

    @Override
    public String toString() {
        String component =  "\tComponent Type: " + this.type + "\n" +
                            "\tComponent ID: " + this.id + "\n" +
                            "\t"+ this.measureType() + ": " + this.measure.toString() + "\n" +
                            "\tNetlist: " + this.netlist.toString() + "\n";
        return component;
    }
}
