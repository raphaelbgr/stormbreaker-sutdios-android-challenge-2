package com.stormbreakerstudios.android.challenge

import android.os.Bundle
import com.stormbreakerstudios.android.challenge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var viewBindingMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBindingMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBindingMainBinding.root)
        setSupportActionBar(viewBindingMainBinding.toolbar)
        supportActionBar?.setTitle(R.string.peace_time)
        viewBindingMainBinding.rvMain.adapter = MainAdapter()
    }
}