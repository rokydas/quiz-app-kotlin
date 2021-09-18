package com.example.quiz_app

object QuestionContainer {
    fun getQuestions() : List<Question> {
        val questions = mutableListOf<Question>()
        questions.add(Question(
            "what is this? 1",
            "https://cdn.britannica.com/67/6267-004-10A21DF0.jpg",
            listOf("Bangladesh", "2", "3", "4"),
            1
        ))
        questions.add(Question(
            "what is this? 2",
            "https://cdn.britannica.com/97/1597-004-05816F4E.jpg",
            listOf("1", "India", "3", "4"),
            2
        ))
        questions.add(Question(
            "what is this? 3",
            "https://cdn.britannica.com/69/5869-004-7D75CD05/Flag-Argentina.jpg",
            listOf("1", "Argentina", "3", "4"),
            2
        ))
        questions.add(Question(
            "what is this? 3",
            "https://cdn.britannica.com/47/6847-004-7D668BB0/Flag-Brazil.jpg",
            listOf("1", "2", "Brazil", "4"),
            3
        ))
        questions.add(Question(
            "what is this? 3",
            "https://cdn.britannica.com/13/4413-004-3277D2EF/Flag-Sri-Lanka.jpg",
            listOf("1", "2", "Sri Lanka", "4"),
            3
        ))

        return questions
    }
}