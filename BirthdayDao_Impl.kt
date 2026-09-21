package com.example.birthdaycountdown.`data`.local

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.birthdaycountdown.`data`.model.Birthday
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class BirthdayDao_Impl(
  __db: RoomDatabase,
) : BirthdayDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfBirthday: EntityInsertAdapter<Birthday>

  private val __deleteAdapterOfBirthday: EntityDeleteOrUpdateAdapter<Birthday>

  private val __updateAdapterOfBirthday: EntityDeleteOrUpdateAdapter<Birthday>
  init {
    this.__db = __db
    this.__insertAdapterOfBirthday = object : EntityInsertAdapter<Birthday>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `birthdays` (`id`,`name`,`dateOfBirth`,`imageUri`,`reminderTime`) VALUES (nullif(?, 0),?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Birthday) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.dateOfBirth)
        val _tmpImageUri: String? = entity.imageUri
        if (_tmpImageUri == null) {
          statement.bindNull(4)
        } else {
          statement.bindText(4, _tmpImageUri)
        }
        statement.bindText(5, entity.reminderTime)
      }
    }
    this.__deleteAdapterOfBirthday = object : EntityDeleteOrUpdateAdapter<Birthday>() {
      protected override fun createQuery(): String = "DELETE FROM `birthdays` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Birthday) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__updateAdapterOfBirthday = object : EntityDeleteOrUpdateAdapter<Birthday>() {
      protected override fun createQuery(): String = "UPDATE OR ABORT `birthdays` SET `id` = ?,`name` = ?,`dateOfBirth` = ?,`imageUri` = ?,`reminderTime` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Birthday) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.name)
        statement.bindText(3, entity.dateOfBirth)
        val _tmpImageUri: String? = entity.imageUri
        if (_tmpImageUri == null) {
          statement.bindNull(4)
        } else {
          statement.bindText(4, _tmpImageUri)
        }
        statement.bindText(5, entity.reminderTime)
        statement.bindLong(6, entity.id.toLong())
      }
    }
  }

  public override suspend fun insertBirthday(birthday: Birthday): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfBirthday.insert(_connection, birthday)
  }

  public override suspend fun deleteBirthday(birthday: Birthday): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfBirthday.handle(_connection, birthday)
  }

  public override suspend fun updateBirthday(birthday: Birthday): Unit = performSuspending(__db, false, true) { _connection ->
    __updateAdapterOfBirthday.handle(_connection, birthday)
  }

  public override fun getAllBirthdays(): Flow<List<Birthday>> {
    val _sql: String = "SELECT * FROM birthdays ORDER BY name ASC"
    return createFlow(__db, false, arrayOf("birthdays")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfDateOfBirth: Int = getColumnIndexOrThrow(_stmt, "dateOfBirth")
        val _columnIndexOfImageUri: Int = getColumnIndexOrThrow(_stmt, "imageUri")
        val _columnIndexOfReminderTime: Int = getColumnIndexOrThrow(_stmt, "reminderTime")
        val _result: MutableList<Birthday> = mutableListOf()
        while (_stmt.step()) {
          val _item: Birthday
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpDateOfBirth: String
          _tmpDateOfBirth = _stmt.getText(_columnIndexOfDateOfBirth)
          val _tmpImageUri: String?
          if (_stmt.isNull(_columnIndexOfImageUri)) {
            _tmpImageUri = null
          } else {
            _tmpImageUri = _stmt.getText(_columnIndexOfImageUri)
          }
          val _tmpReminderTime: String
          _tmpReminderTime = _stmt.getText(_columnIndexOfReminderTime)
          _item = Birthday(_tmpId,_tmpName,_tmpDateOfBirth,_tmpImageUri,_tmpReminderTime)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getBirthdayById(id: Int): Birthday? {
    val _sql: String = "SELECT * FROM birthdays WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfDateOfBirth: Int = getColumnIndexOrThrow(_stmt, "dateOfBirth")
        val _columnIndexOfImageUri: Int = getColumnIndexOrThrow(_stmt, "imageUri")
        val _columnIndexOfReminderTime: Int = getColumnIndexOrThrow(_stmt, "reminderTime")
        val _result: Birthday?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpDateOfBirth: String
          _tmpDateOfBirth = _stmt.getText(_columnIndexOfDateOfBirth)
          val _tmpImageUri: String?
          if (_stmt.isNull(_columnIndexOfImageUri)) {
            _tmpImageUri = null
          } else {
            _tmpImageUri = _stmt.getText(_columnIndexOfImageUri)
          }
          val _tmpReminderTime: String
          _tmpReminderTime = _stmt.getText(_columnIndexOfReminderTime)
          _result = Birthday(_tmpId,_tmpName,_tmpDateOfBirth,_tmpImageUri,_tmpReminderTime)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteAllBirthdays() {
    val _sql: String = "DELETE FROM birthdays"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
