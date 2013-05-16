package com.android.intentfuzzer;

import java.util.List;

import com.android.intentfuzzer.util.ComponentInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ComponentAdapter extends BaseAdapter{

	
    private List<ComponentInfo> mlistComponentInfo = null;  
    
    LayoutInflater infater = null;  
      
    public ComponentAdapter(Context context, List<ComponentInfo> componentInfos) {  
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        mlistComponentInfo = componentInfos ;  
    }  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        
        return mlistComponentInfo.size();  
    }  
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
        return mlistComponentInfo.get(position);  
    }  
    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return 0;  
    } 
    
    @Override  
    public View getView(int position, View convertview, ViewGroup viewGroup) {  
       
        View view = null;  
        ViewHolder holder = null;  
        if (convertview == null || convertview.getTag() == null) {  
            view = infater.inflate(R.layout.component, null);  
            holder = new ViewHolder(view);  
            view.setTag(holder);  
        }   
        else{  
            view = convertview ;  
            holder = (ViewHolder) convertview.getTag() ;  
        }  
        ComponentInfo componentInfo = (ComponentInfo) getItem(position);  
        holder.componentName.setText(componentInfo.getComponentName());  
        return view;  
    }  
  
    class ViewHolder {    
        public TextView componentName;  
  
        public ViewHolder(View view) {  
            
            this.componentName = (TextView) view.findViewById(R.id.component_name);  
        }  
    }
}
