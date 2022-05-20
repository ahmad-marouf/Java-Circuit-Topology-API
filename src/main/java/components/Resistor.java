package components;

import netlists.Netlist;
import netlists.ResistorNetlist;
import org.json.simple.JSONObject;

public class Resistor extends Component {

    public Resistor(String id, Measure measure, Netlist netlist) {
        super("resistor", id, measure, netlist);
    }

    public Resistor(String id, JSONObject jsonObject) {
        super("resistor", id);
        this.parseJSONMeasure(jsonObject);
        this.parseJSONNetlist(jsonObject);
    }

    @Override
    public String measureType() {
        return "resistance";
    }

    @Override
    public void parseJSONMeasure(JSONObject jsonObject) {
        JSONObject measureObj = (JSONObject) jsonObject.get("resistance");
        int def = ((Number)measureObj.get("default")).intValue();
        int min = ((Number)measureObj.get("min")).intValue();
        int max = ((Number)measureObj.get("max")).intValue();
        Measure measure = new ResistorMeasure(def, min, max);
        super.setMeasure(measure);
    }

    @Override
    public void parseJSONNetlist(JSONObject jsonObject) {
        JSONObject measureObj = (JSONObject) jsonObject.get("netlist");
        String t1 = (String) measureObj.get("t1");
        String t2 = (String) measureObj.get("t2");
        Netlist netlist = new ResistorNetlist(t1, t2);
        super.setNetlist(netlist);
    }

}
