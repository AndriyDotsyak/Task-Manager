package manager.taskmanager.adapter;

import android.app.Activity;
import android.os.Debug;
import android.util.Log;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import manager.taskmanager.R;

public class Adapter {
    public SimpleAdapter simpleAdapter;
    private Activity activity;

    ArrayList<Map<String, Object>> data = new ArrayList<>();
    Map<String, Object> map;

    public Adapter(Activity activity) {
        this.activity = activity;
    }

    public void createAdapter() {
        //data = new ArrayList<>();

        map = new HashMap<>();
        map.put("Denomination", "0");
        map.put("Comment", "0");

        data.add(map);

        String[] from = {"Denomination", "Comment"};
        int[] to = {R.id.txt_Denomination, R.id.txt_Comment};

        simpleAdapter = new SimpleAdapter(activity, data, R.layout.adapter_task, from, to);
    }

    public void addItem(String denomination, String comment) {


        map = new HashMap<>();
        map.put("Denomination", denomination);
        map.put("Comment", comment);

        data.add(map);

        simpleAdapter.notifyDataSetChanged();

        for (int i = 0; i < data.size(); i++) {
            Log.d("main", String.valueOf(data.get(i)));
        }
    }
}
