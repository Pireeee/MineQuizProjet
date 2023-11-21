package network.data

import network.data.Question

@kotlinx.serialization.Serializable
data class Quiz(var questions: List<Question>)