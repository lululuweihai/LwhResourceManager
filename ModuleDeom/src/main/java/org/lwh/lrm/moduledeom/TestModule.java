package org.lwh.lrm.moduledeom;

import org.lwh.lrm.Main;
import org.lwh.lrm.util.DebugConstant;

/**
 * @author luweihai
 */
public final class TestModule {

    public static void main(String[] args) {
        Main.main(new String[]{
                DebugConstant.DEBUG_OPTION,
                DebugConstant.DEBUG_MODULE_PROPERTIES_OPTION,
                "module/test-something-interesting-module.properties"
        });
    }
}
