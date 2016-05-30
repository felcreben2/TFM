package com.example.tfm;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Reproducir extends Activity implements TextToSpeech.OnInitListener
{
	private TextToSpeech textToSpeech;
	private EditText editText;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.repro );

		final Button btnSpanish = ( Button ) findViewById( R.id.btnSpanish );

		textToSpeech = new TextToSpeech( this, this );
		editText = ( EditText ) findViewById( R.id.editTextWords );

		btnSpanish.setOnClickListener( new View.OnClickListener()
		{
			@Override public void onClick( View v )
			{
				textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
				speak( editText.getText().toString() );
			}
		} );

	}

	@Override
	public void onInit( int status )
	{
		if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
		{
			Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
		}
	}

	private void speak( String str )
	{
		textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
		textToSpeech.setSpeechRate( 0.0f );
		textToSpeech.setPitch( 0.0f );
	}

	@Override
	protected void onDestroy()
	{
		if ( textToSpeech != null )
		{
			textToSpeech.stop();
			textToSpeech.shutdown();
		}
		super.onDestroy();
	}
}
