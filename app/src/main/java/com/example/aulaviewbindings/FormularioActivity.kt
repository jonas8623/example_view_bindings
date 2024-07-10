package com.example.aulaviewbindings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.get
import com.example.aulaviewbindings.databinding.ActivityFloatingActionButtonBinding
import com.example.aulaviewbindings.databinding.ActivityFormularioBinding
import com.google.android.material.snackbar.Snackbar

class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        onSpinner()

        with(binding) {
            buttonSend.setOnClickListener {
//                onCheckbox()
//                onRadioGroup()
//                onSwitchToggle()
//                displaySnackBar(it)
//                displayAlertDialog()
                onSelectedItem()
            }
            checkBoxConfirmation.setOnCheckedChangeListener { _, isChecked ->
                val result = if (isChecked) "Sim" else "Não"
                binding.textViewResult.text = "Valor selecionado: $result"
            }
//            checkBoxConfirmation.setOnClickListener {
//                onCheckbox()
//            }
        }
    }

    private fun onSelectedItem() {
        val itemSelected = binding.spinnerCategorias.selectedItem
        val position = binding.spinnerCategorias.selectedItemPosition
        binding.textViewResult.text = "Item selecionado: $itemSelected / position: $position"
    }

    private fun onSpinner() {
//        val categories = listOf("Eletrônicas", "Roupas", "Móveis", "Sapatos")
        val categories = resources.getStringArray(R.array.categorias)
        binding.spinnerCategorias.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categories
        )

        binding.spinnerCategorias.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                val selectedItem = parent?.get(position)
                val selectedItem = parent?.selectedItem
                binding.textViewResult.text = selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun displayAlertDialog() {
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setTitle("Confirmação exclusão do item")
        alertBuilder.setMessage("Você deseja excluir esse item?")
        alertBuilder.setNegativeButton("cancelar") { dialog, index ->
            Toast.makeText(this, "Cancelar ($index)", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
        }
        alertBuilder.setPositiveButton("Remover") { dialog, index ->
            Toast.makeText(this, "Remover ($index)", Toast.LENGTH_LONG).show()
        }

        alertBuilder.setCancelable(false)
        alertBuilder.setNeutralButton("Ajuda") { dialog, index ->
            Toast.makeText(this, "Ajuda ($index)", Toast.LENGTH_LONG).show()
        }

        alertBuilder.setIcon(R.drawable.baseline_add_alert_24)

        val alertDialog = alertBuilder.create()
        alertDialog.show()
    }

    private fun displaySnackBar(view: View) {
        val snackbar = Snackbar.make(view, "Mensagem", Snackbar.LENGTH_SHORT)
        snackbar.setAction("Seguir") {
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
        }
        snackbar.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.setBackgroundTint(ContextCompat.getColor(this, android.R.color.holo_blue_light))
        snackbar.show()
    }

    private fun onCheckbox() {
        val isChecked = binding.checkBoxConfirmation.isChecked
        val result = if (isChecked) "Sim" else "Não"
        binding.textViewResult.text = "Valor selecionado: $result"
    }

    private fun onRadioButton() {
        val isChecked = binding.radioButtonMen.isChecked
        val result = if (isChecked) "Masculino" else "Feminino"
        binding.textViewResult.text = result
    }

    private fun onRadioGroup() {
        val id = binding.radioGroupGender.checkedRadioButtonId
        binding.textViewResult.text = when (id) {
            R.id.radioButtonMen -> "Masculino"
            R.id.radioButtonWomen -> "Feminino"
            else -> ""
        }
//        binding.radioGroupGender.clearCheck() Limpar os Radius Buttons
    }

    private fun onSwitchToggle() {
        val isCheckedSwitch = binding.switchNotification.isChecked
        val isToggleButtonEnable = binding.toggleButtonEnable.isChecked

        val result = "Switch: $isCheckedSwitch Toggle Button: $isToggleButtonEnable"
        binding.textViewResult.text = result
    }
}