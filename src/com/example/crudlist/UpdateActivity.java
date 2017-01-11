package com.example.crudlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends Activity implements OnClickListener {
	
	EditText txtName;
	Button btnSave, btnCancel;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.updateitem);
		
		this.txtName=(EditText) this.findViewById(R.id.editText1);
		this.btnSave=(Button) this.findViewById(R.id.button1);
		this.btnCancel=(Button) this.findViewById(R.id.button2);
		this.btnCancel.setOnClickListener(this);
		this.btnSave.setOnClickListener(this);
		
		Intent intent=this.getIntent();
		Bundle b=intent.getExtras();
		if(b!=null){
			String updatename=b.getString("updatename");
			this.txtName.setText(updatename);
		}
		
		
	}


	@Override
	public void onClick(View arg0) {
		int id=arg0.getId();
		switch(id){
		case R.id.button1: //save
			String name=this.txtName.getText().toString();
			Intent intent=new Intent(); //blind intent, responds to any unspecified calles
			intent.putExtra("myname", name);
			this.setResult(Activity.RESULT_OK, intent);
			
		case R.id.button2: 
			this.finish();//terminate the activity
		}
		
	}
	
}
