package sieuthimini.sangheungmin.com.siuthmini.Animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

public class AnimationUtil {
    public  static void animate(RecyclerView.ViewHolder holder,boolean goesDown){
        AnimatorSet  animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown == true ?200:-200,0);
        objectAnimator.setDuration(1500);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(holder.itemView,"translationY",-50,50,-30,30,-20,20,-5,5,0);
        objectAnimator1.setDuration(2000);
        animatorSet.playTogether(objectAnimator);
        animatorSet.start();
    }
}
