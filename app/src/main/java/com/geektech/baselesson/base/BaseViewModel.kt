package com.geektech.baselesson.base

interface BaseViewModel {
    val id: Any?
    override fun equals(other: Any?): Boolean
}