package com.example.laboratornaya.dcl

import kotlin.random.Random

open class fourClass(
    val id : Int,
    val question : String,
    val answer : String,
    val hint : String
){

    companion object{
        val one = fourClass(0, "Сколько животных взял Моисей в свой ковчег?", "нисколько. Ковчег был у Ноя", "Моисей?")
        val two = fourClass(1, "Воробей может съесть горсточку зерна, а лошадь не может. Почему?", "Воробей слишком маленький, чтобы съесть лошадь", "Размер")

        val ordersAll = mutableListOf(
            one, two
        )

        fun getById(id: Int): fourClass {
            ordersAll.forEach() { el ->
                if (el.id == id) return el
            }
            return one
        }
    }
}
