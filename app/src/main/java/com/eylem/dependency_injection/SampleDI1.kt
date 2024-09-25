package com.eylem.dependency_injection

//Tight Coupling Kod Örneği (Bad practise)
interface Engine{
    fun start()

    }

 class GasEngine:Engine{
     override fun start() {
         println("Gas Engine Started")
     }

}
class ElectricEngine:Engine{
    override fun start() {
        println("Electric Engine Started")
    }
}
class HybritEngine:Engine{
    override fun start() {
        println("Hybrid Engine Started")
    }
}
enum class EngineType{
    GAS,
    ELECTRIC,
    HYBRID

}
class Car(private val engineType:EngineType){
    val gasEngine:GasEngine = GasEngine()
    val electricEngine:ElectricEngine = ElectricEngine()
    val hybritEngine:HybritEngine = HybritEngine()

    fun start(){
        when(engineType){
            EngineType.GAS -> gasEngine.start()
            EngineType.ELECTRIC  -> electricEngine.start()
            EngineType.HYBRID -> hybritEngine.start()

        }
    }

}
fun main(){
    val car1 = Car(EngineType.GAS)
    car1.start()
    val car2 = Car(EngineType.ELECTRIC)
    car2.start()
    val car3 = Car(EngineType.HYBRID)
    car3.start()
}