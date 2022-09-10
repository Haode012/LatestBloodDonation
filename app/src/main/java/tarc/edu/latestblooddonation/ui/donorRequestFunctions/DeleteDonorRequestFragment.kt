package tarc.edu.latestblooddonation.ui.donorRequestFunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tarc.edu.latestblooddonation.databinding.FragmentDeleteDonorRequestBinding

class DeleteDonorRequestFragment : Fragment() {

    private var _binding: FragmentDeleteDonorRequestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDeleteDonorRequestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}