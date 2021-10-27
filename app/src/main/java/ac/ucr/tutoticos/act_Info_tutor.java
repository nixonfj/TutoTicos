package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class act_Info_tutor extends AppCompatActivity {

    private Spinner sp_sexo;
    private Button continuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_info_tutor);

        sp_sexo = findViewById(R.id.spSexo);
        continuar= findViewById(R.id.btnNextHorario);

        String [] opciones= {"Sexo", "Femenino", "Masculino", "Otro"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);
        sp_sexo.setAdapter(adapter);

        continuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_Info_tutor.this, act_horario.class);
                startActivity(intent);
            }
        });

    }
}