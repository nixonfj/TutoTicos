package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ac.ucr.tutoticos.modelo.Tutor;

public class act_perfiltutor extends AppCompatActivity {

    Button btn_editar, btn_verMas;
    TextView txt_nombre, txt_apellidos, txt_descripcion;

    Tutor tutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_perfiltutor);

        btn_editar = findViewById(R.id.perfilTutor_btn_editarPerfil);
        btn_verMas = findViewById(R.id.perfilTutor_btn_verMas);

        txt_nombre = findViewById(R.id.perfiltutor_txt_nombre);
        txt_apellidos = findViewById(R.id.perfiltutor_txt_apellido);
        txt_descripcion = findViewById(R.id.perfiltutor_txt_descripcion);

        tutor = getIntent().getParcelableExtra("tutor");

        //Settear espacios
        if(tutor != null){
            txt_nombre.setText(tutor.getNombreCompleto());
            txt_apellidos.setText(tutor.getNombreCompleto());
            txt_descripcion.setText(tutor.getDescripcion());
        }

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_perfiltutor.this, act_datos_principales.class);
                startActivity(intent);
            }
        });
        btn_verMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_perfiltutor.this, act_datos_principales.class);
                startActivity(intent);
            }
        });

    }//fin del onCreate

}//fin del la clase