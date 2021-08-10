package com.task.materialassetskotlin

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
class MaterialAssetsKotlinApplication

fun main(args: Array<String>) {
	runApplication<MaterialAssetsKotlinApplication>(*args)
}
