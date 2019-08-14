package com.xinosluitsnoi.mymoney.domain.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.xinosluitsnoi.mymoney.domain.database.DatabaseDescriptor.TransactionEntry;
import com.xinosluitsnoi.mymoney.domain.database.entity.TransactionCursorWrapper;
import com.xinosluitsnoi.mymoney.domain.entity.Category;
import com.xinosluitsnoi.mymoney.domain.entity.Transaction;
import com.xinosluitsnoi.mymoney.domain.mapper.TransactionFromDBMapper;
import com.xinosluitsnoi.mymoney.domain.mapper.TransactionToDBMapper;
import com.xinosluitsnoi.mymoney.domain.repository.CategoryRepository;
import com.xinosluitsnoi.mymoney.domain.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class DBTransactionRepository implements TransactionRepository {

    @NonNull
    private static final String TAG = DBTransactionRepository.class.getSimpleName();

    @NonNull
    private final SQLiteDatabase database;

    @NonNull
    private final CategoryRepository categoryRepository;

    @NonNull
    private final TransactionToDBMapper transactionToDBMapper;

    @NonNull
    private final TransactionFromDBMapper transactionFromDBMapper;

    public DBTransactionRepository(@NonNull DBHelper dbHelper) {
        database = dbHelper.getReadableDatabase();
        categoryRepository = new DBCategoryRepository(dbHelper);
        transactionToDBMapper = new TransactionToDBMapper();
        transactionFromDBMapper = new TransactionFromDBMapper();
    }

    @Override
    public void add(@NonNull Transaction transaction) {
        ContentValues values = transactionToDBMapper.map(transaction);
        long id = database.insert(DatabaseDescriptor.TransactionEntry.TABLE_NAME,
                                  null,
                                  values);

        transaction.setId(id);
    }

    @Override
    public void update(@NonNull Transaction transaction) {
        ContentValues values = transactionToDBMapper.map(transaction);

        database.update(TransactionEntry.TABLE_NAME,
                        values,
                        TransactionEntry._ID
                                + "="
                                + transaction.getId(),
                        null);
    }

    @Override
    public void delete(@NonNull Transaction transaction) {
        String query = "DELETE FROM " + TransactionEntry.TABLE_NAME + " WHERE " +
                TransactionEntry._ID + " = " + transaction.getId() + ";";

        database.execSQL(query);
    }

    @NonNull
    @Override
    public List<Transaction> getTransactionsByCategory(@NonNull Category category) {
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        String query = "SELECT * FROM "
                + TransactionEntry.TABLE_NAME
                + " WHERE "
                + TransactionEntry.CATEGORY
                + " = "
                + category.getId();

        try (Cursor cursor = database.rawQuery(query, null);
             TransactionCursorWrapper cursorWrapper = new TransactionCursorWrapper(cursor)) {
            if (cursorWrapper.moveToFirst()) {
                do {
                    transaction = transactionFromDBMapper.map(cursorWrapper);
                    transaction.setCategory(category);
                    transactions.add(transaction);
                } while (cursorWrapper.moveToNext());
            }
        }

        return transactions;
    }

    @NonNull
    @Override
    public List<Transaction> getAll(@Transaction.Type.Mode int type) {
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction;
        String query = "SELECT * FROM " + TransactionEntry.TABLE_NAME + " WHERE "
                + TransactionEntry.TYPE + " = " + type;

        try (Cursor cursor = database.rawQuery(query, null);
             TransactionCursorWrapper cursorWrapper = new TransactionCursorWrapper(cursor)) {
            if (cursorWrapper.moveToFirst()) {
                do {
                    transaction = transactionFromDBMapper.map(cursorWrapper);
                    insertCategory(transaction);
                    transactions.add(transaction);

                } while (cursorWrapper.moveToNext());
            }

        }

        return transactions;
    }

    // FIXME: 14.08.19 Is performance ok if we categoryRepository.getCategory many times?
    //  Should add to categoryRepository.getCategories(@NonNull List<Integer> ids)
    private void insertCategory(@NonNull Transaction transaction) {
        Category category = categoryRepository.getCategory(transaction.getCategory().getId());
        if (category != null) {
            transaction.setCategory(category);
        } else {
            Log.e(TAG, "getAll:cant find category by id " + transaction.getCategory().getId());
        }
    }
}