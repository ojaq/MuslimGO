package com.ojaq.muslimgo.presentation.adzan

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.ojaq.muslimgo.core.data.Resource
import com.ojaq.muslimgo.databinding.FragmentAdzanBinding
import com.ojaq.muslimgo.presentation.ViewModelFactory

class AdzanFragment : Fragment() {
    private var _binding: FragmentAdzanBinding? = null
    private val binding get() = _binding as FragmentAdzanBinding

    private val adzanViewModel: AdzanViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdzanBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adzanViewModel.getDailyAdzanTime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> showLoading(true)
                is Resource.Success -> {
                    it.data?.let { adzanResult ->
                        binding.tvLocation.text = adzanResult.listAddress[1]
                        binding.tvDate.text = adzanResult.currentDate[3]
                        showLoading(false)
                    }
                    when (val adzanTime = it.data?.adzanTime) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            binding.apply {
                                adzanTime.data?.let { time ->
                                    tvTimeImsak.text = time.imsak
                                    tvTimeSubuh.text = time.subuh
                                    tvTimeDzuhur.text = time.dzuhur
                                    tvTimeAshar.text = time.ashar
                                    tvTimeMaghrib.text = time.maghrib
                                    tvTimeIsya.text = time.isya
                                }
                            }
                        }

                        is Resource.Error -> {
                            Log.e("AdzanFragment", "getting id city: ${it.message}")
                            Toast.makeText(context, "Sorry something wrong.", Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {
                            Toast.makeText(context, "Something wrong.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                is Resource.Error -> {
                    Log.e("AdzanFragment", "onError AdzanViewModel: ${it.message}")
                    Toast.makeText(
                        context,
                        "Sorry something happened, getting error.",
                        Toast.LENGTH_SHORT
                    ).show()
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.apply {
            if (isLoading) {
                progressBarAdzanTime.visibility = View.VISIBLE
                cvAdzanTime.visibility = View.INVISIBLE
            } else {
                progressBarAdzanTime.visibility = View.INVISIBLE
                cvAdzanTime.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}