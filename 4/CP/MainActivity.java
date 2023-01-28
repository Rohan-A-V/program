import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText txtDate,txtcontent;
    Button btnAddNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDate=(EditText) findViewById(R.id.txt_date);
        txtcontent=(EditText) findViewById(R.id.txt_content);
        btnAddNote=(Button) findViewById(R.id.btn_add_note);
        btnAddNote.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (view.equals(btnAddNote))
        {
            String sdate=txtDate.getText().toString();
            String scontent=txtcontent.getText().toString();
            ContentValues values=new ContentValues();
            values.put("note_date",sdate);
            values.put("content",scontent);
            getContentResolver().insert(Uri.parse("content://com.example.notesprovider/notes"),values);
            Toast.makeText(getBaseContext(),"Data inserted successfully",Toast.LENGTH_LONG).show();
        }

    }
}




 
