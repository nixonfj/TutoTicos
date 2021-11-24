package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

import ac.ucr.tutoticos.modelo.Materia;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_materia extends AppCompatActivity {

    private Button btnAddMateria, btn_continuar;
    private LinearLayout lytMateria;
    Spinner spMateria;

    Tutor tutor = new Tutor();
    Tutor tutoR;

    Materia materia;
    ArrayList<Materia> listaM = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_materia);

        btnAddMateria = findViewById(R.id.btnAddMateria);
        btn_continuar = findViewById(R.id.btn_continuar_materia);

        lytMateria = findViewById(R.id.lytMateria);

        tutoR = getIntent().getParcelableExtra("tutor");

        //----------------------------------------------
        btnAddMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMateria();
                //agregado de la materia seleccionada a la lista
                Materia mat= new Materia(spMateria.getSelectedItem().toString());
                listaM.add(mat);
            }
        });

        btn_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tutor.setMateria(listaM);

                tutor.setIdCuenta(tutoR.getIdCuenta());
                tutor.setNombreUsuario(tutoR.getNombreUsuario());
                tutor.setNombre(tutoR.getNombre());
                tutor.setApellido(tutoR.getApellido());
                tutor.setCorreoUsuario(tutoR.getCorreoUsuario());
                tutor.setContrasenna(tutoR.getContrasenna());
                tutor.setTipoCuenta(tutoR.getTipoCuenta());
                tutor.setIdEspecialidad(tutoR.getIdEspecialidad());
                tutor.setEdad(tutoR.getEdad());
                tutor.setSexo(tutoR.getSexo());
                tutor.setDescripcion(tutoR.getDescripcion());
                tutor.setModalidad(tutoR.getModalidad());
                tutor.setPrecio(tutoR.getPrecio());
                tutor.setCalificacion(tutoR.getCalificacion());
                tutor.setImgUser(tutoR.getImgUser());


                Intent intent = new Intent(act_materia.this, act_horario.class);
                intent.putExtra("tutor", tutor);
                startActivity(intent);
            }
        });

    }//fin del on create

    private void addMateria(){
        View nuevaVista = getLayoutInflater().inflate(R.layout.materia_persona, null,false);

        spMateria = nuevaVista.findViewById(R.id.spMateria);

        String [] opciones= {"Español", "Matemáticas", "Estudios Sociales", "Ciencias", "Civica", "Química", "Biología", "Física Mate"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_persona, opciones);

        spMateria.setAdapter(adapter);

        lytMateria.addView(nuevaVista);

    }//fin del metodo add_materia

}//fin de la clase