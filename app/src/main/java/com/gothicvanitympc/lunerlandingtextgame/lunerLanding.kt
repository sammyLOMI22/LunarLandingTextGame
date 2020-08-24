import kotlin.text.*

var speed = 30.00
var gravity = 1.622
var fuel = 1500.00
var altitude = 1000.00
var burn = 0.00
var impact= 0.00
//TODO fix formatting on impact
fun main(){
    while (altitude > 0){
        if (speed <= 0) {
            impact = 1000.00
        } else {
            impact = altitude / speed

            println("Altitude= "+ String.format("%.3f",altitude) + " Speed= " + String.format("%.3f",speed) + " Fuel= " + String.format("%.3f",fuel)  +" Impact= " + String.format("%.3f",impact) + " Previous burn = " + String.format("%.2f", burn))
            //Python code: println("Altitude={:8.3f} Speed={:6.3f} Fuel={:8.3f} Impact={:6.3f} Previous burn ={:6.3f}".format(altitude, speed, fuel, impact, burn))
            println(("Enter an amount of fuel to burn between 0 and 50:"))
            var fuelAmt : Double = readLine()!!.toDouble()
            burn = fuelAmt
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
//TODO: convert to display in user interface in a different file
        println("Altitude= "+ String.format("%.3f",altitude) + " Speed= "+ String.format("%.3f",speed) + " Fuel= " + String.format("%.3f",fuel) + " Last burn= " + String.format("%.2f", burn))
        // Python code println("Altitude={:8.3f} Speed={:6.3f} Fuel={:8.3f} Last burn={:6.3f}".format(altitude, speed, fuel, burn))
        if (altitude < -5 || speed > 5) {
            println("You have crashed!")
        } else {
            println("You have sucessfully landed!")
        }
    }
}