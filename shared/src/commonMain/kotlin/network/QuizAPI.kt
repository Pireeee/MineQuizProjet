package network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import network.data.Answer
import network.data.Question
import network.data.Quiz

class QuizAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                contentType = ContentType.Text.Plain, // because Github is not returning an 'application/json' header
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
        }
    }
    suspend fun getAllQuestions(): Quiz {
        var response : Quiz
        try {
            response = httpClient.get("https://raw.githubusercontent.com/Pireeee/MineQuizProjet/main/shared/src/commonMain/resources/Questions.json").body()
        }
        catch (e: Exception) {
            return generateOfflineQuizz()
        }
        return response
    }

    fun createQuestion(id: Int, label: String, correctAnswer: Int,answers : List<Answer>): Question {
        return Question(id, label, correctAnswer, answers)
    }
    fun createAnswer(id: Int, label: String): Answer {
        return Answer(id, label)
    }
    fun generateOfflineQuizz() : Quiz{
        var quiz = Quiz(listOf())
        val question1 = createQuestion(1, "What material is needed to craft a crafting table?", 3, listOf(
            createAnswer(1, "Wooden logs"),
            createAnswer(2, "Cobblestone"),
            createAnswer(3, "Wooden Planks"),
            createAnswer(4, "Iron Ingots")
        ))

        val question2 = createQuestion(2, "Which dimension is known for its fiery landscape and dangerous creatures?", 2, listOf(
            createAnswer(1, "The End"),
            createAnswer(2, "The Nether"),
            createAnswer(3, "The Overworld"),
            createAnswer(4, "The Aether")
        ))

        val question3 = createQuestion(3, "How many Wheat do you need to craft a cake?", 3, listOf(
            createAnswer(1, "1"),
            createAnswer(2, "2"),
            createAnswer(3, "3"),
            createAnswer(4, "4")
        ))

        val question4 = createQuestion(4, "Which mob is known for exploding when it gets close to the player?", 1, listOf(
            createAnswer(1, "Creeper"),
            createAnswer(2, "Zombie"),
            createAnswer(3, "Skeleton"),
            createAnswer(4, "Spider")
        ))

        val question5 = createQuestion(5, "What is the name of the block that allows players to sleep and set their spawn point?", 2, listOf(
            createAnswer(1, "Crafting Table"),
            createAnswer(2, "Bed"),
            createAnswer(3, "Chest"),
            createAnswer(4, "Furnace")
        ))

        val question6 = createQuestion(6, "Which biome is characterized by its icy terrain and snow-covered landscape?", 3, listOf(
            createAnswer(1, "Desert"),
            createAnswer(2, "Swamp"),
            createAnswer(3, "Taiga"),
            createAnswer(4, "Jungle")
        ))

        val question7 = createQuestion(7, "What is required to create a map in Minecraft?", 4, listOf(
            createAnswer(1, "Iron Ingots"),
            createAnswer(2, "Diamonds"),
            createAnswer(3, "Redstone Dust"),
            createAnswer(4, "Paper and Compass")
        ))

        val question8 = createQuestion(8, "Which tool is specifically designed for mining ores and blocks faster?", 1, listOf(
            createAnswer(1, "Pickaxe"),
            createAnswer(2, "Axe"),
            createAnswer(3, "Shovel"),
            createAnswer(4, "Sword")
        ))

        val question9 = createQuestion(9, "What is the main ingredient needed to brew a potion of strength?", 1, listOf(
            createAnswer(1, "Blaze Powder"),
            createAnswer(2, "Fermented Spider Eye"),
            createAnswer(3, "Blaze Rod"),
            createAnswer(4, "Nether Wart")
        ))

        val question10 = createQuestion(10, "Which block is used to create a Nether Portal?", 2, listOf(
            createAnswer(1, "End Portal Frame"),
            createAnswer(2, "Obsidian"),
            createAnswer(3, "Stone Bricks"),
            createAnswer(4, "Nether Bricks")
        ))
        quiz.questions = listOf(question1,question2,question3,question4,question5,question6,question7,question8,question9,question10)
        return quiz
    }
}
