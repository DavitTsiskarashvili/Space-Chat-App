package com.space.chatApp.common


interface Mapper<in ModelA, out ModelB> {
    operator fun invoke(model: ModelA): ModelB
}