package manager.taskmanager.adapter;

import android.app.Activity;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import manager.taskmanager.R;

public class Adapter {
    public SimpleAdapter simpleAdapter;
    private Activity activity;

    public Adapter(Activity activity) {
        this.activity = activity;
        addItem();
    }

    private void addItem() {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map;

        map = new HashMap<>();
        map.put("Denomination", "Denomination");
        map.put("Comment", "Comment");
        data.add(map);

        String[] from = {"Denomination", "Comment"};
        int[] to = {R.id.txt_Denomination, R.id.txt_Comment};

        simpleAdapter = new SimpleAdapter(activity, data, R.layout.adapter_task, from, to);
    }
}
