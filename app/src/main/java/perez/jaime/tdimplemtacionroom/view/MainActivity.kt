package perez.jaime.tdimplemtacionroom.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import perez.jaime.tdimplemtacionroom.databinding.ActivityMainBinding
import perez.jaime.tdimplemtacionroom.model.bd.AppDatabase
import perez.jaime.tdimplemtacionroom.model.bd.Usuario

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //Variable de base de datos
    lateinit var database: AppDatabase

    //Objeto Usuario que voy a insertar
    lateinit var nuevoUser: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la base de datos Room
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "bd_usuarios_creados"
        ).build()

        binding.btnCrearcuenta.setOnClickListener {
            //validar las contraseñas iguales
            if (binding.txtContraseniaUsuario.text.toString() != binding.txtRepetirContrasenaUsuario.text.toString()){
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Objeto usuario que vamos a insertar en la base de datos
            nuevoUser = Usuario(
                first_name = binding.txtNombreUsuario.text.toString(),
                last_name = binding.txtApellidoUsuario.text.toString(),
                email = binding.txtEmailUsuario.text.toString(),
                password = binding.txtContraseniaUsuario.text.toString(),
                points = 100
            )

            //Con corrutinas vamos a guardar usuario
            GlobalScope.launch {
                database.usuarioDao().insertar(nuevoUser)
            }
        }


    }
}