package net.projecttl.springboot.template.model

import kotlinx.serialization.Serializable

@Serializable
data class Resp<T>(val ok: Int, val data: T)
