package me.noahandrews.mediaplayersync.javafx;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import rx.Observable;
import rx.observables.JavaFxObservable;

/*
 * MIT License
 * <p>
 * Copyright (c) 2016 Noah Andrews
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

class HostConfigViewJfx implements HostConfigView {
    private VBox pane;

    private final Button serverButton;
    private final Label serverStatusLabel;

    public HostConfigViewJfx() {
        pane = new VBox(20);
        pane.setAlignment(Pos.CENTER);

        serverButton = new Button("Start Server");

        serverStatusLabel = new Label("");
        serverStatusLabel.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(serverButton, serverStatusLabel);
    }

    @Override
    public Pane getPane() {
        return pane;
    }

    @Override
    public Observable<ActionEvent> getServerButtonObservable() {
        return JavaFxObservable.fromNodeEvents(serverButton, ActionEvent.ACTION);
    }

    @Override
    public void setServerButtonText(String text) {
        serverButton.setText(text);
    }

    @Override
    public void setServerStatusText(String text) {
        serverStatusLabel.setText(text);
    }
}
