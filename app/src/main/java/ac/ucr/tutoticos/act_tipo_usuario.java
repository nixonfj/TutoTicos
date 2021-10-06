package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act_tipo_usuario extends AppCompatActivity {

    Button btn_tutor, btn_estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_tipo_usuario);

        btn_tutor = findViewById(R.id.tipoCuenta_btn_tutor);
        btn_estudiante = findViewById(R.id.tipoCuenta_btn_estudiante);

        btn_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_tipo_usuario.this, act_perfiltutor.class);
                startActivity(intent);
            }
        });

        btn_estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(act_tipo_usuario.this, act_pantalla_principal.class);
                startActivity(intent);
            }
        });
    }
}