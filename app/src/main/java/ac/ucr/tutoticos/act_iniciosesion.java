package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class act_iniciosesion extends AppCompatActivity {

    Button btn_ingresar;
    TextView txt_registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_iniciosesion);

        btn_ingresar = findViewById(R.id.btn_ingresar);

        txt_registrarse = findViewById(R.id.inision_txt_registarse);

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(act_iniciosesion.this, act_perfiltutor.class);
                startActivity(intent);
            }
        });

        txt_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(act_iniciosesion.this, act_registro.class);
                startActivity(intent);
            }
        });
    }//fin del onCreate

}//fin de la clase