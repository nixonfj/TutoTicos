package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class act_materia extends AppCompatActivity {

    private Button btnAddMateria;
    private LinearLayout lytMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_materia);

        btnAddMateria = findViewById(R.id.btnAddMateria);
        lytMateria = findViewById(R.id.lytMateria);

        btnAddMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMateria();
            }
        });
    }

    private void addMateria(){
        View nuevaVista = getLayoutInflater().inflate(R.layout.materia_persona, null,false);

        Spinner spMateria;

        spMateria = nuevaVista.findViewById(R.id.spMateria);


        String [] opciones= {"Español", "Matemáticas", "Estudios Sociales", "Ciencias", "Civica", "Química", "Biología", "Física Mate"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);
        spMateria.setAdapter(adapter);

        lytMateria.addView(nuevaVista);
    }
}