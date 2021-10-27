package ac.ucr.tutoticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import ac.ucr.tutoticos.modelo.Cuenta;
import ac.ucr.tutoticos.modelo.Tutor;

public class act_registroTutor extends AppCompatActivity {

    private static SQLiteDatabase db;//definicion de la base de datos
    private  static final String TUTOR_BD = "MultiSQLite";//nombre de la base de datos
    private final String TABLA_TUTOR = "tutor";//nombre de la tabla

    Tutor addTutor;
    Cuenta loginCuenta;
    ArrayList<Tutor> tutores;

    public  static  final  String tbTutor = "CREATE TABLE IF NOT EXISTS" +
            " tutor(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombreUsuario String NOT NULL," +
            "nombreCompleto String NOT NULL," +
            "correoUsuario String NOT NULL," +
            "contrasena String NOT NULL," +
            "tipoCuenta INTEGER NOT NULL," +
            "idEspecialidad INTEGER NOT NULL," +
            "edad INTEGER NOT NULL," +
            "sexo String NOT NULL," +
            "precio DOUBLE NOT NULL," +
            "descripcion String NOT NULL," +
            "calidicacion DOUBLE NOT NULL," +
            "modalidad String NOT NULL/*"+
            "picture BLOB*/);";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro_tutor);

        //deleteDatabase(TUTOR_BD);
        abrirDBTutor();

        addTutor = getIntent().getParcelableExtra("tutor");
        loginCuenta = getIntent().getParcelableExtra("login");

        if (addTutor != null)
        {
            if(agregarTutor(addTutor))
            {
                Intent intent = new Intent(act_registroTutor.this, act_perfiltutor.class);
                Tutor t = getTutor(getListaTutores(), addTutor.getNombreUsuario());
                intent.putExtra("tutor", t);
                startActivity(intent);
            }
        }

        if(loginCuenta != null){
            Tutor logT = getCuentaLogin(getListaTutores(), loginCuenta.getNombreUsuario());
            if(logT != null){
                if(logT.getContrasenna().equalsIgnoreCase(loginCuenta.getContrasenna())){
                    Intent intent = new Intent(act_registroTutor.this, act_perfiltutor.class);
                    intent.putExtra("tutor", logT);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorracta",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent (act_registroTutor.this, act_iniciosesion.class);
                    startActivity(intent);
                }

            }else{
                Toast.makeText(getApplicationContext(),"usuario no encontrado",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent (act_registroTutor.this, act_iniciosesion.class);
                startActivity(intent);
            }

        }
        else {
            Toast.makeText(getApplicationContext(),"usuario no encontrado",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent (act_registroTutor.this, act_iniciosesion.class);
            startActivity(intent);
        }

    }//fin del onCreate

    public boolean agregarTutor(Tutor t){

        ContentValues content = new ContentValues();

        content.put("nombreUsuario", t.getNombreUsuario());
        content.put("nombreCompleto", t.getNombreCompleto());
        content.put("correoUsuario", t.getCorreoUsuario());
        content.put("contrasena", t.getContrasenna());
        content.put("tipoCuenta", t.getTipoCuenta());
        content.put("idEspecialidad", t.getIdEspecialidad());
        content.put("edad", t.getEdad());
        content.put("sexo", t.getSexo());
        content.put("precio", t.getPrecio());
        content.put("descripcion", t.getDescripcion());
        content.put("calidicacion", t.getCalificacion());
        content.put("modalidad", t.getModalidad());
        //content.put("picture", t.getImgUser());

        return db.insert(TABLA_TUTOR, null,content) > 0;

    }//fin del metodo

    public boolean actualizarTutor(Tutor t){

        ContentValues content = new ContentValues();

        content.put("nombreUsuario", t.getNombreUsuario());
        content.put("nombreCompleto", t.getNombreCompleto());
        content.put("correoUsuario", t.getCorreoUsuario());
        content.put("contrasena", t.getContrasenna());
        content.put("tipoCuenta", t.getTipoCuenta());
        content.put("idEspecialidad", t.getIdEspecialidad());
        content.put("edad", t.getEdad());
        content.put("sexo", t.getSexo());
        content.put("precio", t.getPrecio());
        content.put("descripcion", t.getDescripcion());
        content.put("calidicacion", t.getCalificacion());
        content.put("modalidad", t.getModalidad());
        //content.put("picture", t.getImgUser());

        return db.update(TABLA_TUTOR, content, "id="+t.getIdCuenta(), null) > 0;

    }//fin del metodo

    private ArrayList<Tutor> getListaTutores(){
        Cursor cursor = db.query(TABLA_TUTOR, new String[]{"id", "nombreUsuario", "nombreCompleto", "correoUsuario", "contrasena", "tipoCuenta", "idEspecialidad", "edad", "sexo", "precio", "descripcion", "calidicacion", "modalidad"},
                null, null, null, null, "id desc");

        cursor.moveToFirst();
        ArrayList<Tutor> listaT = new ArrayList<>();

        while (!cursor.isAfterLast()){

            Tutor tuto = new Tutor();

            tuto.setIdCuenta(cursor.getInt(0));
            tuto.setNombreUsuario(cursor.getString(1));
            tuto.setNombreCompleto(cursor.getString(2));
            tuto.setCorreoUsuario(cursor.getString(3));
            tuto.setContrasenna(cursor.getString(4));
            tuto.setTipoCuenta(cursor.getInt(5));
            tuto.setIdEspecialidad(cursor.getInt(6));
            tuto.setEdad(cursor.getInt(7));
            tuto.setSexo(cursor.getString(8));
            tuto.setPrecio(cursor.getDouble(9));
            tuto.setDescripcion(cursor.getString(10));
            tuto.setCalificacion(cursor.getDouble(11));
            tuto.setModalidad(cursor.getString(12));
            //tuto.setImgUser(cursor.getBlob(13));

            listaT.add(tuto);
            cursor.moveToNext();

        }//fin del while

        cursor.close();
        return listaT;

    }//fin del metodo

    public Tutor getTutor(ArrayList<Tutor> list, String user){
        for (int i = 0; i <= list.size(); i++){
            if(list.get(i).getNombreUsuario().equalsIgnoreCase(user))
            {
                return list.get(i);
            }
        }
        return null;
    }//fin del metodo

    public Tutor getCuentaLogin(ArrayList<Tutor> list, String user){
        if(list.size() > 0)
        {
            for (int i=0; i <= list.size(); i++){
                if(list.get(i).getNombreUsuario().equalsIgnoreCase(user))
                {
                    return list.get(i);
                }
                else
                {
                    return null;
                }
            }
        }
    return null;

    }//fin del metodo

    public void abrirDBTutor(){
        try {
            db = openOrCreateDatabase(TUTOR_BD, MODE_PRIVATE, null);
            db .execSQL(tbTutor);

        }catch (SQLiteOutOfMemoryException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Error al crear la base de datos", Toast.LENGTH_SHORT).show();
        }

    }//fin del metodo

}//fin de la clase