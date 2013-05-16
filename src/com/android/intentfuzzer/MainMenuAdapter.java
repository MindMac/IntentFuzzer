package com.android.intentfuzzer;


import android.view.LayoutInflater;
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;  
import android.content.Context;  
import android.widget.ImageButton;
import android.widget.ImageView;  
import android.widget.GridView;  
import android.widget.TextView;

public class MainMenuAdapter extends BaseAdapter {  
	
	private Context mContext = null;  
	private int alpha=180;
	 
	LayoutInflater infater = null;  
	   
	public MainMenuAdapter(Context context)  {  
	  mContext=context;  
	  infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	 } 
	
	 @Override  
	 public int getCount() {  
	  // TODO Auto-generated method stub  
	  return mThumbIds.length;  
	 }  
	 
	@Override  
	 public Object getItem(int position) {  
	  // TODO Auto-generated method stub  
	  return null;  
	 }  
	
	@Override  
	 public long getItemId(int position) {  
	  // TODO Auto-generated method stub  
	  return 0;  
	 }  
	
	 @Override  
	 public View getView(int position, View convertView, ViewGroup parent) {  
	  // TODO Auto-generated method stub  
	    
		 View view = null;  
	     ViewHolder holder = null;  
	     if(convertView==null){
	    	 view = infater.inflate(R.layout.menu_item, null);  
	         holder = new ViewHolder(view);  
	         view.setTag(holder); 
	     }  
	     else{  
	         view = convertView ;  
	         holder = (ViewHolder) convertView.getTag() ;  
	     }  
	     
	     holder.menuImg.setImageResource(mThumbIds[position]);
	     holder.menuImg.setAlpha(alpha);
	     holder.menuLabel.setText(menuLabels[position]);
	   
	     return view;  
	  }  
	 
	 class ViewHolder {  
		
		 ImageView menuImg;
	     TextView  menuLabel; 
	    
	     public ViewHolder(View view) {  
	        this.menuImg=(ImageView)view.findViewById(R.id.img_menu);
	        this.menuLabel = (TextView) view.findViewById(R.id.label_menu);  
	        
	     }  
	 }
	 
	private Integer[] mThumbIds={
			R.drawable.allapps,
			R.drawable.system,
			R.drawable.application,
			R.drawable.about,

	 };  

	private String[] menuLabels={
			"AllApps",
			"SystemApps",
			"NonSystemApps",
			"About"
			
	};
}
