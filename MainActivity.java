package contact.arun;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private static final int CONTACT_PICKER_RESULT = 1001;

	EditText ed;
	Button b;
	Intent cpintent;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ed=(EditText) findViewById(R.id.editText1);
		 		try {
		 			Intent cpintent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
			startActivityForResult(cpintent, 1001);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.i("justtag",e.toString());
			cpintent=null;
		}
		 
		 
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		
		 if (resultCode == Activity.RESULT_OK) 
		 {  
		    Uri contactData = data.getData();  
		    Cursor c =  managedQuery(contactData, null, null, null, null);  
		    if (c.moveToFirst()) 
		    {  
		    	String name = c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));  
		    	ed.setText(name);  
		    }  
	}
	}
}

	


