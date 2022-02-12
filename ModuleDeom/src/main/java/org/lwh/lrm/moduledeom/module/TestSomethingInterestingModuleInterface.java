package org.lwh.lrm.moduledeom.module;

import org.lwh.lrm.LrmAppInstance;
import org.lwh.lrm.cell.LrmCellBuilderMenuNode;
import org.lwh.lrm.manager.LrmCellManager;
import org.lwh.lrm.module.AbstractLrmModuleInterface;
import org.lwh.lrm.moduledeom.cell.TextCell;
import org.lwh.lrm.moduledeom.cell.TextCellBuilder;
import org.lwh.lrm.util.BeanTool;

/**
 * @author luweihai
 */
public final class TestSomethingInterestingModuleInterface extends AbstractLrmModuleInterface {
    private final LrmCellManager lrmCellManager = LrmAppInstance.getBean(LrmCellManager.class);

    @Override
    protected void moduleInit() {
        BeanTool.scanBeans(LrmAppInstance.INSTANCE.getContext(), lrmModule.getModuleResourceLoader(), "org.lwh.lrm");
        this.lrmCellManager.putCellBuilder(TextCell.class, TextCellBuilder.class);
        this.lrmCellManager.addCellBuilderMenuNode(new LrmCellBuilderMenuNode(TextCell.class, "Text Cell", null));
    }

    @Override
    public void moduleStart() {

    }
}
