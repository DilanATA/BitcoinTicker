package com.dilanata.bitcointicker.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dilanata.bitcointicker.model.coins.CryptoModel

@Dao
interface CoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoin(coin: CryptoModel?)

    @Delete
    fun deleteCoin(coin: CryptoModel?)

    @Query("SELECT * FROM coins")
    fun getAllCoins(): LiveData<List<CryptoModel>>

    @Query("SELECT * FROM coins WHERE coinId= :coinId")
    fun getSingleCoin(coinId: String?): LiveData<CryptoModel>

}