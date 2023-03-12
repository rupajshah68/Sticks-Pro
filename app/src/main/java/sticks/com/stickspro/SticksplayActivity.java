package sticks.com.stickspro;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SticksplayActivity extends Activity implements OnItemSelectedListener {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main2);
        final boolean so=getIntent().getExtras().getBoolean("s");
        final MediaPlayer m=MediaPlayer.create(getApplicationContext(), R.raw.break_stick);
        final MediaPlayer mr=MediaPlayer.create(getApplicationContext(), R.raw.right);
        final MediaPlayer mw=MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        final Spinner sp2=(Spinner)findViewById(R.id.spinner3);
        final Spinner sp1=(Spinner)findViewById(R.id.spinner1);
        final TextView t=(TextView)findViewById(R.id.textView2);
        final ArrayAdapter<String> dataAdapter;
		final List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
		dataAdapter = new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1,list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		final ArrayAdapter<String> dataAdapter2;
		final List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        list2.add("7");
		dataAdapter2 = new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1,list2);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		final ArrayAdapter<String> dataAdapter3;
		final List<String> list3 = new ArrayList<String>();
        list3.add("1");
        list3.add("2");
        list3.add("3");
        list3.add("4");
        list3.add("5");
		dataAdapter3 = new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1,list3);
		dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String l=sp2.getSelectedItem().toString();
				int i=Integer.parseInt(l);
				if(i==2)
				{
					Spinner sp1=(Spinner)findViewById(R.id.spinner1);
					sp1.setAdapter(dataAdapter);
				}
				else if(i==3)
				{
					Spinner sp1=(Spinner)findViewById(R.id.spinner1);
					sp1.setAdapter(dataAdapter2);
				}
				else
				{
					Spinner sp1=(Spinner)findViewById(R.id.spinner1);
					sp1.setAdapter(dataAdapter3);
					
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Spinner sp1=(Spinner)findViewById(R.id.spinner1);
				sp1.setAdapter(dataAdapter3);
			}
        	
		});
        Button b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView t1=(TextView)findViewById(R.id.textView3);
				TextView t2=(TextView)findViewById(R.id.textView5);
				TextView t3=(TextView)findViewById(R.id.textView8);
				int l1=t1.getText().length();
				int l2=t2.getText().length();
				int l3=t3.getText().length();
				String s1=sp1.getSelectedItem().toString();
				int i1=Integer.parseInt(s1);
				String s2=sp2.getSelectedItem().toString();
				int i2=Integer.parseInt(s2);
				if(i2==1)
				{
					if(l1>=i1)
					{
						String str="";
						for(int in=1;in<=(l1-i1);in++)
						{
							str=str+"|";
						}
						t1.setText(str);
						l1=t1.getText().length();
						if(t.getText().toString().contains("1"))
						{
							if(l1 != 0 || l2 !=0 || l3 != 0)
							{
							t.setText("Turn of Player 2");
							if(so==true)
							{
								m.start();
							}
							}
							else
							{
								AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
								alertDialog.setTitle("Game over");
							    alertDialog.setMessage("Player 1 wins.");
							    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog,int which) {
						            	Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
						            	i1.putExtra("So",so);
										startActivity(i1);
						            }
						        });
							    alertDialog.show();
							    if(so==true)
								{
									mr.start();
								}
							}
							
						}
						else
						{
							if(l1 != 0 || l2 !=0 || l3 != 0)
							{
							t.setText("Turn of Player 1");
							if(so==true)
							{
								m.start();
							}
							}
							else
							{
								AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
								alertDialog.setTitle("Game over");
							    alertDialog.setMessage("Player 2 wins.");
							    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog,int which) {
						            	Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
						            	i1.putExtra("So",so);
										startActivity(i1);
						            }
						        });
							    alertDialog.show();
							}
						}
						
					}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
						alertDialog.setTitle("Invalid choice!");
					    alertDialog.setMessage("Please choose properly.");
					    alertDialog.setCanceledOnTouchOutside(true);
					    alertDialog.show();
					    if(so==true)
						{
							mw.start();
						}
					}
				}
				else if(i2==2)
				{
					if(l2>=i1)
					{
						String str="";
						for(int in=1;in<=(l2-i1);in++)
						{
							str=str+"|";
						}
						t2.setText(str);
						String st=t.getText().toString();
						l2=t2.getText().length();
						if(st.contains("1"))
						{
							if(l1 != 0 || l2 !=0 || l3 != 0)
							{
								t.setText("Turn of Player 2");
								if(so==true)
								{
									m.start();
								}
							}
							else
							{
								AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
								alertDialog.setTitle("Game over");
								alertDialog.setMessage("Player 1 wins.");
								alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,int which) {
										Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
										i1.putExtra("So",so);
										startActivity(i1);
									}
								});
								alertDialog.show();
								if(so==true)
								{
									mr.start();
								}
							}
						}
						else
						{
							if(l1 != 0 || l2 !=0 || l3 != 0)
							{
							t.setText("Turn of Player 1");
							if(so==true)
							{
								m.start();
							}
							}
							else
							{
								AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
								alertDialog.setTitle("Game over");
							    alertDialog.setMessage("Player 2 wins.");
							    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog,int which) {
						            	Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
						            	i1.putExtra("So",so);
										startActivity(i1);
						            }
						        });
							    alertDialog.show();
							    if(so==true)
								{
									mr.start();
								}
							}
						}
					}
					else
					{
						AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
						alertDialog.setTitle("Invalid choice!");
					    alertDialog.setMessage("Please choose properly.");
					    alertDialog.setCanceledOnTouchOutside(true);
					    alertDialog.show();
					    if(so==true)
						{
							mw.start();
						}
					}
				}
					else
					{
						if(l3>=i1)
						{
							String str="";
							for(int in=1;in<=(l3-i1);in++)
							{
								str=str+"|";
							}
							t3.setText(str);
							String st=t.getText().toString();
							l3=t3.getText().length();
							if(st.contains("1"))
							{
								if(l1 != 0 || l2 !=0 || l3 != 0)
								{
								t.setText("Turn of Player 2");
								if(so==true)
								{
									m.start();
								}
								}
								else
								{
									AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
									alertDialog.setTitle("Game over");
								    alertDialog.setMessage("Player 1 wins.");
								    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
							            public void onClick(DialogInterface dialog,int which) {
							            	Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
							            	i1.putExtra("So",so);
											startActivity(i1);
							            }
							        });
								    alertDialog.show();
								    if(so==true)
									{
										mr.start();
									}
								}
								
							}
							else
							{
								if(l1 != 0 || l2 !=0 || l3 != 0)
								{
								t.setText("Turn of Player 1");
								if(so==true)
								{
									m.start();
								}
								}
								else
								{
									AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
									alertDialog.setTitle("Game over");
								    alertDialog.setMessage("Player 2 wins.");
								    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
							            public void onClick(DialogInterface dialog,int which) {
							            	Intent i1=new Intent(getApplicationContext(),SticksActivity.class);
							            	i1.putExtra("So",so);
											startActivity(i1);
							            }
							        });
								    alertDialog.show();
								    if(so==true)
									{
										m.start();
									}
								}
							}
						}
						else
						{
							AlertDialog alertDialog = new AlertDialog.Builder(SticksplayActivity.this).create();
							alertDialog.setTitle("Invalid choice!");
						    alertDialog.setMessage("Please choose properly.");
						    alertDialog.setCanceledOnTouchOutside(true);
						    alertDialog.show();
						    if(so==true)
							{
								mw.start();
							}
						}
					}
				}
		});
}

    @Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
