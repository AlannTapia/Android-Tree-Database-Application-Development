package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(user_id TEXT, name TEXT primary key, email TEXT, age TEXT)");

        DB.execSQL("create Table tree(tree_id TEXT , tree_name TEXT primary key, tree_height TEXT, user_name TEXT)");
        DB.execSQL("create Table trunk(trunk_id TEXT primary key, trunk_color TEXT, trunk_diameter TEXT)");
        DB.execSQL("create Table leaf(leaf_id TEXT primary key, leaf_color TEXT, leaf_shape TEXT)");
        DB.execSQL("create Table env(env_id TEXT primary key, env_nation TEXT, env_region TEXT)");
        DB.execSQL("create Table hs(hs_id TEXT primary key, has_seeds_bool TEXT)");

        /*
        DB.execSQL("CREATE VIEW v1 AS SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter, leaf_color, leaf_shape,env_nation,env_region,has_seeds_bool"
                + " FROM tree"
                + " INNER JOIN trunk ON tree.tree_id = trunk.trunk_id");

         */
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
        DB.execSQL("drop Table if exists tree");
        DB.execSQL("drop Table if exists trunk");
        DB.execSQL("drop Table if exists env");
        DB.execSQL("drop Table if exists hs");

        DB.execSQL("drop view if exists v1");
        //onCreate(DB);
    }

    public Boolean insertuserdata(String name, String email, String age)
    {   //////////////////////////////////////////////////////////////
        SQLiteDatabase db1 = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db1, "tree");
        //db1.close();
        //////////////////////////////////////////////////////////////
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("user_id", String.valueOf(count));
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("age", age);
        long result = DB.insert("Userdetails", null, contentValues);
        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    public Boolean insert_tree_data(String tree_name, String tree_height, String user_name , String trunk_color, String trunk_diameter, String leaf_color, String leaf_shape,
    String env_nation, String env_region, String has_seeds_bool)
    {
        //Tree(tree_id TEXT primary key, tree_type TEXT, tree_color TEXT, tree_height TEXT)
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = new ContentValues();
        ContentValues contentValues3 = new ContentValues();
        ContentValues contentValues4 = new ContentValues();
        ContentValues contentValues5 = new ContentValues();
        ///////////////////////////////////////////////////////////////
        SQLiteDatabase db1 = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db1, "tree");
        //db1.close();
        //////////////////////////////////////////////////////////////
        contentValues.put("tree_id", String.valueOf(count));
        contentValues.put("tree_name", tree_name);
        contentValues.put("tree_height", tree_height);
        contentValues.put("user_name", user_name);

        contentValues2.put("trunk_id", String.valueOf(count));
        contentValues2.put("trunk_color", trunk_color);
        contentValues2.put("trunk_diameter", trunk_diameter);

        contentValues3.put("leaf_id", String.valueOf(count));
        contentValues3.put("leaf_color", leaf_color);
        contentValues3.put("leaf_shape", leaf_shape);

        contentValues4.put("env_id", String.valueOf(count));
        contentValues4.put("env_nation", env_nation);
        contentValues4.put("env_region", env_region);

        contentValues5.put("hs_id", String.valueOf(count));
        contentValues5.put("has_seeds_bool", has_seeds_bool);


        long result = DB.insert("tree", null, contentValues);
        result = DB.insert("trunk", null, contentValues2);
        result = DB.insert("leaf", null, contentValues3);
        result = DB.insert("env", null, contentValues4);
        result = DB.insert("hs", null, contentValues5);

        if(result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select name, email,age from Userdetails", null);
        return cursor;
    }

    public Cursor getdata2()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor  = DB.rawQuery("Select tree_name, tree_height, user_name, trunk_color from tree", null);
        Cursor test = DB.rawQuery("SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter,"
                + "leaf_color, leaf_shape, env_nation, env_region,has_seeds_bool"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id", null);
        return test;
    }
    public Cursor get_data_filter1()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor  = DB.rawQuery("Select tree_name, tree_height, user_name, trunk_color from tree", null);
        Cursor test = DB.rawQuery("SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter,"
                + "leaf_color, leaf_shape, env_nation, env_region,has_seeds_bool"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id"
                + " ORDER BY tree_name ASC", null);
        return test;
    }
    public Cursor get_data_filter2()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor  = DB.rawQuery("Select tree_name, tree_height, user_name, trunk_color from tree", null);
        Cursor test = DB.rawQuery("SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter,"
                + "leaf_color, leaf_shape, env_nation, env_region,has_seeds_bool"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id"
                + " ORDER BY tree_name DESC", null);
        return test;
    }
    public Cursor get_data_filter3() {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor  = DB.rawQuery("Select tree_name, tree_height, user_name, trunk_color from tree", null);
        Cursor test = DB.rawQuery("SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter,"
                + "leaf_color, leaf_shape, env_nation, env_region,has_seeds_bool"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id"
                + " ORDER BY user_name", null);
        return test;
    }
    public Cursor get_data_filter4() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select name, email,age from Userdetails"
                + " ORDER BY age", null);
        return cursor;
    }
    public Cursor get_data_filter5() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor  = DB.rawQuery("Select name, email,age from Userdetails"
                + " ORDER BY name", null);
        return cursor;
    }
    public Cursor get_data_filter6() {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor  = DB.rawQuery("Select tree_name, tree_height, user_name, trunk_color from tree", null);
        Cursor test = DB.rawQuery("SELECT tree_name, tree_height, user_name, trunk_color, trunk_diameter,"
                + "leaf_color, leaf_shape, env_nation, env_region,has_seeds_bool"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id"
                + " ORDER BY env_region", null);
        return test;
    }



    public Boolean deleteuserdata(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }
    public Boolean delete_tree_data(String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        String id = "";

        Cursor cursor = DB.rawQuery("Select * from tree where tree_name = ?", new String[]{name});

        Cursor cursor2 = DB.rawQuery("SELECT trunk_id"
                + " FROM tree INNER JOIN trunk ON tree.tree_id = trunk.trunk_id"
                + " INNER JOIN leaf ON trunk.trunk_id = leaf.leaf_id"
                + " INNER JOIN env ON leaf.leaf_id = env.env_id"
                + " INNER JOIN hs ON env.env_id = hs.hs_id"
                + " WHERE tree_name = ? ", new String[]{name});

        if (cursor2.moveToFirst()) {
             id = cursor2.getString(0);
        }
        cursor2.close();


        if(cursor.getCount()>0)
        {
            long result = DB.delete("tree", "tree_name=?", new String[]{name});
            result = DB.delete("trunk", "trunk_id=?", new String[]{id});
            result = DB.delete("leaf", "leaf_id=?", new String[]{id});
            result = DB.delete("env", "env_id=?", new String[]{id});
            result = DB.delete("hs", "hs_id=?", new String[]{id});

            if(result==-1)
            {
                return  false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }

    }


}
