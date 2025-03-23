package com.example.laboratornaya.dcl

open class tenClass(
    val id : Int,
    val currency : String,
    val exchangeRate : Float
){
    companion object{
        val one = tenClass(0, "Российский рубль", 1F)
        val two = tenClass(1, "Доллар США", 84.64F)
        val three = tenClass(2, "Евро", 91.43F)
        val four = tenClass(3, "Бразильский реал", 14.95F)
        val five = tenClass(4, "Польский злотый", 21.83F)
        val six = tenClass(5, "Турецкая лира", 22.30F)

        val ordersAll = mutableListOf(
            one, two, three, four, five, six
        )

        fun getById(id: Int):  tenClass{
            tenClass.ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return tenClass.one
        }
    }
}

open class tenClassHistory(
    val id : Int,
    val summ : String,
    val currency: String
){
    companion object{
        val not = tenClassHistory(0, "no story", "no")

        val ordersAll = mutableListOf(
            not
        )

        fun getById(id: Int): tenClassHistory {
            tenClassHistory.ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return tenClassHistory.not
        }
    }
}