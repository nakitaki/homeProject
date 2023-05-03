package solid.logger.impl.appenders;

import solid.logger.interfaces.Appender;
import solid.logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {
    Layout layout;

    public BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

}
