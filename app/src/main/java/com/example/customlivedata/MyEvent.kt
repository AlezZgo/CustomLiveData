package com.example.customlivedata

sealed interface MyEvent {

    fun show(block: (mes : String) -> Unit) : Unit

    data class Error(private val errorMessage : String) : MyEvent{
        override fun show(block: (mes : String) -> Unit) {
            block.invoke(errorMessage)
        }

    }
}
