package dsrtecnologia.com.br.petindermobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbLikes extends SQLiteOpenHelper {

    private static String name = "BD_LR.db";
    private static int version=1;
    public dbLikes(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE likes(id_login int PRIMARY KEY, id_login_like INT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS likes;");
        onCreate(db);
    }

    public long CadastrarLike(int id_login, int id_login_like){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id_login", id_login);
        cv.put("id_login_like", id_login_like);
        long result = db.insert("likes", null, cv);
        return result;
    }
}
