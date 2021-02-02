enum class AttributeType{
    Numbers, TrueFalse , Date, Stroka, Dict, List
}

class Attribute(val ID: Int,
                val name: String,
                val type: AttributeType,
                var position: Int,
                private val dictionaryUIN: String = " ",
                private val dictionaryUINTo: String = " ",
                private var filterValue: String = " ") {

    fun attributePrint(){
        println("Характеристики атрибута: ")
        println(ID)
        println(name)
        println(type)
   }

}

class AttributeList(){
   private var atrrList = mutableListOf<Attribute>()
    fun addInList(newElement : Attribute){
        atrrList.add(newElement)
    }
    fun deleteList(elementOfAttr : Attribute){
        atrrList.remove(elementOfAttr)
    }
    fun print() {
        atrrList.forEach{entry -> entry.attributePrint()}
    }

       fun readAttrList(numOfAttr  : Int,
                         nameOfAttr : String,
                         typeOfAttr : AttributeType){
            var fAttribute = Attribute(numOfAttr, nameOfAttr, typeOfAttr, numOfAttr)
            this.addInList(fAttribute)

        }

}
fun main(){
    println("Введите кол-во атрибутов")
    var atrrList = AttributeList()
    var typeOfAttr: AttributeType
    var testBool: Boolean
    var forType: String
    var nameOfAttr: String
    var numOfAttr: Int
    numOfAttr = readLine()!!.toInt()
    for (i in 1..numOfAttr){
        println("Введите имя атрибута")
        nameOfAttr = readLine()!!.toString()
        testBool = false
        typeOfAttr = AttributeType.values()[0]
        while (testBool == false) {
            println("Напишите тип атрибута(Numbers, TrueFalse , Date, Stroka, Dict, List)")
            forType = readLine()!!.toString()
            try{
            when (forType) {
                "Numbers"   -> {
                    typeOfAttr = AttributeType.values()[0]
                    testBool = true
                }
                "TrueFalse" -> {
                    typeOfAttr = AttributeType.values()[1]
                    testBool = true
                }
                "Date"      -> {
                    typeOfAttr = AttributeType.values()[2]
                    testBool = true
                }
                "Stroka"   -> {
                    typeOfAttr = AttributeType.values()[3]
                    testBool = true
                }
                "Dict"      -> {
                    typeOfAttr = AttributeType.values()[4]
                    testBool = true
                }
                "List"      -> {
                    typeOfAttr = AttributeType.values()[5]
                    testBool = true
                }
            }
        }
            catch (e: Exception){
                println("Введено неверное значение")
            }
        if (testBool == false) {
            println("Введено неверное значение")
        }
    }
        AttributeList().readAttrList(numOfAttr, nameOfAttr, typeOfAttr)

    }
    atrrList.print()
}