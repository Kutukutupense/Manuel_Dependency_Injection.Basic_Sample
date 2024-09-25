package com.eylem.dependency_injection

// Loose Coupling Kod Örneği (Good Practise)

interface NewEngine{
    fun start()

}

class NewGasEngine:NewEngine{
    override fun start() {
        println("Gas Engine Started")
    }

}
class NewElectricEngine:NewEngine{
    override fun start() {
        println("Electric Engine Started")
    }
}
class NewHybritEngine:NewEngine {
    override fun start() {
        println("Hybrid Engine Started")
    }
}

class Plane(private val newEngine:NewEngine){ // Manuel Dependency Injection kullandık.
                                        // (ilgili bağımlılığı constructordan alıyoruz)
    fun start(){
        newEngine.start()
    }
}

class Roket(){  //Manuel Dependency Injection kullandık.(ilgili bağımlılığı fielddan alıyoruz)
    private lateinit var newEngine:NewEngine
    fun setEngine(newEngine:NewEngine){
        this.newEngine = newEngine
    }
    fun start(){
        newEngine.start()
    }
}
fun main(){
    //Dependency Injection (Constructor Örneği)
    val newGasEngine = NewGasEngine()
    val plane1 = Plane(newGasEngine)
    plane1.start()

    val newelectricEngine = NewElectricEngine()
    val plane2 = Plane(newelectricEngine)
    plane2.start()

    val newhybridEngine = NewHybritEngine()
    val plane3 = Plane(newhybridEngine)
    plane3.start()

    val plane4 = Plane(NewHybritEngine())
    plane4.start()

    //Dependency Injection (Filed Örneği)
    val roket = Roket()
    roket.setEngine(NewGasEngine())
    roket.start()
}