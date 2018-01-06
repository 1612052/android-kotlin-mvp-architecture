package com.mindorks.framework.mvp.data.database.repository.options

import io.reactivex.Observable

/**
 * Created by jyotidubey on 06/01/18.
 */
interface OptionsRepoHelper {

    fun insertOptions(options: List<Options>): Observable<Boolean>
    fun loadOptions(questionId: String): List<Options>?


}