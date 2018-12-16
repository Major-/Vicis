package rs.emulate.editor.core.project.legacy

import com.google.inject.AbstractModule
import com.google.inject.multibindings.MapBinder
import rs.emulate.editor.core.content.capabilities.ResourcePropertySupport
import rs.emulate.editor.core.project.legacy.npc.NpcPropertySupport
import rs.emulate.editor.vfs.LegacyResourceType
import rs.emulate.editor.vfs.ResourceType

class LegacyProjectModule : AbstractModule() {
    override fun configure() {
        val binder = MapBinder.newMapBinder(binder(), ResourceType::class.java, ResourcePropertySupport::class.java)

        binder.addBinding(LegacyResourceType.Npc).to(NpcPropertySupport::class.java)
    }
}
