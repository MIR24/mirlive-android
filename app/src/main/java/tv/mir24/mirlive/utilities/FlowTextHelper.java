package tv.mir24.mirlive.utilities;

import android.graphics.Point;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FlowTextHelper {

    public static void tryFlowText(String text, View thumbnailView, TextView messageView) {
        // Get height and width of the image and height of the text line
        Point size = new Point();
        thumbnailView.measure(size.x, size.y);
        int height = thumbnailView.getMeasuredHeight();
        int width = thumbnailView.getMeasuredWidth();
        float textLineHeight = messageView.getPaint().getTextSize();

        // Set the span according to the number of lines and width of the image
        int lines = (int) Math.ceil(height / textLineHeight);
        // For an html text you can use this line: SpannableStringBuilder ss =
        // (SpannableStringBuilder)Html.fromHtml(text);
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new CustomLeadingMarginSpan(lines - 1,
                        width + 20),
                0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        messageView.setText(ss);

        // Align the text with the image by removing the rule that the text is to the
        // right of the image
        RelativeLayout.LayoutParams params =
                (RelativeLayout.LayoutParams) messageView.getLayoutParams();
        int[] rules = params.getRules();
        rules[RelativeLayout.RIGHT_OF] = 0;
    }
}
