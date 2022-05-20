package components;

import netlists.Netlist;
import netlists.NmosNetlist;
import org.json.simple.JSONObject;

public class Nmos extends Component {

    public Nmos(String id, Measure measure, Netlist netlist) {
        super("nmos", id, measure, netlist);
    }

    public Nmos(String id, JSONObject jsonObject) {
        super("nmos", id);
        this.parseJSONMeasure(jsonObject);
        this.parseJSONNetlist(jsonObject);
    }

    @Override
    public String measureType() {
        return "m(l)";
    }

    @Override
    public void parseJSONMeasure(JSONObject jsonObject) {
        JSONObject measureObj = (JSONObject) jsonObject.get("m(l)");
        float def = ((Number)measureObj.get("default")).floatValue();
        float min = ((Number)measureObj.get("min")).floatValue();
        float max = ((Number)measureObj.get("max")).floatValue();
        Measure measure = new NmosMeasure(def, min, max);
        super.setMeasure(measure);
    }

    @Override
    public void parseJSONNetlist(JSONObject jsonObject) {
        JSONObject measureObj = (JSONObject) jsonObject.get("netlist");
        String drain = (String) measureObj.get("drain");
        String gate = (String) measureObj.get("gate");
        String source = (String) measureObj.get("source");
        Netlist netlist = new NmosNetlist(drain, gate, source);
        super.setNetlist(netlist);
    }
}
