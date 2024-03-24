package com.claudia.filmpedia.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface MovieDao{
    @Upsert
    suspend fun upsertAll(movies:List<MovieEntity>)

    @Query("DELETE FROM movieentity")
    suspend fun clearAll()
}