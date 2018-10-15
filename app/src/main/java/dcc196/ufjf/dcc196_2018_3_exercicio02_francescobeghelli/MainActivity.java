package dcc196.ufjf.dcc196_2018_3_exercicio02_francescobeghelli;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCadEpisodio;
    //private Button btnListarEpisodio;
    private ListView scrListaEpisodios;
    private SQLiteDatabase db;
    private CursorAdapter dataSource;

    EpisodioDbHelper helper;

    private static final String campos[] = {"nome", "temporada", "num_episodio", "_id"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadEpisodio = (Button)findViewById(R.id.btnCadastroEpis);
        scrListaEpisodios = (ListView)findViewById(R.id.lstViewEpis);
        //btnListarEpisodio = (Button)findViewById(R.id.btnListarEpisodios);


        helper = new EpisodioDbHelper(this);
        db = helper.getWritableDatabase();
        Cursor epiCursor = db.rawQuery("SELECT  * FROM Episodio", null);
        EpiAdapter epiAdapter = new EpiAdapter(this, epiCursor);

        scrListaEpisodios.setAdapter(epiAdapter);


        btnCadEpisodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CadastroEpiActivity.class);
                startActivity(i);
            }
        });



    }


    /*public void btnListarEpisodio(View v){
        Cursor episodios = db.query("Episodios", campos, null, null, null, null, null);

        if (episodios.getCount() > 0) {
            dataSource = new SimpleCursorAdapter(this, R.layout.activity_cadastro_epi, episodios,
                    campos, new int[]{R.id.editNomeSerie, R.id.editNumeroTemp, R.id.editNumeroEpis});

            scrListaEpisodios.setAdapter(dataSource);
        } else {
            Toast.makeText(this, "Nenhum registro encontrado", Toast.LENGTH_SHORT).show();
        }
    }*/
}
