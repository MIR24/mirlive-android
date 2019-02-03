package tv.mir24.mirlive.utilities;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.MediaController;

public class CustomMediaController extends MediaController {

    private ImageButton closeButton;

    public CustomMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMediaController(Context context, ImageButton closeButton) {
        super(context);
        this.closeButton = closeButton;
        closeButton.setVisibility(INVISIBLE);
    }

    @Override
    public void show(int timeout) {
        super.show(timeout);
        closeButton.setVisibility(VISIBLE);
    }

    @Override
    public void show() {
        super.show();
        closeButton.setVisibility(VISIBLE);
    }

    @Override
    public void hide() {
        super.hide();
        closeButton.setVisibility(INVISIBLE);
    }

}
