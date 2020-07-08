package medo.pattern.oo.composite.component;

import medo.pattern.oo.composite.BaseCompoment;
import medo.pattern.oo.composite.Component;

public class Button extends BaseCompoment implements Component {

    public Button(String label) {
        setLabel(label);
    }

    @Override
    public void rend() {
        System.out.println(this.getClass().getName() + " - " + this.getLabel());
    }

}
