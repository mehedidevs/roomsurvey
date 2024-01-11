package com.mehedi.bedaroomtest

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.mehedi.bedaroomtest.databinding.ItemCheckBoxBinding
import com.mehedi.bedaroomtest.databinding.ItemDefaultBinding
import com.mehedi.bedaroomtest.databinding.ItemDropDownBinding
import com.mehedi.bedaroomtest.databinding.ItemEtInputBinding
import com.mehedi.bedaroomtest.databinding.ItemEtInputNumBinding
import com.mehedi.bedaroomtest.databinding.ItemImgBinding
import com.mehedi.bedaroomtest.databinding.ItemRadioGroupBinding
import com.mehedi.bedaroomtest.db.Option
import com.mehedi.bedaroomtest.db.SurveyQuestion

class SurveyAdapter(val qList: MutableList<SurveyQuestion>) :
    RecyclerView.Adapter<SurveyAdapter.VH>() {

    private lateinit var context: Context

    class VH
        (val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        context = parent.context

        return when (viewType) {


            R.layout.item_check_box ->
                VH(ItemCheckBoxBinding.inflate(LayoutInflater.from(parent.context), parent, false))

            R.layout.item_drop_down -> VH(
                ItemDropDownBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_et_input -> VH(
                ItemEtInputBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_et_input_num -> VH(
                ItemEtInputNumBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_img -> VH(
                ItemImgBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> VH(
                ItemDefaultBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }


    }

    override fun getItemCount(): Int {
        return qList.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {


        val question = qList[position]



        holder.binding.apply {

            when (this) {
                is ItemCheckBoxBinding -> {
                    createCheckboxes(question.options, this)

                }

                is ItemEtInputBinding -> {
                    TODO()
                }

                is ItemRadioGroupBinding -> {
                    TODO()
                }

                is ItemEtInputNumBinding -> {
                    TODO()
                }

                is ItemDropDownBinding -> {
                    TODO()
                }

                is ItemImgBinding -> {
                    TODO()
                }
            }


        }


    }

    private fun createCheckboxes(options: List<Option>?, binding: ItemCheckBoxBinding) {
        options?.let {
            for (option in options) {
                val checkBox = CheckBox(context)
                checkBox.text = option.value
                checkBox.tag = option.referTo // Set the referTo value as the tag

                // Add the CheckBox to your layout
                // For simplicity, let's assume you have a LinearLayout with id 'optionsLayout'
                binding.root.addView(checkBox)
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (qList[position].type) {
            multipleChoice -> {
                R.layout.item_check_box
            }

            textInput -> {
                R.layout.item_et_input
            }

            dropdown -> {
                R.layout.item_drop_down
            }

            Checkbox -> {
                R.layout.item_check_box
            }

            numberInput -> {
                R.layout.item_et_input_num
            }

            camera -> {
                R.layout.item_img
            }

            else -> 0
        }
    }

    companion object {
        const val multipleChoice = "multipleChoice"
        const val textInput = "textInput"
        const val dropdown = "dropdown"
        const val Checkbox = "Checkbox"
        const val numberInput = "numberInput"
        const val camera = "camera"
    }


}