package com.smparkworld.common.base.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.valueParameters

val <T : Any> KClass<T>.defaultConstructor: KFunction<T>?
    get() = this.constructors.firstOrNull { it.valueParameters.isEmpty() }

inline fun <T> Flow<T>.collectAt(
    owner: LifecycleOwner,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline callback: suspend (value: T) -> Unit
): Unit = with(owner) {
    lifecycleScope.launch {
        repeatOnLifecycle(minActiveState) {
            collect { callback(it) }
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun <K, V> Map<K, V?>.filterNonNullValues(): Map<K, V> =
    this.filterValues { it != null } as Map<K, V>
