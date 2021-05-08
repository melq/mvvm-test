package com.melq.mvvm

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.melq.mvvm.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var viewBinding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pref = activity?.getSharedPreferences("preference_root", Context.MODE_PRIVATE)
        viewModel = pref?.let { MainViewModel(it) }!!

        viewBinding = FragmentMainBinding.inflate(inflater, container, false)
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.bt1.setOnClickListener {
            viewModel.countUp(1)
        }
        viewBinding.bt2.setOnClickListener {
            viewModel.countUp(2)
        }
        viewBinding.bt3.setOnClickListener {
            viewModel.countUp(3)
        }
        viewBinding.bt4.setOnClickListener {
            viewModel.countUp(4)
        }
        viewBinding.btReset.setOnClickListener {
            viewModel.countReset()
        }
    }
}