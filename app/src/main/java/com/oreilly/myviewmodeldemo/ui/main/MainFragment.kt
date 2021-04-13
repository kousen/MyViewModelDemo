package com.oreilly.myviewmodeldemo.ui.main

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.oreilly.myviewmodeldemo.R
import com.oreilly.myviewmodeldemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    // viewModels delegate is in fragment-ktx library
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        // binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.helloButton.setOnClickListener { v -> sayHello(v) }

//        viewModel.greeting.observe(viewLifecycleOwner) {
//            binding.greetingTextView.text = viewModel.greeting.value
//        }
    }

    private fun sayHello(v: View) {
        // Update the ViewModel
        viewModel.setName(binding.nameEditText.text.toString())

        // Reset the input text
        binding.nameEditText.setText("")

        // Dismiss the soft keyboard
        val imm = v.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

}