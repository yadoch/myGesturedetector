package tw.com.abc.mygesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private Timer timer;
    private GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gd=new GestureDetector(this,new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 按下時觸發動作
        // Log.i("geoff","onTouch!!");
        //MotionEvent.ACTION_DOWN;


        return gd.onTouchEvent(event);
        //return false; //super.onTouchEvent(event);
    }


    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            //onDown 按下去的霎那觸發
            //Log.i("geoff","onDown");
            return super.onDown(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            // onScroll 判斷滑動
            //Log.i("geoff","onScroll");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //onFilling 主要是判斷滑動(撇)的動作
            // Log.i("geoff","onFling e1:"+e1+" e2:"+e2);

            if(Math.abs(velocityX) > Math.abs(velocityY)){
                if(velocityX > 0){
                    Log.i("geoff","right");
                }else {
                    Log.i("geoff","left");
                }
            }else{
                if(velocityY > 0){
                    Log.i("geoff","Down");
                }else {
                    Log.i("geoff","Up");
                }
            }



            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }


}
