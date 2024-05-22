package perez.jaime.tdimplemtacionroom

import android.app.Application
import androidx.room.Room
import perez.jaime.tdimplemtacionroom.model.bd.AppDatabase
import perez.jaime.tdimplemtacionroom.model.bd.Usuario

class AppRoom : Application() {
    companion object {
        //Variable de base de datos
        lateinit var database: AppDatabase

        //Variable de base de datos
        lateinit var usuario: Usuario
    }

    override fun onCreate() {
        super.onCreate()
        // Configurar la base de datos Room
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "bd_usuarios_creados"
        ).build()
    }

}