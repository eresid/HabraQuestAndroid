package org.dinipra.habraquest.helpers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;

public class ProgressHelper {
    private Activity mActivity;
    private ProgressDialog mProgress;

    public ProgressHelper(Activity _activity) {
        mActivity = _activity;
        mProgress = null;
    }

    public void showProgress(String _message, boolean _cancelable) {
        try {
            if (mProgress == null) {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
                    _cancelable = false;
                }

                if (_cancelable) {
                    mProgress = ProgressDialog.show(mActivity, "", _message, true, true, new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            mProgress = null;
                        }
                    });
                } else {
                    mProgress = ProgressDialog.show(mActivity, "", _message, true, false);
                }
            }
        } catch (Exception e) {
            mProgress = ProgressDialog.show(mActivity, "", _message, true, false);
            e.printStackTrace();
        }
    }

    public void hideProgress() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                mActivity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (mProgress != null && mProgress.isShowing()) {
                            mProgress.dismiss();
                            mProgress = null;
                        }
                    }
                });
            }
        }, 150);
    }

    public boolean isShowing() {
        return mProgress != null && mProgress.isShowing();
    }
}