package com.restuibu.kipang.tahsinhijaiyah;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.restuibu.kipang.image.GridViewAdapter;
import com.restuibu.kipang.image.ImageItem;

public class HomeActivity extends Activity {
	private int[] bitmapId = { R.drawable.alif, R.drawable.ba,
			R.drawable.nyoba, R.drawable.tsa, R.drawable.jim, R.drawable.ha,
			R.drawable.kha, R.drawable.dal, R.drawable.dzal, R.drawable.ra,
			R.drawable.za, R.drawable.sin, R.drawable.syin, R.drawable.sad,
			R.drawable.dad, R.drawable.tha, R.drawable.dhat, R.drawable.ain,
			R.drawable.ghain, R.drawable.fa, R.drawable.qaf, R.drawable.kaf,
			R.drawable.lam, R.drawable.mim, R.drawable.nun, R.drawable.haa,
			R.drawable.waw, R.drawable.ya };

	public static String[] bitmapName = { "Alif", "Ba", "Ta", "Tsa", "Jim",
			"ha", "Kho", "Dal", "Dzal", "Ro", "Zai", "Sin", "Syin", "Shod",
			"Dhod", "Tho", "Dzo", "Ain", "Ghoin", "Fa", "Qof", "Kaf", "Lam",
			"Mim", "Nun", "Ha", "Waw", "Ya" };
	private GridView gridView;
	private GridViewAdapter customGridAdapter;
	ArrayList<ImageItem> imageItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_grid);



		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);

		// add interstitial
		if (SplashScreen.mInterstitialAd.isLoaded()) {
			SplashScreen.mInterstitialAd.show();
		}
		SplashScreen.mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				HomeActivity.loadInterstitial(HomeActivity.this);
			}
		});

		gridView = (GridView) findViewById(R.id.gridView);
		customGridAdapter = new GridViewAdapter(this, R.layout.row_grid,
				getData());
		gridView.setAdapter(customGridAdapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				String nama = imageItems.get(position).getTitle();
				// File f=new File(Environment.getExternalStorageDirectory()+
				// File.separator + FOLDER_NAME + File.separator+nama);

				toDetail(position, nama);
			}
		});
	}

	private ArrayList<ImageItem> getData() {
		imageItems = new ArrayList<ImageItem>();
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		for (int i = 0; i <= 27; i++) {
			Bitmap bitmap = null;
			bitmap = BitmapFactory.decodeResource(getResources(), bitmapId[i],
					options);
			imageItems.add(new ImageItem(bitmap, bitmapName[i]));
		}
		return imageItems;
	}

	public void toDetail(int id, String title) {
		Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
		intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(id));
		intent.putExtra("title", title);
		startActivity(intent);
		overridePendingTransition(R.anim.home_detail_entry,
				R.anim.home_detail_exit);

	}

	public static void showDialog(Activity activity) {
		LayoutInflater inflater = LayoutInflater.from(activity);
		View dialogview = inflater.inflate(R.layout.help_dialog, null);
		final ScaleImageView imageView1 = (ScaleImageView) dialogview
				.findViewById(R.id.imageView1);
		imageView1.setImageResource(R.drawable.makhrojulhuruf);

		final AlertDialog alert = new AlertDialog.Builder(activity).create();
		alert.setView(dialogview);
		alert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_help:
			showDialog(HomeActivity.this);
			return true;

		case R.id.action_about:
			startActivity(new Intent(HomeActivity.this, AboutActivity.class));
			overridePendingTransition(R.anim.left_right_entry,
					R.anim.left_right_exit);
			return true;
		case R.id.rate:
			Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
			Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
			try {
				startActivity(goToMarket);
			} catch (ActivityNotFoundException e) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://play.google.com/store/apps/details?id="
								+ this.getPackageName())));
			}
			return true;
		case R.id.ins:
			Uri uri2 = Uri.parse("market://developer?id=Restu+Ibu");
			Intent goToMarket2 = new Intent(Intent.ACTION_VIEW, uri2);
			try {
				startActivity(goToMarket2);
			} catch (ActivityNotFoundException e) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://play.google.com/store/apps/developer?id=Restu+Ibu")));
			}
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public static void loadInterstitial(Context c) {
		SplashScreen.mInterstitialAd = new InterstitialAd(c);
		SplashScreen.mInterstitialAd.setAdUnitId(c.getResources().getString(
				R.string.interstitial_ad_unit_id));

		AdRequest adRequest = new AdRequest.Builder().build();
		SplashScreen.mInterstitialAd.loadAd(adRequest);


	}

}
