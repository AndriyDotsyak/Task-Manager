package manager.taskmanager.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import manager.taskmanager.R;
import manager.taskmanager.adapter.Adapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lvTask;
    Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(MainActivity.this,);
        lvTask = findViewById(R.id.lv_Task);
        lvTask.setAdapter(adapter.simpleAdapter);

        btnAddTask = findViewById(R.id.btn_AddTask);
        btnAddTask.setOnClickListener(this);
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
}
