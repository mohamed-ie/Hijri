package com.hijri.core.common.di

import com.hijri.core.common.HijriDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.Qualifier
import org.koin.core.annotation.Single

@Qualifier
annotation class Dispatcher(val dispatcher: HijriDispatcher)

@Dispatcher(HijriDispatcher.IO)
@Single
fun ioDispatcher() = Dispatchers.IO

@Dispatcher(HijriDispatcher.Default)
@Single
fun defaultDispatcher() = Dispatchers.Default