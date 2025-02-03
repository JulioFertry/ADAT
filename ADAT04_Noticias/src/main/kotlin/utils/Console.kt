package org.example.utils

class Console {

    fun showMessage(message: String, breakLine: Boolean = true) {
        if (breakLine) {
            println(message)
        } else {
            print(message)
        }
    }

}