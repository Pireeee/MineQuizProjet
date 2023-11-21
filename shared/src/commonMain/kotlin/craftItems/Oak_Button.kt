package craftItems

class Oak_Button {
    var xCoordinates = 0
    var yCoordinates = 0
    var name = "Oak_Button"
    var image = "Oak_Button.png"
    //var craftRecipe = list()

    fun getCoordinates(): Pair<Int, Int> {
        return Pair(xCoordinates, yCoordinates)
    }

}