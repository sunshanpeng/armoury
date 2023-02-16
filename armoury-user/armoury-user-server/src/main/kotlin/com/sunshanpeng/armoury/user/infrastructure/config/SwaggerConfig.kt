package com.sunshanpeng.armoury.user.infrastructure.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.tags.Tag
import org.apache.commons.lang3.RandomUtils
import org.springdoc.core.customizers.GlobalOpenApiCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.function.Consumer

@Configuration
class SwaggerConfig {
    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    fun orderGlobalOpenApiCustomizer(): GlobalOpenApiCustomizer {
        return GlobalOpenApiCustomizer { openApi: OpenAPI ->
            if (openApi.tags != null) {
                openApi.tags.forEach(Consumer { tag: Tag ->
                    val map: MutableMap<String, Any> = HashMap()
                    map["x-order"] = RandomUtils.nextInt(1, 100)
                    tag.extensions = map
                })
            }
            if (openApi.paths != null) {
                openApi.addExtension("x-extension", "extension")
                openApi.paths.addExtension("x-path-extension", RandomUtils.nextInt(1, 100))
            }
        }
    }

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Armoury用户系统API")
                    .version("1.0")
                    .description("用户相关接口API")
                    .termsOfService("https://github.com/sunshanpeng")
                    .license(
                        License().name("Apache 2.0")
                            .url("https://github.com/sunshanpeng")
                    )
            )
    }
}