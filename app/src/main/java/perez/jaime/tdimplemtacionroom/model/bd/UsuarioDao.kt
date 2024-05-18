package perez.jaime.tdimplemtacionroom.model.bd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM usuarios_creados")
    fun obtenerTodos(): List<Usuario>

    @Insert
    fun insertar(usuario: Usuario)

    @Update
    fun actualizar(usuario: Usuario)

    @Delete
    fun eliminar(usuario: Usuario)
}