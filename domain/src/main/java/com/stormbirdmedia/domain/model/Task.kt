package com.stormbirdmedia.domain.model

data class Task(
    var id : Long = 0,
    var text: String,
    var isComplete: Boolean = false
)