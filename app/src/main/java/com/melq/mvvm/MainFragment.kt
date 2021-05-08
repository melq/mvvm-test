package com.melq.mvvm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.melq.mvvm.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var viewBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = activity?.getSharedPreferences("preference_root", Context.MODE_PRIVATE)

        var count = 0
        if (pref != null)
            count = pref.getInt("count", 0)
        else Snackbar.make(viewBinding.constraintLayout,
                "pref is null",
                Snackbar.LENGTH_LONG).show()

        viewBinding.count = count

        viewBinding.bt1.setOnClickListener {
            count += 1
            viewBinding.count = count
            pref?.edit { putInt("count", count) }
        }
        viewBinding.bt2.setOnClickListener {
            count += 2
            viewBinding.count = count
            pref?.edit { putInt("count", count) }
        }
        viewBinding.bt3.setOnClickListener {
            count += 3
            viewBinding.count = count
            pref?.edit { putInt("count", count) }
        }
        viewBinding.bt4.setOnClickListener {
            count += 4
            viewBinding.count = count
            pref?.edit { putInt("count", count) }
        }
        viewBinding.btReset.setOnClickListener {
            count = 0
            viewBinding.count = count
            pref?.edit{ putInt("count", count) }
        }
    }
}