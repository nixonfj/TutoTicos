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

import ac.ucr.tutoticos.modelo.Tutor;

public class act_horario extends AppCompatActivity {

    private Button btn_continuar, btnAddHorario;
    private LinearLayout lytHorario;

    Tutor tutor = new Tutor();
    Tutor tutoR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_horario);

        lytHorario = findViewById(R.id.lytMateria);
        btn_continuar = findViewById(R.id.btn_continuar_horario);
        btnAddHorario = findViewById(R.id.btnAddMateria);

        tutoR = getIntent().getParcelableExtra("tutor");

        btn_continuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

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

                Intent intent= new Intent (act_horario.this, act_registroTutor.class);
                intent.putExtra("tutor", tutor);
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