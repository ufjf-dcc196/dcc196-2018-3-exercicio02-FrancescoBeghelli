package dcc196.ufjf.dcc196_2018_3_exercicio02_francescobeghelli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadEpisodio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadEpisodio = (Button)findViewById(R.id.btnCadastroEpis);

        btnCadEpisodio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CadastroEpiActivity.class);
                startActivity(i);
            }
        });
    }
}
