package ru.eugenyPets.englishWordsApp

// Таблица слов  Word
data class Word(
    val original: String,
    val translate: String,
    var learned: Boolean = false,
)

// Подборка слов для проверки (список слов (размером NUMBER_OF_ANSWERS) и одно слово для изучения из списка слов)
data class Question(
    val variants: List<Word>,
    val correctAnswer: Word,
)

//все слова + логика
class LearnWordsTrainer {

    private val dictionary = listOf(
        Word("Vogon", "Вогон"),
        Word("Babel fish", "Бабел-рыба"),
        Word("Gargle Blaster", "Громоглот"),
        Word("Hyperdrive", "Гипердвигатель"),
        Word("Hooloovoo", "Хулуву"),
        Word("Magrathea", "Магратея"),
        Word("Infinite Improbability", "Бесконечная Вероятность"),
        Word("Hyper Space", "Гиперпространство"),
        Word("Guidebook", "Путеводитель"),
        Word("Starship", "Звездолет"),
        Word("Towel", "Полотенце"),
        Word("Paranoid Android", "Параноидальный Андроид"),
        Word("Pan Galactic", "Пангалактический"),
        Word("Deep Thought", "Глубокая Мысль"),
        Word("Teleport", "Телепорт"),
        Word("Mind", "Разум"),
        Word("Universe", "Вселенная"),
        Word("Hitchhiker", "Автостопщик"),
        Word("Whale", "Кит"),
        Word("Petunias", "Петунии"),
        Word("Heart of Gold", "Сердце Золота"),
        Word("Galaxy", "Галактика"),
        Word("End of the Universe", "Конец Вселенной"),
        Word("Space", "Космос"),
        Word("Probability", "Вероятность")
    )

    private var currentQuestion: Question? = null

// формирование слов для вывода на страницу
    fun getNextQuestion(): Question? {

        val notLearnedList = dictionary.filter { !it.learned }  // все неизученные слова
        if (notLearnedList.isEmpty()) return null  // если все изучено, то прекращаем

        val questionWords =  // подборка слов для отображения на странице
            if (notLearnedList.size < NUMBER_OF_ANSWERS) {    // если неизученных слов мало для вывода на страницу
                val learnedList = dictionary.filter { it.learned }.shuffled()  // то берем изученные (перемешанные)

                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + learnedList
                    .take(NUMBER_OF_ANSWERS - notLearnedList.size)  // складываем неизученные + изученные слова в список размером NUMBER_OF_ANSWERS
            } else {
                notLearnedList.shuffled().take(NUMBER_OF_ANSWERS)   // если неизученных слов много, то берем их списком размером NUMBER_OF_ANSWERS
            }.shuffled()

        val correctAnswer: Word = questionWords.random()  // рандомно берем слово для изучения ответа из группы ранее отобранных слов

        currentQuestion = Question(  // экзеспляр класса Question (сформированный список слов + слово для изучения)
            variants = questionWords,
            correctAnswer = correctAnswer,
        )
        return currentQuestion  // экземпляр класса Question со списком слов (размером NUMBER_OF_ANSWERS) + слово для изучения
    }


    // определение правильности ответе (аргумент - индекс выбранного пользователем ответа (слова))
    fun checkAnswer(userAnswerIndex: Int?): Boolean {

        return currentQuestion?.let {

            val correctAnswerId = it.variants.indexOf(it.correctAnswer)  // индекс верного ответа (изучаемое слово)

            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true  // если выбор был правильный то помечаем слово как изученное
                true
            } else {
                false
            }
        } ?: false
    }
}

const val NUMBER_OF_ANSWERS: Int = 4
