package com.auf.midtermsexam.Fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.auf.midtermsexam.MainActivity
import com.auf.midtermsexam.PREFERENCE
import com.auf.midtermsexam.R
import com.auf.midtermsexam.USERNAME
import com.auf.midtermsexam.databinding.FragmentEditUsernameBinding


class EditUsernameFragment : Fragment(),View.OnClickListener {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: FragmentEditUsernameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditUsernameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSave.setOnClickListener(this)


        return view
    }

    override fun onClick(p0: View?) {
        val prefs = activity?.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        val edit = prefs?.edit()
        val it = this.context
        when(p0!!.id){
            (R.id.btnSave)->{
                val edtTxtUsername = binding.edttxtusername.text
                if(edtTxtUsername.toString() == ""){
                    binding.edttxtusername.error ="required"
                    return
                    // Toast.makeText(it,"Failed",Toast.LENGTH_SHORT).show()
                }
                else if(edtTxtUsername.length < 6){
                    binding.edttxtusername.error = "should have 6 chars"
                    return
                }
                else{
                    edit?.putString(USERNAME,binding.edttxtusername.text.toString())
                    edit?.commit()
                    val intent = Intent (it, MainActivity::class.java)
                    it?.startActivity(intent)

                    Toast.makeText(it,"Success",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


}