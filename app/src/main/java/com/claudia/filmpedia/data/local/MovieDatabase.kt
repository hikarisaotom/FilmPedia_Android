package com.claudia.filmpedia.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [MovieEntity::class, UpcomingEntity::class,TopRatedEntity::class,NowPlayingEntity::class,WatchlistEntity::class],
    version = 1
)
abstract class MovieDatabase:RoomDatabase() {
    abstract val dao:MovieDao
}