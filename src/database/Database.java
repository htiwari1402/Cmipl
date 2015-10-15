package database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
     private static String name ="data";
     private static int version =1;
     private static Context con;
	public Database(Context context) {
		super(context,name,null,version);
		// TODO Auto-generated constructor stub
		
		con= context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE ORDER(RETAILER STRING, PRODUCT STRING, ORDERNO STRING )");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	
	public void insertOrder(String retailer, String product, String orderno)
	{
		
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv= new ContentValues();
		cv.put("RETAILER", retailer);
		cv.put("PRODUCT", product);
		cv.put("ORDERNO", orderno);
		
		db.insert("ORDER", null, cv);
		db.close();
		
		
		
	}
	
	
	
	
	
	
	
	
}
