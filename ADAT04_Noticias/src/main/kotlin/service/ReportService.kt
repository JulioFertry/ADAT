package org.example.service

import org.example.model.Report
import org.example.model.User
import org.example.utils.Console
import java.util.Date

class ReportService {

    private val console = Console()


    private fun introduceTags(): List<String> {
        val tagList: MutableList<String> = mutableListOf()
        var tag = "a"
        while (tag != "") {
            tag = readln().trim()
            if (tag != "") {
                tagList.add(tag)
            }
        }

        return tagList
    }


    fun createReport(user: User): Report {
        console.showMessage("Título de la noticia: ")
        val title = readln()
        console.showMessage("Cuerpo de la noticia: ")
        val body = readln()
        console.showMessage("Introduce las tags y pulsa ENTER cuando hayas terminado: ")
        val tags = introduceTags()
        val usernick = user.nickname
        val date = Date()
        val report = Report(title, body, date, tags, usernick)
        return report
    }

}