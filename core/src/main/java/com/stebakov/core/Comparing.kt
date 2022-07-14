package com.stebakov.core

/**
 * Created by Vladimir Stebakov on 13.07.2022
 */
interface Comparing<T: Comparing<T>>{
    fun sameContent(item: T) = false
    fun same(item: T) = false
}