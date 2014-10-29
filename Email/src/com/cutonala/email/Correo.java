package com.cutonala.email;





import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Correo extends ActionBarActivity {
	
	private Button boton;
	private EditText destinatario,asunto,mensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.correo);
		
		boton = (Button) findViewById(R.id.btnEnviar);
		destinatario = (EditText) findViewById(R.id.txtCorreo);
		asunto = (EditText) findViewById(R.id.txtAsunto);
		mensaje = (EditText) findViewById(R.id.txtMensaje);
		
		boton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!destinatario.getText().toString().equals(""))
				{
					enviarMail(v);
				}
			}
		});
	}
	
	@SuppressWarnings("static-access")
	public void enviarMail(View v)
	{
		Intent mailIntent = new Intent(Intent.ACTION_SEND);
		mailIntent.setType("text/plain");//tipo texto plain o html
		mailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[]{destinatario.getText().toString()});
		mailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto.getText().toString());
		mailIntent.putExtra(Intent.EXTRA_SUBJECT, mensaje.getText().toString());
		
		try{
			startActivity(mailIntent.createChooser(mailIntent, "Enviando Correo"));
		}catch(Exception e){
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
