package org.lwh.lrm.moduledeom.cell;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import lombok.val;
import org.lwh.lrm.cell.LrmCell;
import org.lwh.lrm.cell.LrmCellBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author luweihai
 */
@Component
public final class TextCellBuilder implements LrmCellBuilder<TextCell> {
    private final JFXTextField textField = new JFXTextField();

    @Override
    public void next() {
    }

    @Override
    public void previous() {
    }

    @Override
    public boolean checkNext() {
        return StringUtils.hasText(textField.getText());
    }

    @Override
    public boolean checkPrevious() {
        return false;
    }

    @Override
    public boolean isFirst() {
        return true;
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    public Parent getBuilderHeadingGui() {
        return new Label("Text Cell");
    }

    @Override
    public Parent getBuilderBodyGui() {
        val layout = new HBox(new Label("Text:"), textField);
        textField.setPromptText("Text");
        HBox.setHgrow(textField, Priority.ALWAYS);
        return layout;
    }

    @Override
    public LrmCell build() {
        return new TextCell(textField.getText());
    }
}
