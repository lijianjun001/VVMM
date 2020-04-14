package jetpack.zmkj.com.jetpack.media;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MediaActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IjkMediaPlayer ijkMediaPlayer=new IjkMediaPlayer();
    }
}
