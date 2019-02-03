package tv.mir24.mirlive.utilities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public class CustomLeadingMarginSpan implements LeadingMarginSpan.LeadingMarginSpan2 {

    private int margin;
    private int lines;
    private boolean drawCalled;

    public CustomLeadingMarginSpan(int lines, int margin) {
        this.margin = margin;
        this.lines = lines;
    }

    @Override
    public int getLeadingMargin(boolean isFirstMargin) {
        return isFirstMargin ? this.margin : 0;
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline,
                                  int bottom, CharSequence text, int start, int end, boolean first,
                                  Layout layout) {
        this.drawCalled = true;
    }

    @Override
    public int getLeadingMarginLineCount() {
        return lines;
    }

    public boolean isDrawCalled() {
        return drawCalled;
    }
}
