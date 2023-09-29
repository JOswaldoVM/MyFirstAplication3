package com.l20291025.myfirstaplication3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20291025.myfirstaplication3.usuario.DashboardUuario;
import com.l20291025.myfirstaplication3.usuario.repository.UsuarioRepository;

import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    //private HashMap<String, String> registeredUsers = new HashMap<String,String>();
    private UsuarioRepository ur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ur = UsuarioRepository.getInstance();

        /*
        registeredUsers.put("Oswa","1234");
        registeredUsers.put("Jose","papas");
        registeredUsers.put("Emma","lol");
         */

    }
    private AlertDialog createAlertDialog(String titulo, String message){
            //Mensaje interactivo o invasivo refactorizado
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titulo)
                .setMessage(message);
        return builder.create();
    }

    public void onBtnIngresar(View view){
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //AlertDialog dialog = builder.create();

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);

        String user, pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if(!ur.getRegisteredUsers().containsKey(user)) {
            //dialog.setTitle("Felicidades presionaste el botón");
            //dialog.setMessage("Usuario no registrado");
            this.createAlertDialog("Atención","Usuario no registrado").show();
            //dialog.show();
            return;
        }

        if(!ur.getRegisteredUsers().get(user).containsKey(pass)) {
            //dialog.setTitle("Atención");
            //dialog.setMessage("La contraseña no conincide");
            this.createAlertDialog("Atención","La contraseña no coincide").show();
            //dialog.show();
            return;
        }

        //dialog.setTitle("Felicidades has iniciado sesión");
        //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s\nPassword: %s", user, pass));

        //dialog.show();
        String message = "Felicidades ha iniciado sesion con exito";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        // Cambiar de pantalla
        // Primer parametro quien lo va a invocar
        //Segundo parametro quien esta siendo invocado
        Intent i = new Intent(this, DashboardUuario.class);
        i.putExtra("usuario", user);
        i.putExtra("pass", pass);
        startActivity(i);

    }
}