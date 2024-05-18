package perez.jaime.tdimplemtacionroom.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import perez.jaime.tdimplemtacionroom.databinding.ActivityMainBinding
import perez.jaime.tdimplemtacionroom.model.bd.AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //Variable de base de datos
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la base de datos Room
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "bd_usuarios_creados"
        ).build()
    }
}