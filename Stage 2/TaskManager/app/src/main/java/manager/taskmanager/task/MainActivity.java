package manager.taskmanager.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import manager.taskmanager.R;
import manager.taskmanager.adapter.Adapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.lv_Task)
    ListView lvTask;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new Adapter(MainActivity.this);
        lvTask.setAdapter(adapter.simpleAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && requestCode == 1) {
            String denomination = data.getStringExtra("denomination");
            String comment = data.getStringExtra("comment");

            adapter.addTask(denomination, comment);
        }
    }

    @OnClick(R.id.btn_AddTask)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_AddTask:
                Intent intent = new Intent("android.intent.creating.task");
                startActivityForResult(intent, 1);
                break;
        }
    }
}