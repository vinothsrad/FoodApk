package com.example.swiggyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.swiggyapp.fragment.CartFragment
import com.example.swiggyapp.fragment.HomeFragment
import com.example.swiggyapp.fragment.PersonFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        val bottom_nav=findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val firstFragment= HomeFragment()
        val secondFragment= CartFragment()
        val thirdFragment= PersonFragment()

        setCurrentFragment(firstFragment)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.cart->setCurrentFragment(secondFragment)
                R.id.person->setCurrentFragment(thirdFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}
