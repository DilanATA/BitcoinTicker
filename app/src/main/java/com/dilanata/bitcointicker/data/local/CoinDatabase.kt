package com.dilanata.bitcointicker.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dilanata.bitcointicker.model.coins.CryptoModel

@Database(entities = [CryptoModel::class], version = 2)
abstract class CoinDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

    companion object{
        @Volatile
        var INSTANCE : CoinDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CoinDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                    CoinDatabase::class.java,
                "coins.db"
                        ).build()
            }
            return  INSTANCE as CoinDatabase
        }
    }
}
