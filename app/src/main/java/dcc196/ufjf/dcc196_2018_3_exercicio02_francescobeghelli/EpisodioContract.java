package dcc196.ufjf.dcc196_2018_3_exercicio02_francescobeghelli;

import android.provider.BaseColumns;

public final class EpisodioContract {

    public final class Episodio implements BaseColumns
    {
        public static final String TABLE_NAME = "Episodio";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_NUM_TEMP = "temporada";
        public static final String COLUMN_NAME_NUM_EP = "num_episodio";
        public static final String CREATE_EPISODIO = "CREATE TABLE " + Episodio.TABLE_NAME + " ("
                + Episodio._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Episodio.COLUMN_NAME_NOME + " TEXT, "
                + Episodio.COLUMN_NAME_NUM_EP + " INTEGER, "
                + Episodio.COLUMN_NAME_NUM_TEMP + " INTEGER "
                +")";
        public static final String DROP_EPISODIO = "DROP TABLE IF EXISTS " + Episodio.TABLE_NAME;
    }
}

