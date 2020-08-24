package com.gothicvanitympc.lunerlandingtextgame

import altitude
import burn
import impact
import speed
import fuel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchBtn.setOnClickListener{landSpaceship()}

    }

    private fun landSpaceship() {
        val gravity = 1.622
       if (altitude <= 0 || landingResult.text == "You have sucessfully landed!"){
           speed = 30.000

           fuel = 1500.000
        altitude = 1000.00
           burn = 0.00
        impact = 0.00
       }
        landingResult.isVisible=false
        //TODO take user input for burn amount and save other varables in shared prefences
        //val intent = intent
         var fuelAmt = fuelBrn.text.toString()
        burn = fuelAmt.toDouble()
        //while (altitude > 0){
            if (speed <= 0) {
                impact = 1000.00
            } else {
                impact = altitude / speed
                //ToDo translate to update textVeiws to display values
               // altitude= AltVal.text.toString()
                //String.format("%.3f",altitude) = AltVal.text.toString()
                //AltVal.text= altitude.toString()
                 // spdVal.setText(String.format("%.3f",speed))
                // fuelAmtTX.setText(String.format("%.3f", fuelAmt))
                //impVal.setText(String.format("%.3f", impact))
                //prvBurnAmt.setText(String.format("%.2f", burn))

                var formattedA = String.format("%.3f", altitude)
                AltVal.text= formattedA

               // AltVal.text=altitude.toString()

                var formattedS = String.format("%.3f", speed)
                spdVal.text=formattedS

               // spdVal.text=speed.toString()

                var formattedI = String.format("%.3f", impact)
                impVal.text=formattedI

                //impVal.text=impact.toString()

                var formattedF = String.format("%.3f", fuel)
                fuelAmtTX.text=formattedF

                //uelAmtTX.text=fuel.toString()

                var formattedB = String.format("%.3f", burn)
                prvBurnAmt.text=formattedB

               // prvBurnAmt.text= burn.toString()
                //println("Altitude= "+ String.format("%.3f",altitude) + " Speed= " + String.format("%.3f",speed) + " Fuel= " + String.format("%.3f",fuel)  +" Impact= " + String.format("%.3f",impact) + " Previous burn = " + String.format("%.2f", burn))
                //Python code: println("Altitude={:8.3f} Speed={:6.3f} Fuel={:8.3f} Impact={:6.3f} Previous burn ={:6.3f}".format(altitude, speed, fuel, impact, burn))
               // println(("Enter an amount of fuel to burn between 0 and 50:"))not needed in android
                //var fuelAmt : Double = readLine()!!.toDouble() not needed in android

                //burn = float(input("Enter an amount of fuel to burn between 0 and 50:"))python code
            }
            if (burn < 0){
                burn = 0.00
            }
            if (burn > 50){
                burn = 50.00
            }

            if (burn > fuel){
                burn = fuel
            }
            altitude -= speed
            speed += gravity - burn / 10.00
            fuel -= burn
            //ToDo translate to update textVeiws to display values

            var formatted2A = String.format("%.3f", altitude)
            AltVal.text= formatted2A
            var formatted2S = String.format("%.3f", speed)
            spdVal.text=formatted2S
            var formatted2I = String.format("%.3f", impact)
            impVal.text=formatted2I
            var formatted2F = String.format("%.3f", fuel)
            fuelAmtTX.text=formatted2F
            var formatted2B = String.format("%.2f", burn)
            prvBurnAmt.text=formatted2B

          /*
            AltVal.text=altitude.toString()
            spdVal.text=speed.toString()
            impVal.text=impact.toString()
            fuelAmtTX.text=fuel.toString()
            prvBurnAmt.text= burn.toString()
          */


            //println("Altitude= "+ String.format("%.3f",altitude) + " Speed= "+ String.format("%.3f",speed) + " Fuel= " + String.format("%.3f",fuel) + " Last burn= " + String.format("%.2f", burn))
            // Python code println("Altitude={:8.3f} Speed={:6.3f} Fuel={:8.3f} Last burn={:6.3f}".format(altitude, speed, fuel, burn))
            if (altitude < -5 || speed > 5) {
                // TODO save this message to display in hidden textveiw and make it visable
                landingResult.text="You have crashed!"
                landingResult.isVisible=true
                // println("You have crashed!")

            } else {
                // TODO save this message to display in hidden textveiw and make it visable
                landingResult.setText("You have sucessfully landed!")
                landingResult.isVisible=true
                //println("You have sucessfully landed!")

            }
        //}

    }
}

