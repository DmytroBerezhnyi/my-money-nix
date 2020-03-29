package com.xinosluitsnoi.mymoney.domain.database

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.CategoryEntry
import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry

import com.xinosluitsnoi.mymoney.domain.database.entity.TransactionCursorWrapper
import com.xinosluitsnoi.mymoney.domain.entity.Category
import com.xinosluitsnoi.mymoney.domain.entity.Transaction
import com.xinosluitsnoi.mymoney.domain.mapper.TransactionFromDBMapper
import com.xinosluitsnoi.mymoney.domain.mapper.TransactionToDBMapper
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository

import java.util.ArrayList

class DBTransactionRepository(dbHelper: DBHelper) : TransactionRepository {

    private val database: SQLiteDatabase = dbHelper.readableDatabase

    private val categoryRepository: CategoryRepository

    private val transactionToDBMapper: TransactionToDBMapper

    private val transactionFromDBMapper: TransactionFromDBMapper

    init {
        categoryRepository = DBCategoryRepository(dbHelper)
        transactionToDBMapper = TransactionToDBMapper()
        transactionFromDBMapper = TransactionFromDBMapper()
    }

    override fun add(transaction: Transaction) {
        val values = transactionToDBMapper.map(transaction)
        val id = database.insert(TransactionEntry.TABLE_NAME, null, values)

        transaction.id = id
    }

    override fun update(transaction: Transaction) {
        val values = transactionToDBMapper.map(transaction)

        database.update(
            TransactionEntry.TABLE_NAME,
            values,
            TransactionEntry._ID + "=" + transaction.id, null
        )
    }

    override fun delete(transaction: Transaction) {
        val query =
            "DELETE FROM ${TransactionEntry.TABLE_NAME} WHERE ${TransactionEntry._ID} = ${transaction.id};"
        database.execSQL(query)
    }

    override fun getTransactionsByCategory(category: Category): List<Transaction> {
        val transactions = ArrayList<Transaction>()
        var transaction: Transaction
        val query =
            "SELECT * FROM ${TransactionEntry.TABLE_NAME} WHERE ${TransactionEntry.CATEGORY} = ${category.id}"

        database.rawQuery(query, null).use { cursor ->
            TransactionCursorWrapper(cursor).use { cursorWrapper ->
                if (cursorWrapper.moveToFirst()) {
                    do {
                        transaction = transactionFromDBMapper.map(cursorWrapper)
                        transaction.category = category
                        transactions.add(transaction)
                    } while (cursorWrapper.moveToNext())
                }
            }
        }

        return transactions
    }

    override fun getAll(@Category.Type.Mode type: Int): List<Transaction> {
        val transactions = ArrayList<Transaction>()
        var transaction: Transaction

        val query: String = if (type == Category.Type.Mode.ALL) {
            "SELECT * FROM ${TransactionEntry.TABLE_NAME}"
        } else {
            "SELECT * FROM ${TransactionEntry.TABLE_NAME} " +
                    "WHERE ${TransactionEntry.CATEGORY} = " +
                    "(SELECT ${CategoryEntry._ID} FROM ${CategoryEntry.TABLE_NAME} WHERE " +
                    "$type = ${CategoryEntry.TYPE} OR " +
                    "${CategoryEntry.TYPE} = ${Category.Type.Mode.ALL})"
        }

        database.rawQuery(query, null).use { cursor ->
            TransactionCursorWrapper(cursor).use { cursorWrapper ->
                if (cursorWrapper.moveToFirst()) {
                    do {
                        transaction = transactionFromDBMapper.map(cursorWrapper)
                        insertCategory(transaction)
                        transactions.add(transaction)
                    } while (cursorWrapper.moveToNext())
                }
            }
        }

        return transactions
    }

    // FIXME: 14.08.19 Is performance ok if we categoryRepository.getCategory many times?
    //  Should add to categoryRepository.getCategories(@NonNull List<Integer> ids)
    private fun insertCategory(transaction: Transaction) {
        val category = categoryRepository.getCategory(transaction.category.id)
        if (category != null) {
            transaction.category = category
        } else {
            Log.e(TAG, "getAll:cant find category by id " + transaction.category.id)
        }
    }

    companion object {

        private val TAG = DBTransactionRepository::class.java.simpleName
    }
}