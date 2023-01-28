import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.Provider;

public class NotesProvider extends ContentProvider {
    static final String URL="content://com.example.notesprovider/notes";
    SQLiteDatabase  sqLiteDatabas;
    ProviderDatabase  sqLiteDatabasHelper;

    static final UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.notesprovider","notes",1);
    }


    @Override
    public boolean onCreate() {
        sqLiteDatabasHelper=new ProviderDatabase(getContext(),ProviderDatabase.DATABASE_NAME+".db",null,1);
        return (sqLiteDatabas==null)?false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] arg1, @Nullable String arg2, @Nullable String[] arg3, @Nullable String arg4) {
        Cursor cursor=null;
        sqLiteDatabas=sqLiteDatabasHelper.getReadableDatabase();
        cursor=sqLiteDatabas.query(ProviderDatabase.TABLE_NAME,arg1,arg2,arg3,arg4,null,null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri arg0) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri arg0, @Nullable ContentValues contentValues) {
        sqLiteDatabas=sqLiteDatabasHelper.getWritableDatabase();
        sqLiteDatabas.insert(ProviderDatabase.TABLE_NAME,null,contentValues);
        sqLiteDatabas.close();;
        return null;
    }

    @Override
    public int delete(@NonNull Uri arg0, @Nullable String arg1, @Nullable String[] arg2) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri arg0, @Nullable ContentValues contentValues, @Nullable String arg2, @Nullable String[] arg3) {
        return 0;
    }
}



