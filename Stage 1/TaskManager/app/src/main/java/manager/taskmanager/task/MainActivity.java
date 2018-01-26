package manager.taskmanager.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

import manager.taskmanager.R;
import manager.taskmanager.adapter.Adapter;
import manager.taskmanager.adapter.ObjectTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lvTask;
    Button btnAddTask;

    String denomination;
    String comment;

    //private LinkedList<String> denomination = new LinkedList<>();
    //private LinkedList<String> comment = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(MainActivity.this);
        lvTask = findViewById(R.id.lv_Task);
        lvTask.setAdapter(adapter.simpleAdapter);


        btnAddTask = findViewById(R.id.btn_AddTask);
        btnAddTask.setOnClickListener(this);

        Log.d("main", "Debug");

    }

    @Override
    protected void onResume() {
        super.onResume();

        //getDataTask();
        //Log.d("main", denomination);
        //Log.d("main", comment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_AddTask:
                Intent intent = new Intent("android.intent.creating.task");
                startActivity(intent);
                break;
        }
    }

    public void getDataTask() {
        ObjectTask object = getIntent().getParcelableExtra("ObjectTask");

        denomination = object.getDenomination();
        comment = object.getComment();
    }
}
