import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProviderDatabase extends SQLiteOpenHelper {
    public static String DATABASE_NAME="notesprovider";
    public static String TABLE_NAME="notes";
    public static String COLUMN_DATE="note_date";
    public static String COLUMN_NOTE="content";

    public ProviderDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table notes(note_date TEXT,content TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int arg1, int arg2) {

    }
}


