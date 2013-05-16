package com.android.intentfuzzer;

import java.util.List;

import com.android.intentfuzzer.util.AppInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AppInfoAdapter extends BaseAdapter {  
    
    private List<AppInfo> mlistAppInfo = null;  
      
    LayoutInflater infater = null;  
      
    public AppInfoAdapter(Context context, List<AppInfo> appInfos) {  
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        mlistAppInfo = appInfos ;  
    }  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        
        return mlistAppInfo.size();  
    }  
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
        return mlistAppInfo.get(position);  
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
            view = infater.inflate(R.layout.package_info, null);  
            holder = new ViewHolder(view);  
            view.setTag(holder);  
        }   
        else{  
            view = convertview ;  
            holder = (ViewHolder) convertview.getTag() ;  
        }  
        AppInfo appInfo = (AppInfo) getItem(position);  
        holder.appIcon.setImageDrawable(appInfo.getAppIcon());  
        holder.appName.setText(appInfo.getAppName());  
        holder.packageName.setText(appInfo.getPackageName());  
        return view;  
    }  
  
    class ViewHolder {  
        ImageView appIcon;  
        TextView appName;  
        TextView packageName;  
  
        public ViewHolder(View view) {  
            this.appIcon = (ImageView) view.findViewById(R.id.app_icon);  
            this.appName = (TextView) view.findViewById(R.id.app_name);  
            this.packageName = (TextView) view.findViewById(R.id.package_name);  
        }  
    }

}  
