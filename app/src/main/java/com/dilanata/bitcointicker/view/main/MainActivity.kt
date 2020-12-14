package com.dilanata.bitcointicker.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dilanata.bitcointicker.R
import com.dilanata.bitcointicker.adapter.RvCoinAdapter
import com.dilanata.bitcointicker.model.coins.CryptoModel
import com.dilanata.bitcointicker.service.CryptoAPI
import com.dilanata.bitcointicker.common.ViewPagerAdapter
import com.dilanata.bitcointicker.view.coins.CoinsFragment
import com.dilanata.bitcointicker.view.favourite.FavouriteCoinsFragment


import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        setSupportActionBar(main_toolbar)
        setupViewPager()

        main_tabs.setupWithViewPager(main_viewpager)
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment(CoinsFragment(), title = "Coins")
            addFragment(FavouriteCoinsFragment(), "Favourites")
        }
        main_viewpager.adapter = adapter
        main_viewpager.offscreenPageLimit = 3
    }

}