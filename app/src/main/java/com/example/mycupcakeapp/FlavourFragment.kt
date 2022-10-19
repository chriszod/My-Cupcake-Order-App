package com.example.mycupcakeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mycupcakeapp.databinding.FragmentFlavourBinding

class FlavourFragment : Fragment() {

    private var binding: FragmentFlavourBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFlavourBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            flavorFragment = this@FlavourFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goToNextScreen() {
       findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_flavorFragment_to_startFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}