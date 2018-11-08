package com.restuibu.kipang.tahsinhijaiyah;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

//		AdView mAdView = (AdView) findViewById(R.id.adView);
//		AdRequest adRequest = new AdRequest.Builder().build();
//		mAdView.loadAd(adRequest);

		// add interstitial
//		if (SplashScreen.mInterstitialAd.isLoaded()) {
//			SplashScreen.mInterstitialAd.show();
//		}
//		SplashScreen.mInterstitialAd.setAdListener(new AdListener() {
//			@Override
//			public void onAdClosed() {
//				HomeActivity.loadInterstitial(AboutActivity.this);
//			}
//		});

		getActionBar().setTitle("About");
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(R.anim.right_left_entry,
				R.anim.right_left_exit);
		finish();
	}

}
