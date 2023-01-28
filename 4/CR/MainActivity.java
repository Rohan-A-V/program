import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnsearch;
    EditText txtdate;
    TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdate=findViewById(R.id.txt_date);
        txtresult=findViewById(R.id.txt_result);
        btnsearch=findViewById(R.id.btn_search);
        btnsearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnsearch))
        {
            String sdate= txtdate.getText().toString();
            String where = "note_date=?";
            Cursor cu=getContentResolver().query(Uri.parse("content://com.example.notesprovider/notes"),new String[]{"note_date","content"},where,new String[]{sdate.trim()},null);
            if(cu.moveToNext() && cu!=null)
            {
                String dt= cu.getString(0);
                String ct= cu.getString(1);
                txtresult.setText(dt+" \n"+ct);

            }
            else{
                Toast.makeText(this,"Record not found",Toast.LENGTH_LONG).show();
            }
        }
    }
}
