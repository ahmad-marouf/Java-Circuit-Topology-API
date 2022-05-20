package netlists;


import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResistorNetlist implements Netlist {

    private String t1;
    private String t2;

    public ResistorNetlist(String t1, String t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public JSONObject formatJSON() {
        JSONObject netlistObj = new JSONObject();
        netlistObj.put("t1", this.t1);
        netlistObj.put("t2", this.t2);
        return netlistObj;
    }

    @Override
    public List<String> getNetlistNodes() {
        List<String> nodeList = new ArrayList<>();
        nodeList.add(this.t1);
        nodeList.add(this.t2);
        return nodeList;
    }

    @Override
    public String toString() {
        return "t1='" + t1 + '\'' + ", t2='" + t2 + '\'';
    }
}
