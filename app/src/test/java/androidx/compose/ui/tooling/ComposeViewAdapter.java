package androidx.compose.ui.tooling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class ComposeViewAdapter extends View {
    public ComposeViewAdapter(Context context) {
        this(context, null);
    }

    public ComposeViewAdapter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ComposeViewAdapter(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
