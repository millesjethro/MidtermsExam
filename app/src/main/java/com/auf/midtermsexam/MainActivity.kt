package com.auf.midtermsexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.getTag
import androidx.fragment.app.FragmentManager
import com.auf.midtermsexam.Fragments.EditUsernameFragment
import com.auf.midtermsexam.Fragments.UsernameFragment
import com.auf.midtermsexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtusernameFragement = EditUsernameFragment();
        val fragmanager = supportFragmentManager;
        fragmanager.beginTransaction().replace(R.id.edtusernameLayout,edtusernameFragement).commit()

        val UsernameFragment = UsernameFragment();
        fragmanager.beginTransaction().replace(R.id.usernameLayout,UsernameFragment).commit()
    }
}

