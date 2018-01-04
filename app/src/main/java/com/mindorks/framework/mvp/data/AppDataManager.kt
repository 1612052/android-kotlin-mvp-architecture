package com.mindorks.framework.mvp.data

import com.mindorks.framework.mvp.data.database.AppDBHelper
import com.mindorks.framework.mvp.data.database.DBHelper
import com.mindorks.framework.mvp.data.database.repository.options.Options
import com.mindorks.framework.mvp.data.database.repository.questions.Question
import com.mindorks.framework.mvp.data.database.repository.user.User
import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper

/**
 * Created by jyotidubey on 04/01/18.
 */
class AppDataManager(dbHelper: DBHelper, apiHelper: ApiHelper, prefHelper: PreferenceHelper) : DataManager {


    var dbHelper: DBHelper = AppDBHelper()

    override fun insertUser(user: User) {
        dbHelper.insertUser(user)
    }

    override fun insertQuestions(questions: List<Question>) {
        dbHelper.insertQuestions(questions)
    }

    override fun insertOptions(options: List<Options>) {
        dbHelper.insertOptions(options)
    }

    override fun loadQuestions(): List<Question>? {
        return dbHelper.loadQuestions()
    }

    override fun loadOptions(questionId: String): List<Options>? {
        return dbHelper.loadOptions(questionId)
    }
}