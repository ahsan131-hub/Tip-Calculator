package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val totalCost: EditText =findViewById(R.id.total)

        val ceil:Switch=findViewById(R.id.isCeil)
        val result:TextView=findViewById(R.id.result)
        val calBtn:Button=findViewById(R.id.calcBtn)
        println(totalCost.text)

        calBtn.setOnClickListener{
            val opt:RadioGroup=findViewById(R.id.radioGroup)
            val checked: Int = opt.checkedRadioButtonId
            result.text= getTotalTip(totalCost.text.toString().toDouble(),checked,ceil.isChecked).toString()
        }
    }

    private fun getTotalTip(total: Double, checked: Int, ceil: Boolean): Double {
        var totalTemp:Double=0.0
        val selectedRadio:RadioButton=findViewById(checked)
        val opt:String=selectedRadio.text.toString()
        println("checked"+opt)
//        if(checked.equals("goodRadio")){
//            totalTemp= ((total/100)*10).toDouble()
//        }
        when(opt){
            "Good (20%)"->totalTemp= (total*0.20).toDouble()
            "Average(10%)"->totalTemp= (total*0.10).toDouble()
            "Bad(5%)"->totalTemp= (total*0.05).toDouble()
        }
        if (ceil){
            ceil(totalTemp)
        }
        return totalTemp

    }


}
