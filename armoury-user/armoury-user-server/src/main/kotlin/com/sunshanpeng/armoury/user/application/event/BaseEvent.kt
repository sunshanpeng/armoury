package com.sunshanpeng.armoury.user.application.event

import org.springframework.context.ApplicationEvent

open class BaseCreateEvent<T>(source: Any, val new: T) : ApplicationEvent(source)

open class BaseUpdateEvent<T>(source: Any, val new: T, val old: T) : ApplicationEvent(source)

open class BaseDeleteEvent<T>(source: Any, val old: T) : ApplicationEvent(source)