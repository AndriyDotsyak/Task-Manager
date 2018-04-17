package manager.taskmanager.task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import manager.taskmanager.R;

public class CreatingTask extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    @BindView(R.id.et_Denomination)
    EditText etDenomination;

    @BindView(R.id.et_Comment)
    EditText etComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_task);
        ButterKnife.bind(this);

        etDenomination.setOnKeyListener(this);
        etComment.setOnKeyListener(this);
    }

    @OnClick({R.id.btn_Save, R.id.btn_Exit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Save:
                Intent intent = new Intent();
                intent.putExtra("denomination", etDenomination.getText().toString());
                intent.putExtra("comment", etComment.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;

            case R.id.btn_Exit:
                finish();
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