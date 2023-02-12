package com.ereyes.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ereyes.superhero.databinding.ActivityMainBinding
import com.ereyes.superhero.superHeroesModule.view.SuperHeroesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMain, SuperHeroesFragment())
            .commit()
    }
}