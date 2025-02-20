package com.samrtpos.smartpos.controller


import com.samrtpos.smartpos.models.Producto
import com.samrtpos.smartpos.service.ProductoService

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/productos")
class ProductoController(private val productoService: ProductoService) {

    @GetMapping
    fun getAll(): List<Producto> = productoService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Producto> {
        val producto = productoService.getById(id)
        return if (producto != null) ResponseEntity.ok(producto) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody producto: Producto): Producto = productoService.save(producto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        productoService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
