package administrator.example.com.a123;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.processbutton.iml.SubmitProcessButton;

import administrator.example.com.a123.utils.ProgressGenerator;

public class MessageActivity extends Activity implements ProgressGenerator.OnCompleteListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_massage);

        final EditText editMessage = (EditText) findViewById(R.id.editMessage);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final SubmitProcessButton btnSend = (SubmitProcessButton)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSend);
                btnSend.setEnabled(false);
                editMessage.setEnabled(false);
            }
        });

    }


    @Override
    public void onComplete() {

        Toast.makeText(this,R.string.Loading_Complete,Toast.LENGTH_LONG).show();

    }
}
