package manager.taskmanager.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import manager.taskmanager.R;

public class CreatingTask extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    EditText etDenomination;
    EditText etComment;

    private int pressedEnter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_task);

        etDenomination = findViewById(R.id.et_Denomination);
        etComment = findViewById(R.id.et_Comment);

        etDenomination.setOnKeyListener(this);
        etComment.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Save:
                Log.d("main", "Save");
                break;
            case R.id.btn_Exit:
                Log.d("main", "Exit");
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()) {
            case R.id.et_Denomination:
                break;
            case R.id.et_Comment:
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    pressedEnter++;
                    Log.d("main", String.valueOf(pressedEnter));
                    if (pressedEnter == 2) {
                        etComment.setLongClickable(false);
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}
