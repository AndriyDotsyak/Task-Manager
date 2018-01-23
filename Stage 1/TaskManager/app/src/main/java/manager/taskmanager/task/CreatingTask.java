package manager.taskmanager.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import manager.taskmanager.R;

public class CreatingTask extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    EditText etDenomination;
    EditText etComment;
    Button btnSave;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_task);

        etDenomination = findViewById(R.id.et_Denomination);
        etComment = findViewById(R.id.et_Comment);

        etDenomination.setOnKeyListener(this);
        etComment.setOnKeyListener(this);

        btnSave = findViewById(R.id.btn_Save);
        btnExit = findViewById(R.id.btn_Exit);

        btnSave.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.btn_Save:
                Log.d("main", "Save");
                break;
            case R.id.btn_Exit:
                CreatingTask.this.finish();
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()) {
            case R.id.et_Denomination:
                break;
            case R.id.et_Comment:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {

                        if (etComment.getLineCount() >= 3) {
                            etComment.setLongClickable(false);
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }
}
