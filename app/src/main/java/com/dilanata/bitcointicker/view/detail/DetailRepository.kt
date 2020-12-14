package com.dilanata.bitcointicker.view.detail

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dilanata.bitcointicker.data.local.CoinDao
import com.dilanata.bitcointicker.data.local.CoinDatabase
import com.dilanata.bitcointicker.data.remote.APIClient
import com.dilanata.bitcointicker.data.remote.ApiService
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.model.detail.CoinDetailModel
import com.dilanata.bitcointicker.model.detail.CryptoDetailModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepository(context: Context) {

    private val apiService: ApiService by lazy { APIClient.getApiService() }

   // private val db: CoinDatabase by lazy { CoinDatabase.getInstance(context) }
    //private val dao: CoinDao by lazy { db.coinDao() }
/*
    fun insertCoin(coin: CryptoModel?) {
        InsertAsyncTask(dao).execute(coin)
    }

    fun deleteCoin(coin: CryptoModel?){
        DeletetAsyncTask(dao).execute(coin)
    }

    fun getAllCoins(): LiveData<List<CryptoModel>>{
        return dao.getAllCoins()
    }

    fun getSingleMovie(coinId: String?): LiveData<CryptoModel>{
        return dao.getSingleCoin(coinId)
    }
    private class InsertAsyncTask(val dao: CoinDao) : AsyncTask<CryptoModel, Void, Void>() {
        override fun doInBackground(vararg params: CryptoModel?): Void? {
            dao.insertCoin(params[0])
            return null
        }
    }

    private class DeletetAsyncTask(val dao: CoinDao) : AsyncTask<CryptoModel, Void, Void>() {
        override fun doInBackground(vararg params: CryptoModel?): Void? {
            dao.deleteCoin(params[0])
            return null
        }
    }
*/
    fun getDetailCoin(coinId: String): MutableLiveData<CoinDetailModel> {
        val coinDetailLive: MutableLiveData<CoinDetailModel> = MutableLiveData()
        apiService.getCoinDetailData(coinId).enqueue(object : Callback<CoinDetailModel> {
            override fun onResponse(
                call: Call<CoinDetailModel>,
                response: Response<CoinDetailModel>
            ) {
                coinDetailLive.value = response.body()
            }

            override fun onFailure(call: Call<CoinDetailModel>, t: Throwable) {
                Log.e("getCoinDetails", t.message.toString())
            }

        })
        return coinDetailLive
    }

    /* fun getDetailCrypto(coinId: String) : MutableLiveData<CryptoDetailModel>{
         val cryptoDetailLive: MutableLiveData<CryptoDetailModel> = MutableLiveData()
         apiService.getDetailData(coinId).enqueue(object : Callback<CryptoDetailModel>{
             override fun onResponse(
                 call: Call<CryptoDetailModel>,
                 response: Response<CryptoDetailModel>
             ) {
                 cryptoDetailLive.value = response.body()
             }

             override fun onFailure(call: Call<CryptoDetailModel>, t: Throwable) {
                 Log.e("getCryptoDetails", t.message.toString())
             }

         })
         return  cryptoDetailLive
     }*/
}