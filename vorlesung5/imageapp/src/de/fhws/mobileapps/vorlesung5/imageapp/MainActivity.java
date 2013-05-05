package de.fhws.mobileapps.vorlesung5.imageapp;

import java.io.InputStream;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button button = (Button)findViewById(R.id.button1);
		button.setOnClickListener( new MyOnClickListener() );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class MyOnClickListener implements View.OnClickListener 
	{

		@Override
		public void onClick(View v) {
			new LoadFromNetwork().execute("http://backend.applab.fhws.de/images/skyfall.jpg");
//			new LoadFromNetwork().execute("http://lorempixel.com/300/300/people/");
		}
		
	}
	
	class LoadFromNetwork extends AsyncTask<String, Void, Drawable>
	{
		@Override
		protected Drawable doInBackground(String... from) {
			
			
			try
			{
				URL url = new URL( from[0] );
				InputStream is = (InputStream)url.getContent();
				
				return Drawable.createFromStream(is , "src");
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Drawable result) {
			super.onPostExecute(result);
			ImageView iv = (ImageView)findViewById(R.id.imageView1);
			iv.setImageDrawable(result);
		}
		
	}

}
