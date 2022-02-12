package org.lwh.lrm.moduledeom.cell;

import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.control.Label;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.val;
import org.lwh.lrm.cell.ContentCell;
import org.lwh.lrm.cell.LrmCell;
import org.lwh.lrm.cell.LrmCellController;

import java.io.*;

/**
 * @author luweihai
 */
@NoArgsConstructor
public final class TextCell implements ContentCell, Externalizable {
    @Serial
    private static final long serialVersionUID = 494058421735479443L;
    private final ObjectProperty<Node> content = new SimpleObjectProperty<>();
    private final StringProperty cellName = new SimpleStringProperty();

    public TextCell(@NonNull String text) {
        val label = new Label();
        label.textProperty().bind(this.cellName);
        this.cellName.set(text);
        this.content.set(label);
    }

    @Override
    public Node getContent() {
        return content.get();
    }

    @Override
    public ReadOnlyObjectProperty<? extends Node> contentProperty() {
        return content;
    }

    @Override
    public String getCellName() {
        return cellName.get();
    }

    @Override
    public ReadOnlyStringProperty cellNameProperty() {
        return cellName;
    }

    @Override
    public LrmCellController<? extends LrmCell> getCellController() {
        return new LrmCellController<>(this);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(cellName.get());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        cellName.set(in.readUTF());
    }
}
