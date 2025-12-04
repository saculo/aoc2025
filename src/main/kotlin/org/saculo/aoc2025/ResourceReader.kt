package org.saculo.aoc2025

object ResourceReader {
    fun readAsLines(fileName: String): List<String> {
        return javaClass.getResourceAsStream("/$fileName")?.bufferedReader()?.use {
            it.readLines()
        } ?: throw IllegalArgumentException("Resource $fileName not found")
    }

    fun readAsCsv(fileName: String): List<String> {
        return javaClass.getResourceAsStream("/$fileName")?.bufferedReader()?.use {
            it.readText().split(",").toList()
        } ?: throw IllegalArgumentException("Resource $fileName not found")
    }
}