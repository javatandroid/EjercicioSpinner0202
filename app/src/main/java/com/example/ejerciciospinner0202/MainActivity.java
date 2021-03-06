package com.example.ejerciciospinner0202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spTest;
    RadioGroup rgRespuesta;
    CheckBox cbRepetida;
    Button btnPregunta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificamos las vistas
        spTest = (Spinner)findViewById(R.id.spTest);
        rgRespuesta = (RadioGroup)findViewById(R.id.rgTest);
        cbRepetida = (CheckBox)findViewById(R.id.cbPregunta);
        btnPregunta = (Button) findViewById(R.id.btnEnviar);

        //Rellenar el Spinner
        String[] tipos={"Selecciona","Seguridad", "Velocidad", "Mecánica", "Vial"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,tipos);
        spTest.setAdapter(adaptador);

    }//FIN ON CREATE

    //Detectamos los onClick
    public void clickTipoTest(View view){
        //Recoger el item seleccionado de un Spinner
        String tipoSeleccionado = spTest.getSelectedItem().toString();

        /* Validación: Si el tipoSeleccionad oes igual a "Selecciona", avisaremos al usuario de que tiene que seleccionar algún tipo,
        si no, lo mostraremos en un toast */
        if(tipoSeleccionado.equals("Selecciona")){
            Toast.makeText(this, "Debes de seleccionar un tipo de test",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Text seleccionado: "+tipoSeleccionado,Toast.LENGTH_SHORT).show();
            btnPregunta.setEnabled(true);
        }

        }

    public void clickEnviarRespuesta(View view){
        //Obtenemos la id del Radiobutton seleccionado dentro del radiogroup
        int idRadio = rgRespuesta.getCheckedRadioButtonId();

        if (idRadio == -1) {
            Toast.makeText(this, "Debes de seleccionar una respuesta", Toast.LENGTH_SHORT).show();

        }else{
        //Creamos un objeto RadioButton desde la id obtenida
        RadioButton radioButtonSeleccionado = (RadioButton)findViewById(idRadio);
        //Del objeto Radiobutton creado obtenemos el texto del mismo
        String textoRadioSeleccionado = radioButtonSeleccionado.getText().toString();
        Toast.makeText(this, "Opción seleccionada "+textoRadioSeleccionado,Toast.LENGTH_SHORT).show();

        //Comprobar si el checkbox está seleccionado
            boolean esRepetida=false;

            if(cbRepetida.isChecked()){
                esRepetida=true;
            }

            if(esRepetida){
                Toast.makeText(this, "Esta pregunta ya la has contestado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Opción seleccionada"+textoRadioSeleccionado, Toast.LENGTH_SHORT).show();
            }
        }
    }
}//FIN MAIN
