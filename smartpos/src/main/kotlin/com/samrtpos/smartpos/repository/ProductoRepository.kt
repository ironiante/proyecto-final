package com.samrtpos.smartpos.repository


import com.samrtpos.smartpos.models.Producto

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductoRepository : JpaRepository<Producto, Long>
