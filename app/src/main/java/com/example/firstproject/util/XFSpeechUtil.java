package com.example.firstproject.util;

import android.content.Context;
import android.graphics.Paint;
import android.widget.TextView;

import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.ArrayList;

/**
 * Created by DengShuai on 2019/6/4.
 * Description :
 */
public class XFSpeechUtil {
    private OnRecognizerSuccessListener listener;
    private Context context;
    private RecognizerDialog mDialog;

    public interface OnRecognizerSuccessListener {
        void onSuccess(String text);
    }

    public XFSpeechUtil(OnRecognizerSuccessListener listener, Context context) {
        SpeechUtility.createUtility(context, SpeechConstant.APPID + "=5cc7a46e");
        this.listener = listener;
        this.context = context;
    }

    public void initSpeech() {
        //1.创建RecognizerDialog对象
        mDialog = new RecognizerDialog(context, null);
        //2.设置accent、language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");

        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean isLast) {
                if (!isLast) {
                    //解析语音
                    //返回的result为识别后的汉字,直接赋值到TextView上即可
                    String result = parseVoice(recognizerResult.getResultString());
                    listener.onSuccess(result);
                }
            }

            @Override
            public void onError(SpeechError speechError) {
                TextView tv_error = (TextView) mDialog.getWindow().getDecorView().findViewWithTag("errtxt");
                TextView textlink = (TextView) mDialog.getWindow().getDecorView().findViewWithTag("textlink");
                textlink.setText("");
                textlink.getPaint().setFlags(Paint.SUBPIXEL_TEXT_FLAG);
                textlink.setEnabled(false);
                if (tv_error != null && tv_error.getText().toString().contains("您好像没有说话哦...")) {
                    tv_error.setText("您好像没有说话哦...");
                }
            }
        });
        mDialog.show();
        TextView tv_textlink = (TextView) mDialog.getWindow().getDecorView().findViewWithTag("textlink");
        tv_textlink.setText("");
        tv_textlink.getPaint().setFlags(Paint.SUBPIXEL_TEXT_FLAG);
        tv_textlink.setEnabled(false);
    }

    /**
     * 解析语音json
     */
    public String parseVoice(String resultString) {
        Gson gson = new Gson();
        Voice voiceBean = gson.fromJson(resultString, Voice.class);

        StringBuffer sb = new StringBuffer();
        ArrayList<Voice.WSBean> ws = voiceBean.ws;
        for (Voice.WSBean wsBean : ws) {
            String word = wsBean.cw.get(0).w;
            sb.append(word);
        }
        return sb.toString();
    }

    /**
     * 语音对象封装
     */
    public class Voice {

        public ArrayList<WSBean> ws;

        public class WSBean {
            public ArrayList<CWBean> cw;
        }

        public class CWBean {
            public String w;
        }
    }
}
