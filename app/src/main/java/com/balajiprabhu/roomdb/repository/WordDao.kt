package com.balajiprabhu.roomdb.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.balajiprabhu.roomdb.repository.Word

@Dao
interface WordDao {

    @Query("Select * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Query("DELETE from word_table")
    suspend fun deleteAllWords()
}