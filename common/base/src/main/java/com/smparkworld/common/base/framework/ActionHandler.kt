package com.smparkworld.common.base.framework

fun interface ActionHandler<T> {

    fun handle(action: T)
}