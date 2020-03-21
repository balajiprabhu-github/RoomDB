package com.balajiprabhu.roomdb.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.balajiprabhu.roomdb.repository.Word
import com.balajiprabhu.roomdb.repository.WordRepository
import com.balajiprabhu.roomdb.repository.WordRoomDatabase
import kotlinx.coroutines.launch

class WordViewModel(application: Application):AndroidViewModel(application){

    private val repository: WordRepository

    val allWords : LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).WordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch{
        repository.insert(word)
    }

}