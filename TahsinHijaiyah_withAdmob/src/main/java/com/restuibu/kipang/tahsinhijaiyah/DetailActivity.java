package com.restuibu.kipang.tahsinhijaiyah;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class DetailActivity extends Activity {

	private ImageView imageView1;
	private Button button1, button2, button3, button4;
	private LinearLayout layoutSifat, layoutTambahan;
	private int id;
	private String title;
	private TextView textView2, textView4, textView6;
	private AlphaAnimation buttonClick = new AlphaAnimation(5F, 0.1F);

	MediaPlayer mediaPlayer;
	boolean flag;

	// konten
	private String[][] huruf = new String[][] {
			// makhraj, sifat
			{ "Tenggorokan yang terjauh", null, null },
			{ "Merapatkan kedua bibir", null,
					"Pada posisi sukun terdengar pantulan suara" },
			{
					"Menyentuhkan ujung lidah dengan gusi gigi seri bagian atas",
					"Al-Hams, ketika diucapkan terdengar ada nafas yang mengalir",
					null },
			{
					"Menyentuhkan ujung lidah dengan dinding 2 gigi seri bagian atas",
					"Al-Hams, ketika diucapkan terdengar ada nafas yang mengalir",
					null },
			{ "Menyentukan tengah-tengah lidah dengan langit-langit",
					"Al-Jahr, pengucapannya tidak ada nafas yang mengalir",
					null },
			{ "Tengah-tengah tenggorokan", null, null },
			{
					"Dari pangkal tenggorokan",
					"Al-Hams, ketika diucapkan terdengar ada nafas yang mengalir\nAl-Isti'la, diucapkan dengan suara yang tebal",
					"Terdengar seperti orang yang tidur dalam keadaan mendengkur/mengorok" },

			{ "Menyentuhkan ujung lidah dengan gusi dua gigi seri bagian atas",
					null, "Pada posisi sukun terdengar pantulan suara" },
			{
					"Menyentuhkan ujung lidah dengan dinding 2 gigi seri bagian atas",
					null, null },
			{ "Menyentuhkan punggung lidah dengan langit-langit", null, null },
			{
					"Ujung lidah berada diantara dua gigi seri bagian atas dan bawah",
					"Al-Jahr, pengucapannya tidak ada nafas yang mengalir",
					null },
			{
					"Ujung lidah berada diantara dua gigi seri",
					"Ash-Shofir huruf SA, ketika pengucapan ada suara tambahan menyerupai suara belalang",
					null },
			{ "Mengangkat tengah lidah ke langit-langit",
					"At-Tafasyi, menyebarnya angin didalam mulut kita", null },
			{
					"Ujung lidah berada diantara dua gigi seri",
					"Ash-Shofir huruf SHO, ketika pengucapan ada suara tambahan menyerupai suara angsa",
					"Pada huruf fathah, bibir tidak boleh diucapkan dengan monyong, namun dengan rongga mulut dibuka dengan sempurna" },

			{
					"Menyentuhkan sisi lidah dengan sisi gigi graham atas",
					"Al-Istitholah, suara kita memanjang dan terdengar lembut ketika diucapkan",
					null },
			{ "Ujung lidah disentuhkan dengan gusi gigi seri bagian atas",
					"Al-Isti'la, diucapkan dengan suara yang tebal", null },
			{ "Ujung lidah disentuhkan dengan dua gigi seri bagian atas",
					"Al-Isti'la, diucapkan dengan suara yang tebal", null },
			{ "Dari tengah-tengah tenggorokan", null, null },
			{
					"Dari pangkal tenggorokan",
					"Al-Isti'la, diucapkan dengan suara yang tebal\nAl-Jahr, pengucapannya tidak ada nafas yang mengalir",
					null },
			{
					"Menyentuhkan dua gigi seri atas dengan bibir bawah bagian dalam",
					null, null },
			{
					"Menyentuhkan pangkal lidah dengan dengan langit-langit bagian belakang",
					"Al-Isti'la, diucapkan dengan suara yang tebal",
					"Pada posisi sukun terdengar pantulan suara" },

			{
					"Mengangkat pangkal lidah didepan posisi huruf QOF",
					"Al-Hams, ketika diucapkan terdengar ada nafas yang mengalir",
					null },
			{
					"Mengangkat ujung lidah dan disentuhkan dengan langit-langit didepan pengucapan huruf RO",
					null, null },
			{ "Merapatkan kedua bibir", null, null },
			{ "Menyentuhkan ujung lidah diantara posisi RO dan LA", null, null },
			{ "Dikeluarkan dari tenggorokan yang terjauh", null, null },
			{ "Dengan cara memonyongkan kedua bibir", null, null },
			{ "Membuka kedua bibir dengan sempurna", null, null }

	};

	private int[][] mediaHuruf = new int[][] {
			// gambar, ucapan mp3, training mp3

			{ R.drawable.alif, R.raw.a, R.raw.a },
			{ R.drawable.ba, R.raw.ba, R.raw.ba },
			{ R.drawable.nyoba, R.raw.ta, R.raw.ta },
			{ R.drawable.tsa, R.raw.tsa, R.raw.tsa },
			{ R.drawable.jim, R.raw.ja, R.raw.ja },
			{ R.drawable.ha, R.raw.ha, R.raw.ha },
			{ R.drawable.kha, R.raw.kho, R.raw.kho },

			{ R.drawable.dal, R.raw.da, R.raw.da },
			{ R.drawable.dzal, R.raw.dza, R.raw.dza },
			{ R.drawable.ra, R.raw.ro, R.raw.ro },
			{ R.drawable.za, R.raw.za, R.raw.za },
			{ R.drawable.sin, R.raw.sa, R.raw.sa },
			{ R.drawable.syin, R.raw.sya, R.raw.sya },
			{ R.drawable.sad, R.raw.sho, R.raw.sho },

			{ R.drawable.dad, R.raw.dho, R.raw.dho },
			{ R.drawable.tha, R.raw.tho, R.raw.tho },
			{ R.drawable.dhat, R.raw.zho, R.raw.zho },
			{ R.drawable.ain, R.raw.ain, R.raw.ain },
			{ R.drawable.ghain, R.raw.gho, R.raw.gho },
			{ R.drawable.fa, R.raw.fa, R.raw.fa },
			{ R.drawable.qaf, R.raw.qo, R.raw.qo },

			{ R.drawable.kaf, R.raw.ka, R.raw.ka },
			{ R.drawable.lam, R.raw.la, R.raw.la },
			{ R.drawable.mim, R.raw.ma, R.raw.ma },
			{ R.drawable.nun, R.raw.na, R.raw.na },
			{ R.drawable.haa, R.raw.habesar, R.raw.habesar },
			{ R.drawable.waw, R.raw.wa, R.raw.wa },
			{ R.drawable.ya, R.raw.ya, R.raw.ya } };

	private int[] kalimatHuruf = new int[] {
			// gambar, ucapan mp3, training mp3
			R.drawable.a_kalimat, R.drawable.ba_kalimat, R.drawable.ta_kalimat,
			R.drawable.tsa_kalimat, R.drawable.ja_kalimat,
			R.drawable.ha_kalimat, R.drawable.kho_kalimat,

			R.drawable.da_kalimat, R.drawable.dza_kalimat,
			R.drawable.ra_kalimat, R.drawable.za_kalimat,
			R.drawable.sa_kalimat, R.drawable.sya_kalimat,
			R.drawable.sho_kalimat,

			R.drawable.dho_kalimat, R.drawable.to_kalimat,
			R.drawable.zo_kalimat, R.drawable.ain_kalimat,
			R.drawable.go_kalimat, R.drawable.fa_kalimat,
			R.drawable.ko_kalimat,

			R.drawable.ka_kalimat, R.drawable.la_kalimat,
			R.drawable.ma_kalimat, R.drawable.na_kalimat,
			R.drawable.ha_kalimat, R.drawable.wa_kalimat, R.drawable.ya_kalimat };

	public DetailActivity() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

//		AdView mAdView = (AdView) findViewById(R.id.adView);
//		AdRequest adRequest = new AdRequest.Builder().build();
//		mAdView.loadAd(adRequest);

		AdView adView = new AdView(this);
		adView.setAdSize(AdSize.BANNER);
		adView.setAdUnitId("ca-app-pub-6657666130252014/7463660191");


		// add interstitial
		if (SplashScreen.mInterstitialAd.isLoaded()) {
			SplashScreen.mInterstitialAd.show();
		}
		SplashScreen.mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdClosed() {
				HomeActivity.loadInterstitial(DetailActivity.this);
			}
		});

		initiate();

		if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {
			id = Integer
					.parseInt(getIntent().getStringExtra(Intent.EXTRA_TEXT));
			title = getIntent().getStringExtra("title");
			getActionBar().setTitle(title);
			
			if(title.equals("Alif")){
				button4.setVisibility(View.GONE);
			}else if(title.equals("Ya")){
				button1.setVisibility(View.GONE);
			}
		}

		// makhraf
		textView2.setText(huruf[id][0]);

		// sifat
		if (huruf[id][1] != null) {
			layoutSifat.setVisibility(View.VISIBLE);
			textView4.setVisibility(View.VISIBLE);
			textView4.setText(huruf[id][1]);
		}
		if (huruf[id][2] != null) {
			layoutTambahan.setVisibility(View.VISIBLE);
			textView6.setVisibility(View.VISIBLE);
			textView6.setText(huruf[id][2]);
		}

		// image
		imageView1.setImageResource(mediaHuruf[id][0]);

		// sound mp3
		flag = true;
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.startAnimation(buttonClick);
				if (flag) {
					mediaPlayer = MediaPlayer.create(getApplicationContext(),
							mediaHuruf[id][1]);
					mediaPlayer.start();

					// alert
					LayoutInflater inflater = LayoutInflater
							.from(DetailActivity.this);
					View dialogview = inflater.inflate(R.layout.help_dialog,
							null);
					final ImageView imageView1 = (ImageView) dialogview
							.findViewById(R.id.imageView1);
					final Button button1 = (Button) dialogview
							.findViewById(R.id.button1);

					imageView1.setImageResource(kalimatHuruf[id]);
					button1.setVisibility(View.VISIBLE);
					button1.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub					

							mediaPlayer.stop();
							mediaPlayer = MediaPlayer.create(
									getApplicationContext(), mediaHuruf[id][1]);
							mediaPlayer.start();

							mediaPlayer
									.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
										@Override
										public void onCompletion(MediaPlayer mp) {
											// button2.setText("play");
											button2.setBackgroundResource(R.drawable.play);
											button3.setEnabled(true);
											flag = true;
										}
									});
							
							button2.setBackgroundResource(R.drawable.stop);
							button3.setEnabled(false);

							// button2.setText("stop");

						}
					});

					final AlertDialog alert = new AlertDialog.Builder(
							DetailActivity.this).create();
					alert.setView(dialogview);
					alert.show();

					mediaPlayer
							.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
								@Override
								public void onCompletion(MediaPlayer mp) {
									// button2.setText("play");
									button2.setBackgroundResource(R.drawable.play);
									button3.setEnabled(true);
									flag = true;
								}
							});

					// button2.setText("stop");
					button2.setBackgroundResource(R.drawable.stop);
					button3.setEnabled(false);
					flag = false;
				} else {
					mediaPlayer.stop();
					// button2.setText("play");
					button2.setBackgroundResource(R.drawable.play);
					button3.setEnabled(true);
					flag = true;
				}
			}
		});

		// gak kepake dibiarin aja
		flag = true;
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater inflater = LayoutInflater
						.from(DetailActivity.this);
				View dialogview = inflater.inflate(R.layout.help_dialog, null);
				final ImageView imageView1 = (ImageView) dialogview
						.findViewById(R.id.imageView1);
				imageView1.setImageResource(R.drawable.a);

				final AlertDialog alert = new AlertDialog.Builder(
						DetailActivity.this).create();
				alert.setView(dialogview);

				if (flag) {
					mediaPlayer = MediaPlayer.create(getApplicationContext(),
							mediaHuruf[id][2]);
					mediaPlayer.start();
					mediaPlayer
							.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
								@Override
								public void onCompletion(MediaPlayer mp) {
									button3.setText("play");
									button2.setEnabled(true);
									flag = true;
								}
							});

					button3.setText("stop");
					button2.setEnabled(false);
					alert.show();
					flag = false;
				} else {
					mediaPlayer.stop();

					button3.setText("play");
					button2.setEnabled(true);
					flag = true;
				}
			}
		});

		// back and next button
		if (id == 0)
			button4.setEnabled(false);
		else if (id == 27)
			button1.setEnabled(false);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DetailActivity.this,
						DetailActivity.class);
				intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(id + 1));
				intent.putExtra("title", HomeActivity.bitmapName[id + 1]);

				startActivity(intent);
				DetailActivity.this.overridePendingTransition(
						R.anim.left_right_entry, R.anim.left_right_exit);

				finish();

			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DetailActivity.this,
						DetailActivity.class);
				intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(id - 1));
				intent.putExtra("title", HomeActivity.bitmapName[id - 1]);

				startActivity(intent);
				DetailActivity.this.overridePendingTransition(
						R.anim.right_left_entry, R.anim.right_left_exit);

				finish();
			}
		});
	}

	private void initiate() {

		textView2 = (TextView) findViewById(R.id.textView2);

		textView4 = (TextView) findViewById(R.id.textView4);

		textView6 = (TextView) findViewById(R.id.textView6);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		layoutSifat = (LinearLayout) findViewById(R.id.layoutSifat);
		layoutTambahan = (LinearLayout) findViewById(R.id.layoutTambahan);

		layoutSifat.setVisibility(View.GONE);
		textView4.setVisibility(View.GONE);
		layoutTambahan.setVisibility(View.GONE);
		textView6.setVisibility(View.GONE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_help:
			HomeActivity.showDialog(DetailActivity.this);
			return true;

		case R.id.action_about:
			startActivity(new Intent(DetailActivity.this, AboutActivity.class));
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

	@Override
	protected void onPause() {
		super.onPause();
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
			}
			mediaPlayer.release();
			mediaPlayer = null;

		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.detail_home_entry,
				R.anim.detail_home_exit);
		finish();
	}

}
