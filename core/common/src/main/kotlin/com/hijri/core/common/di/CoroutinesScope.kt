package com.hijri.core.common.di

import com.hijri.core.common.HijriDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.annotation.Qualifier
import org.koin.core.annotation.Single

@Qualifier
annotation class ApplicationScope


@ApplicationScope
@Single
fun applicationComponentProvider(@Dispatcher(HijriDispatcher.Default) defaultDispatcher: CoroutineDispatcher) =
    CoroutineScope(defaultDispatcher + SupervisorJob())