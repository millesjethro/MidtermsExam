package com.auf.midtermsexam.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.auf.midtermsexam.PREFERENCE
import com.auf.midtermsexam.R
import com.auf.midtermsexam.USERNAME
import com.auf.midtermsexam.databinding.FragmentEditUsernameBinding
import com.auf.midtermsexam.databinding.FragmentUsernameBinding

class UsernameFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentUsernameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUsernameBinding.inflate(inflater, container, false)
        val view = binding.root
        val prefs = activity?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        val username = prefs?.getString(USERNAME, "").toString()
        binding.txtUsername.text = "USERNAME: "+username
        return view
    }


}