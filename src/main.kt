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
    var forType: Int
    var nameOfAttr: String
    var numOfAttr: Int
    numOfAttr = readLine()!!.toInt()
    for (i in 1..numOfAttr){
        println("Введите имя атрибута")
        nameOfAttr = readLine()!!.toString()
        testBool = false
        typeOfAttr = AttributeType.values()[0]
        while (testBool == false) {
            println("Напишите тип атрибута(1, 2 , 3, 4, 5, 6)")
            forType = readLine()!!.toInt()

            when (forType) {
                1   -> {
                    typeOfAttr = AttributeType.values()[0]
                    testBool = true
                }
                2 -> {
                    typeOfAttr = AttributeType.values()[1]
                    testBool = true
                }
                3      -> {
                    typeOfAttr = AttributeType.values()[2]
                    testBool = true
                }
                4    -> {
                    typeOfAttr = AttributeType.values()[3]
                    testBool = true
                }
                5      -> {
                    typeOfAttr = AttributeType.values()[4]
                    testBool = true
                }
                6      -> {
                    typeOfAttr = AttributeType.values()[5]
                    testBool = true
                }
            }
        }
        if (testBool == false) {
            println("Введено неверное значение")
        }
        AttributeList().readAttrList(numOfAttr, nameOfAttr, typeOfAttr)

    }
    atrrList.print()
}