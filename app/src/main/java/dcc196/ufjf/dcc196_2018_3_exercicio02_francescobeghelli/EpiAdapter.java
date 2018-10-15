package dcc196.ufjf.dcc196_2018_3_exercicio02_francescobeghelli;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EpiAdapter extends CursorAdapter {

    public EpiAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView editNomeSerie = (TextView) view.findViewById(R.id.editNomeSerie);
        TextView editNumeroTemp = (TextView) view.findViewById(R.id.editNumeroTemp);
        TextView editNumeroEpis = (TextView) view.findViewById(R.id.editNumeroEpis);

        String nomeSerie = cursor.getString(cursor.getColumnIndexOrThrow(EpisodioContract.Episodio.COLUMN_NAME_NOME));
        int numTemp = cursor.getInt(cursor.getColumnIndexOrThrow(EpisodioContract.Episodio.COLUMN_NAME_NUM_TEMP));
        int numEpi = cursor.getInt(cursor.getColumnIndexOrThrow(EpisodioContract.Episodio.COLUMN_NAME_NUM_EP));

        editNomeSerie.setText(nomeSerie);
        editNumeroTemp.setText(String.valueOf(numTemp));
        editNumeroEpis.setText(String.valueOf(numEpi));
    }
}
