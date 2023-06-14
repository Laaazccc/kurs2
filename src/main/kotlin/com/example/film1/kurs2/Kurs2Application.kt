package com.example.film1.kurs2

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.*

@Entity
data class Movies(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,
	var title: String,
	var year: Int,
	var description: String,
	var imageurl:String,
	var rating: Int,
)

@Repository
interface MovieRepository : JpaRepository<Movies, Long>

@RestController
@RequestMapping("movies")
class MovieController(private val movieRepository: MovieRepository) {
	@GetMapping("/all")
	fun getAllMovies(): List<Movies> {
		return movieRepository.findAll()
	}
}
@SpringBootApplication
class Kurs2Application

fun main(args: Array<String>) {
	runApplication<Kurs2Application>(*args)
}
