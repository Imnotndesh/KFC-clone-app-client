package com.example.kfc_sample_client

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(context: Context, dbName: String, version: Int): SQLiteOpenHelper(context,dbName,null,version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE userInfo (userID INTEGER PRIMARY KEY,userName TEXT,userOrders INT,userPoints TEXT,dateJoined TEXT,userPass TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS userInfo")
        onCreate(db)
    }
    fun addItems(userID :Int, userName: String, userOrders: Int, userPoints:String, dateJoined:String, userPassword:String){
        val values = ContentValues()
        values.put("userID",userID)
        values.put("userName",userName)
        values.put("userOrders",userOrders)
        values.put("userPoints",userPoints)
        values.put("dateJoined",dateJoined)
        values.put("userPassword",userPassword)
        val db = this.writableDatabase
        try {
            db.insert("userInfo",null,values)
        }catch (e:Exception){
            println("Well i tried yunno!,  $e")
        }finally {
            db.close()
        }
    }
    @SuppressLint("Range")
    fun getUserData(currentUser:String):List<CollectedItemsFromDB>{
        val items = mutableListOf<CollectedItemsFromDB>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("Select * from userInfo where userName = $currentUser",null)
        while (cursor.moveToNext()){
            val thisUserID = cursor.getInt(cursor.getColumnIndex("userName"))
            val thisUserPoints = cursor.getInt(cursor.getColumnIndex("userPoints"))
            val thisUserJoined = cursor.getString(cursor.getColumnIndex("dateJoined"))
            val thisUserName = cursor.getString(cursor.getColumnIndex("userName"))
            items.add(CollectedItemsFromDB(thisUserID,thisUserName,thisUserPoints,thisUserJoined))
        }
        cursor.close()
        db.close()
        return items
    }
}