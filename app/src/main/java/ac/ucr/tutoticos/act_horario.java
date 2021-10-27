package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class act_horario extends AppCompatActivity {

    private Button btnNextMateria, btnAddHorario;
    private LinearLayout lytHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_horario);

        lytHorario = findViewById(R.id.lytMateria);
        btnNextMateria = findViewById(R.id.btnNextMateria);
        btnAddHorario = findViewById(R.id.btnAddMateria);

        btnNextMateria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent= new Intent (act_horario.this, act_materia.class);
                startActivity(intent);
            }
        });

        btnAddHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addView();
            }
        });

    }

    private void addView() {
        View nuevaVista = getLayoutInflater().inflate(R.layout.horario_persona, null,false);

        Spinner spDia;
        EditText txtHoraInicio, txtHoraFinal;
        ImageView eliminarFila;

        spDia = nuevaVista.findViewById(R.id.spDia);

        txtHoraInicio = nuevaVista.findViewById(R.id.txtHoraInicio);
        txtHoraFinal = nuevaVista.findViewById(R.id.txtHoraFinal);

        String [] opciones= {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);
        spDia.setAdapter(adapter);

        lytHorario.addView(nuevaVista);
    }
}