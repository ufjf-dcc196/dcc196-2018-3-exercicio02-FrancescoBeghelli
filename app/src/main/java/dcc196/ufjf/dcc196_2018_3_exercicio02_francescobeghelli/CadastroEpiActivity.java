package dcc196.ufjf.dcc196_2018_3_exercicio02_francescobeghelli;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroEpiActivity extends AppCompatActivity {

    private Button btnCancelar;
    private Button btnSalvar;
    private EpisodioDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_epi);

        btnCancelar = (Button)findViewById(R.id.btnExcluir);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSalvar = (Button)findViewById(R.id.btnAdicionar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeSerie = ((EditText)findViewById(R.id.editNomeSerie)).getText().toString();
                String numEpisodio = ((EditText)findViewById(R.id.editNumeroEpis)).getText().toString();
                String numTemporada = ((EditText)findViewById(R.id.editNumeroTemp)).getText().toString();

                if(nomeSerie == "" || numEpisodio == "" || numTemporada == "")
                {
                    Toast.makeText(CadastroEpiActivity.this,"Você precisa preencher todos os campos",Toast.LENGTH_LONG).show();
                    return;
                }


                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(EpisodioContract.Episodio.COLUMN_NAME_NOME, nomeSerie);
                values.put(EpisodioContract.Episodio.COLUMN_NAME_NUM_EP, Integer.parseInt(numEpisodio));
                values.put(EpisodioContract.Episodio.COLUMN_NAME_NUM_TEMP, Integer.parseInt(numTemporada));

                long id = db.insert(EpisodioContract.Episodio.TABLE_NAME,null,values);

                finish();
            }
        });

    }
}
