package com.dilanata.bitcointicker.view

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dilanata.bitcointicker.R
import com.dilanata.bitcointicker.adapter.RvCoinAdapter
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.service.CryptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_markets.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MarketsFragment : Fragment() {



    private val BASE_URL = "https://api.coingecko.com/api/v3/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var rvCoinAdapter: RvCoinAdapter? = null

    //Disposable
    private var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    /*    setContentView(R.layout.activity_main)

        compositeDisposable = CompositeDisposable()

        //RecyclerView
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        rv_coins.layoutManager = layoutManager
        loadData()*/
    }

  /*  private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CryptoAPI::class.java)

        compositeDisposable?.add(
            retrofit.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )


/*   val service = retrofit.create(CryptoAPI::class.java)

  val cal service.getData()

  call.enqueue(object: Callback<List<CryptoModel>> {
      override fun onResponse(
          call: Call<List<CryptoModel>>,
          response: Response<List<CryptoModel>>
      ) {
          if(response.isSuccessful){
              // body is not null
              response.body()?.let {
                  cryptoModels = ArrayList(it)

                  cryptoModels?.let {
                      rvCoinAdapter = RvCoinAdapter(it, this@MainActivity)
                      rv_coins.adapter= rvCoinAdapter
                  }

                /*  for(cryptoModel : CryptoModel in cryptoModels!!){
                      println("namee"+ cryptoModel.name)
                      println(cryptoModel.symbol)
                  }*/
              }
          }
      }

      override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
          t.printStackTrace()
      }

  })*/


    }

    private fun handleResponse(cryptoList: List<CryptoModel>) {

        cryptoModels = ArrayList(cryptoList)

        cryptoModels?.let {
            rvCoinAdapter = RvCoinAdapter(it, this@MainActivity)
            rv_coins.adapter = rvCoinAdapter
        }
    }

    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this, "Clicker: ${cryptoModel.name}", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }*/


}