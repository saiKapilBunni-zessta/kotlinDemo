package com.kotlin.mavendemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MavendemoApplication

fun main(args: Array<String>) {
	runApplication<MavendemoApplication>(*args)
}
