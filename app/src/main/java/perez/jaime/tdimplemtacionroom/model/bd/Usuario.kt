package perez.jaime.tdimplemtacionroom.model.bd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios_creados")
data class Usuario(

    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "firstName")
    val first_name: String,

    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Long = 2,
    val points: Long = 0
)
