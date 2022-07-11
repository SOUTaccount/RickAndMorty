package com.stebakov.core.di

import android.app.Application
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CoreScope

fun coreComponent(application : Application) =
    (application as CoreProvider).provideCoreComponent()