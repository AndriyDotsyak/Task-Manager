package manager.taskmanager.adapter;

import android.app.Activity;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import manager.taskmanager.R;

public class Adapter {
    public SimpleAdapter simpleAdapter;
    private Activity activity;

    private ArrayList<Map<String, Object>> taskList;
    private Map<String, Object> map;

    public Adapter(Activity activity) {
        this.activity = activity;

        createAdapter();
    }

    private void createAdapter() {
        taskList = new ArrayList<>();

        String[] from = {"Denomination", "Comment"};
        int[] to = {R.id.txt_Denomination, R.id.txt_Comment};

        simpleAdapter = new SimpleAdapter(activity, taskList, R.layout.adapter_task, from, to);
    }

    public void addTask(String denomination, String comment) {
        map = new HashMap<>();
        map.put("Denomination", denomination);
        map.put("Comment", comment);

        taskList.add(map);

        simpleAdapter.notifyDataSetChanged();
    }
}