package com.android.intentfuzzer.util;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class Utils {
	
	public static int ALL_APPS = 0;
	public static int SYSTEM_APPS = 1;
	public static int NONSYSTEM_APPS = 2;
	public static int ABOUNT = 3;
	
	public static final int MSG_PROCESSING = 0;
	public static final int MSG_DONE = 1;
	public static final int MSG_ERROR = 2;
	
	public static final int ACTIVITIES = 0;
	public static final int RECEIVERS = 1;
	public static final int SERVICES = 2;
	
	public static final String PKGINFO_KEY = "pkginfo";
	public static final String APPTYPE_KEY = "apptype";
	
	public static List<AppInfo> getPackageInfo(Context context, int type){
		List<AppInfo> pkgInfoList = new ArrayList<AppInfo>();
		
		List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(
				PackageManager.GET_DISABLED_COMPONENTS
				| PackageManager.GET_ACTIVITIES
				| PackageManager.GET_RECEIVERS
				| PackageManager.GET_INSTRUMENTATION
				| PackageManager.GET_SERVICES); 
		
		for(int i=0;i<packages.size();i++) {   
		    PackageInfo packageInfo = packages.get(i);
		    if (type == SYSTEM_APPS)
		    {
		    	if((packageInfo.applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM) == 1)
		    	{
		    		pkgInfoList.add(fillAppInfo(packageInfo, context));   
		    	}
		    }else if(type == NONSYSTEM_APPS)  
		    {
		    	if((packageInfo.applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM) == 0)
		    	{
		    		pkgInfoList.add(fillAppInfo(packageInfo, context));   
		    	}
		    }else
		    {
		    	pkgInfoList.add(fillAppInfo(packageInfo, context)); 
		    }
		    
		}
		
		return pkgInfoList;
		
	}
	
	
	private static AppInfo fillAppInfo(PackageInfo packageInfo, Context context){
		
		AppInfo appInfo = new AppInfo(); 
		appInfo.setPackageInfo(packageInfo);
	    appInfo.setAppName(packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());   
	    appInfo.setPackageName(packageInfo.packageName);   
	    appInfo.setAppIcon( packageInfo.applicationInfo.loadIcon(context.getPackageManager()));   
		
		return appInfo;
		
	}
}
