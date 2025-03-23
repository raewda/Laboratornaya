package com.example.laboratornaya.dcl

import com.example.laboratornaya.dcl.fourClass.Companion
import com.example.laboratornaya.dcl.sixClass.Companion.one
import com.example.laboratornaya.dcl.sixClass.Companion.three
import com.example.laboratornaya.dcl.sixClass.Companion.two
import java.util.stream.IntStream.IntMapMultiConsumer

open class sixClass(
    val id : Int,
    val country : String,
    val code : String
){
    companion object{
        val one = sixClass(0, "Россия", "460")
        val two = sixClass(1, "Япония", "450")
        val three = sixClass(2, "Греция", "520")

        val ordersAll = mutableListOf(
            one, two, three
        )

        fun getById(id: Int): sixClass {
            ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return sixClass.one
        }
    }
}

open class sixProductClass(
    val id : Int,
    val product : String,
    val code : String
){
    companion object{
        val one = sixProductClass(0, "яблоки", "254")
        val two = sixProductClass(1, "мармеладки", "753")
        val three = sixProductClass(2, "зеленый чай", "864")

        val ordersAll = mutableListOf(
            one, two, three
        )

        fun getById(id: Int): sixProductClass {
            ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return sixProductClass.one
        }
    }
}

open class sixHistoryCode(
    val id : Int,
    val code : String
){
    companion object{
        val not = sixHistoryCode(0, "no story")

        val ordersAll = mutableListOf(
            not
        )

        fun getById(id: Int): sixHistoryCode {
            sixHistoryCode.ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return sixHistoryCode.not
        }
    }
}
