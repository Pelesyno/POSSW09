package dsrtecnologia.com.br.petindermobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static String name = "BD_LR.db";
    private static int version=1;
    public dbHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE login(username TEXT PRIMARY KEY, password TEXT, email TEXT, img BASE64);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS login;");
        onCreate(db);
    }

    public long Cadastrar(String username, String password, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        cv.put("email", email);
        long result = db.insert("login", null, cv);
        return result;
    }

    public String ValidarLogin(String username, String password){
        String selectQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, new String[] {String.valueOf(username), String.valueOf(password)});
        if(c.getCount() > 0){
            return "OK";
        }
        return "ERRO";
    }
}