package com.android.intentfuzzer;

import java.util.List;

import com.android.intentfuzzer.util.AppInfo;
import com.android.intentfuzzer.util.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

public class AppInfoActivity extends Activity{

	private int msg = Utils.MSG_PROCESSING;
	private Context context = this;
	
	private int appType = Utils.ALL_APPS;
	private ProgressBar progressBar = null;
	private ListView listView = null;
	private List<AppInfo> listAppInfo = null;
	private AppInfoAdapter appInfoAdapter = null;
	
	private Thread mGetPkgInfoThread = null;
	
	private Handler mHandler = new Handler(){
		
		public void handleMessage(Message msg){
			switch(msg.what){
				case Utils.MSG_DONE:
					progressBar.setVisibility(View.GONE);
					listView.setAdapter(appInfoAdapter);
					break;
				case Utils.MSG_PROCESSING:
					progressBar.setVisibility(View.VISIBLE);
					break;
				case Utils.MSG_ERROR:
					break;
			}
		}
	};
	
	private Runnable pkgInfoRunnable = new Runnable(){
		public void run(){
			listAppInfo = Utils.getPackageInfo(context, appType);
			appInfoAdapter = new AppInfoAdapter(context, listAppInfo);
			msg = Utils.MSG_DONE;
			mHandler.obtainMessage(msg).sendToTarget();
		}
	};
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setProgressBarVisibility(true);
		setContentView(R.layout.package_infos);
		
		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		listView = (ListView) findViewById(R.id.app_listview);
		
		progressBar.setIndeterminate(false);
		
		mHandler.obtainMessage(msg).sendToTarget();
		
		Intent intent = getIntent();
		if (intent.hasExtra("type"))
		{
			appType = intent.getIntExtra("type", Utils.ALL_APPS);
		}
		
		if (mGetPkgInfoThread == null){
			mGetPkgInfoThread = new Thread(pkgInfoRunnable);
			mGetPkgInfoThread.start();
		}
		
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				AppInfo appInfo = (AppInfo) appInfoAdapter.getItem(position);
				((MyApp)getApplication()).packageInfo = appInfo.getPackageInfo();
				
				Intent intent = new Intent(AppInfoActivity.this, FuzzerActivity.class);
				//Bundle bundle = new Bundle();
				//bundle.putParcelable(Utils.PKGINFO_KEY, appInfo.getPackageInfo());
				//intent.putExtras(bundle);
				startActivity(intent);
			}
        	
        });
	}
}
