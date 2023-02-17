package com.sunshanpeng.armoury.user.common

import lombok.Data
import java.io.Serializable
import java.time.LocalDateTime

/**
 * @author sunshanpeng
 * @description
 */
@Data
abstract class BaseModel : Serializable {
    private val id: Long? = null
    private val createTime: LocalDateTime? = null
    private val updateTime: LocalDateTime? = null

    companion object {
        protected const val serialVersionUID = 1L
    }
}