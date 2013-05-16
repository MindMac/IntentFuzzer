package com.android.intentfuzzer.util;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

public class AppInfo {
	
	private String appName = "";
	private String packageName = "";
	private Drawable appIcon = null;
	private PackageInfo packageInfo = null;
	
	public AppInfo(){}  
    
    public String getAppName() {  
        return appName;  
    }  
    
    public void setAppName(String appName) {  
        this.appName = appName;  
    }  
    
    public Drawable getAppIcon() {  
        return appIcon;  
    }  
    
    public void setAppIcon(Drawable appIcon) {  
        this.appIcon = appIcon;  
    }  
 
    public String getPackageName(){  
        return packageName ;  
    }  
    
    public void setPackageName(String packageName){  
        this.packageName = packageName ;  
    } 
    
    public PackageInfo getPackageInfo(){
    	return packageInfo;
    }
    
    public void setPackageInfo(PackageInfo packageInfo){
    	this.packageInfo = packageInfo;
    }

}
