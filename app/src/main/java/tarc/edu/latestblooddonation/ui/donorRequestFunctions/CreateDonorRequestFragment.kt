package tarc.edu.latestblooddonation.ui.donorRequestFunctions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import tarc.edu.latestblooddonation.databinding.FragmentCreateDonorRequestBinding
import tarc.edu.latestblooddonation.ui.DonorRequestModel

class CreateDonorRequestFragment : Fragment() {

    private var _binding: FragmentCreateDonorRequestBinding? = null
    private lateinit var database: DatabaseReference

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCreateDonorRequestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonReq = binding.buttonConfirm

        buttonReq.setOnClickListener {
            val patientName = binding.editTextPatientName.text.toString()
            val bloodGroup = binding.editTextBloodType.text.toString()
            val description = binding.editTextDescription.text.toString()

            if (patientName.isEmpty()){
                binding.editTextPatientName.error = "Please enter name"
            }
            if (bloodGroup.isEmpty()){
                binding.editTextBloodType.error = "Please enter blood type"
            }
            if (description.isEmpty()){
                binding.editTextDescription.error = "Please enter description"
            }

            val db =  Firebase.database("https://blooddonationfirebase-d1076-default-rtdb.asia-southeast1.firebasedatabase.app/")
            val ref = db.getReference("Donor Requests")
            val donorRequest = DonorRequestModel(patientName, bloodGroup, description)
            ref.child(patientName).setValue(donorRequest).addOnSuccessListener {
                binding.editTextPatientName.text.clear()
                binding.editTextBloodType.text.clear()
                binding.editTextDescription.text.clear()

                Toast.makeText(context, "Successful", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}
