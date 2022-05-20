package netlists;

import org.json.simple.JSONObject;

import java.util.List;

public interface Netlist {

    JSONObject formatJSON();
    List<String> getNetlistNodes();
}
