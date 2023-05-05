package solid.logger.impl.factories;

import solid.logger.impl.layouts.SimpleLayout;
import solid.logger.impl.layouts.XmlLayout;
import solid.logger.interfaces.Factory;
import solid.logger.interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;
        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if(input.equals("XmlLayout")){
            layout = new XmlLayout();
        }
        return layout;
    }
}
