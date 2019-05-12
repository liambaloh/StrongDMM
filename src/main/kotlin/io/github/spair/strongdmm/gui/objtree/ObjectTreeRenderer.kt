package io.github.spair.strongdmm.gui.objtree

import io.github.spair.strongdmm.diInstance
import io.github.spair.strongdmm.logic.dmi.DmiProvider
import java.awt.Component
import java.awt.Image
import javax.swing.ImageIcon
import javax.swing.JTree
import javax.swing.tree.DefaultTreeCellRenderer

class ObjectTreeRenderer : DefaultTreeCellRenderer() {

    private val placeholderIcon = ImageIcon(DmiProvider.PLACEHOLDER_IMAGE.getScaledInstance(16, 16, Image.SCALE_FAST))
    private val dmiProvider by diInstance<DmiProvider>()

    override fun getTreeCellRendererComponent(
        tree: JTree,
        value: Any,
        sel: Boolean,
        expanded: Boolean,
        leaf: Boolean,
        row: Int,
        hasFocus: Boolean
    ): Component {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus)

        if (value is ObjectTreeNode) {
            icon = dmiProvider.getSpriteFromDmi(value.icon, value.iconState)?.scaledIcon ?: placeholderIcon
        } else {
            icon = null
        }

        return this
    }
}
