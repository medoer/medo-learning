package medo.pattern.oo.composite;

import java.util.ArrayList;
import java.util.List;

import medo.pattern.oo.composite.component.Button;
import medo.pattern.oo.composite.component.Frame;
import medo.pattern.oo.composite.component.Input;
import medo.pattern.oo.composite.component.Label;
import medo.pattern.oo.composite.component.Picture;
import medo.pattern.oo.composite.component.Window;

public class Login {

    public void login() {
        Window window = new Window("WINDOW");
        List<Component> subWindow = new ArrayList<>();
        subWindow.add(new Picture("Logo"));
        window.addComponent(subWindow);
        Frame frame = new Frame("Frame");
        List<Component> asList = new ArrayList<>();
        asList.add(new Input("input"));
        asList.add(new Label("label"));
        asList.add(new Button("login"));
        asList.add(new Button("regist"));
        frame.addComponent(asList);
        List<Component> frameSub = new ArrayList<>();
        frameSub.add(frame);
        window.addComponent(frameSub);
        window.rend();
    }
}
