package components

fun WordCounter(text: String):Int{
    return if(text == ""){
        0
    }else{
        text.trim()
            .split("\\s+".toRegex())
            .filter { it.isNotEmpty() }
            .count()
    }
}