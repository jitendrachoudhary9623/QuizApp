package com.quizapp.jitcodez.quizapp;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.quizapp.jitcodez.quizapp.database.QuizContract;
import com.quizapp.jitcodez.quizapp.database.QuizHelper;

import static com.quizapp.jitcodez.quizapp.database.QuizContract.QuizEntry.TABLE_NAME;

public class QuizContentProvider extends ContentProvider {

    public static final int QUIZ_ALL=999;
    public static final int QUIZ_ONE=1;
    private QuizHelper helper;
    public static final UriMatcher sURI_MATCHER=buildUriMatcher();
    public static UriMatcher buildUriMatcher()
    {
        UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(QuizContract.AUTHORITY,QuizContract.PATH,QUIZ_ALL);
        uriMatcher.addURI(QuizContract.AUTHORITY,QuizContract.PATH+"/#",QUIZ_ONE);
        return uriMatcher;
    }
    public QuizContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = helper.getWritableDatabase();

        int match = sURI_MATCHER.match(uri);
        int quizDeleted=0;

        switch (match) {
            case QUIZ_ONE:
                String id = uri.getPathSegments().get(1);
                quizDeleted = db.delete(TABLE_NAME, QuizContract.QuizEntry.QUESTION_ID+"=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (quizDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return quizDeleted;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        int match = sURI_MATCHER.match(uri);

        switch (match) {
            case QUIZ_ALL:
                return "vnd.android.cursor.dir/vnd.com.quizapp.jitcodez.quizapp.QUIZ";
            case QUIZ_ONE:
                return "vnd.android.cursor.item/vnd.com.quizapp.jitcodez.quizapp.QUIZ";
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);

        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        SQLiteDatabase db=helper.getReadableDatabase();


        int match = sURI_MATCHER.match(uri);
        Uri returnUri=null;
        switch (match) {
            case QUIZ_ALL:

                long id = db.insert(TABLE_NAME, null, values);
                if (id > 0) {
                    returnUri = ContentUris.withAppendedId(QuizContract.QuizEntry.CONTENT_URI, id);
                } else {
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                }
                break;
        }
        return  returnUri;
    }

    @Override
    public boolean onCreate() {
        helper=new QuizHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        final SQLiteDatabase db = helper.getReadableDatabase();

        int match = sURI_MATCHER.match(uri);
        Cursor cursor;

        switch (match) {
            case QUIZ_ALL:
                cursor =  db.query(TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
                break;
            case QUIZ_ONE:
                cursor =  db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
