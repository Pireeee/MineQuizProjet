package network.data

import kotlinx.serialization.SerialName
import network.data.Answer

@kotlinx.serialization.Serializable
data class Question(val id:Int, val label:String, @SerialName("correct_answer_id") val correctAnswerId:Int, val answers:List<Answer>)