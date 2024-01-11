package com.mehedi.bedaroomtest

import com.mehedi.bedaroomtest.db.Option
import com.mehedi.bedaroomtest.db.SurveyQuestion

import com.mehedi.bedaroomtest.db.User

object Dummy {

    val surveyQuestions = listOf(
        SurveyQuestion(
            id = 1,
            question = "How are you ?",
            type = "multipleChoice",
            options = listOf(
                Option(value = "Very Good", referTo = 2),
                Option(value = "Good", referTo = 2),
                Option(value = "Neutral", referTo = 2),
                Option(value = "Bad", referTo = 3),
                Option(value = "Very Bad", referTo = 3)
            ),
            required = true
        ),
        SurveyQuestion(
            id = 2,
            question = "Where do you live ?",
            type = "textInput",
            options = null,
            referTo = 6,
            required = true
        ),
        SurveyQuestion(
            id = 3,
            question = "What Happened ?",
            type = "dropdown",
            options = listOf(
                Option(value = "Ajke amr mon valo nei", referTo = 5),
                Option(value = "Value of taka has dropped lower than my CGPA", referTo = 4),
                Option(value = "I am so lonely broken angel", referTo = 2),
                Option(value = "Pet kharap", referTo = 2)
            ),
            required = true
        ),
        SurveyQuestion(
            id = 4,
            question = "What should we be doing to solve this ?",
            type = "Checkbox",
            options = listOf(
                Option(value = "Taka te pathor bedhe takar weight barano jay", referTo = 6),
                Option(
                    value = "We can add extra 0 in every note so that 50 taka note will become 500",
                    referTo = 6
                ),
                Option(value = "Pamper Taka day n night jeno tar vab bere jay", referTo = 6)
            ),
            required = true
        ),
        SurveyQuestion(
            id = 5,
            question = "Mon valo korar jonno koto taka dorkar ?",
            type = "numberInput",
            options = null,
            referTo = "submit",
            required = true
        ),
        SurveyQuestion(
            id = 6,
            question = "Take a selfie",
            type = "camera",
            options = null,
            referTo = "submit",
            required = false
        )
    )

    fun getDummyUserList(): List<User> {
        return listOf(
            User(name = "John Doe", mobile = "1234567890", zoneId = "Zone1", bloodGroup = "A+"),
            User(name = "Jane Smith", mobile = "9876543210", zoneId = "Zone2", bloodGroup = "B-"),
            User(name = "Bob Johnson", mobile = "5551112233", zoneId = "Zone3", bloodGroup = "O+"),
            User(name = "Alice Brown", mobile = "9998887777", zoneId = "Zone4", bloodGroup = "AB+"),
            User(
                name = "Charlie Davis",
                mobile = "1112223333",
                zoneId = "Zone5",
                bloodGroup = "A-"
            ),
            User(name = "Emily White", mobile = "4445556666", zoneId = "Zone6", bloodGroup = "B+"),
            User(name = "David Miller", mobile = "7778889999", zoneId = "Zone7", bloodGroup = "O-"),
            User(
                name = "Grace Taylor",
                mobile = "1231231234",
                zoneId = "Zone8",
                bloodGroup = "AB-"
            ),
            User(name = "Henry Wilson", mobile = "9876543210", zoneId = "Zone9", bloodGroup = "A+"),
            User(
                name = "Sophia Moore",
                mobile = "1112223333",
                zoneId = "Zone10",
                bloodGroup = "B-"
            ),
            User(
                name = "Jackson Harris",
                mobile = "5556667777",
                zoneId = "Zone11",
                bloodGroup = "O+"
            ),
            User(
                name = "Olivia Martinez",
                mobile = "9998887777",
                zoneId = "Zone12",
                bloodGroup = "AB+"
            ),
            User(
                name = "Liam Robinson",
                mobile = "3334445555",
                zoneId = "Zone13",
                bloodGroup = "A-"
            ),
            User(name = "Ava Clark", mobile = "7778889999", zoneId = "Zone14", bloodGroup = "B+"),
            User(
                name = "Ethan Wright",
                mobile = "1231231234",
                zoneId = "Zone15",
                bloodGroup = "O-"
            ),
            User(name = "Mia King", mobile = "5556667777", zoneId = "Zone16", bloodGroup = "AB-"),
            User(name = "Noah Turner", mobile = "1112223333", zoneId = "Zone17", bloodGroup = "A+"),
            User(
                name = "Isabella Hall",
                mobile = "3334445555",
                zoneId = "Zone18",
                bloodGroup = "B-"
            ),
            User(
                name = "James Walker",
                mobile = "7778889999",
                zoneId = "Zone19",
                bloodGroup = "O+"
            ),
            User(
                name = "Sophie Adams",
                mobile = "1231231234",
                zoneId = "Zone20",
                bloodGroup = "AB-"
            )
        )
    }

}