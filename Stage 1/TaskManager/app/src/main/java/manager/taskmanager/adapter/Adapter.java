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
    private EditText etDenomination;
    private EditText etComment;

    private LinkedList<String> denomination = new LinkedList<>();
    private LinkedList<String> comment = new LinkedList<>();

    public Adapter(Activity activity, EditText etDenomination, EditText etComment) {
        this.activity = activity;
        this.etDenomination = etDenomination;
        this.etComment = etComment;

        addItem();
    }

    private void addItem() {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map;

        map = new HashMap<>();
        map.put("Denomination", etDenomination.getText().toString());
        map.put("Comment", etComment.getText().toString());
        data.add(map);

        String[] from = {"Denomination", "Comment"};
        int[] to = {R.id.txt_Denomination, R.id.txt_Comment};

        simpleAdapter = new SimpleAdapter(activity, data, R.layout.adapter_task, from, to);
    }
}
