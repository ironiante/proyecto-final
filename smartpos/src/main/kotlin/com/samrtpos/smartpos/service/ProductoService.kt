package com.samrtpos.smartpos.service

import com.samrtpos.smartpos.models.Producto
import com.samrtpos.smartpos.repository.ProductoRepository

import org.springframework.stereotype.Service

@Service
class ProductoService(private val productoRepository: ProductoRepository) {

    fun getAll(): List<Producto> = productoRepository.findAll()

    fun getById(id: Long): Producto? = productoRepository.findById(id).orElse(null)

    fun save(producto: Producto): Producto = productoRepository.save(producto)

    fun delete(id: Long) = productoRepository.deleteById(id)
}
