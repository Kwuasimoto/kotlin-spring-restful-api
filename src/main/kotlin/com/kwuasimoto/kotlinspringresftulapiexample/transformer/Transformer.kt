package com.kwuasimoto.kotlinspringresftulapiexample.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}