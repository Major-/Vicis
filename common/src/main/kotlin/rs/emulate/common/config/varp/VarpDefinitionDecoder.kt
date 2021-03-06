package rs.emulate.common.config.varp

import io.netty.buffer.ByteBuf
import rs.emulate.common.config.Config
import rs.emulate.common.config.ConfigDecoder
import rs.emulate.util.readAsciiString

object VarpDefinitionDecoder : ConfigDecoder<VarpDefinition> {


    override fun decode(id: Int, buffer: ByteBuf): VarpDefinition {
        val definition = VarpDefinition(id)
        var opcode = buffer.readUnsignedByte().toInt()

        while (opcode != Config.DEFINITION_TERMINATOR) {
            definition.decode(buffer, opcode)
            opcode = buffer.readUnsignedByte().toInt()
        }

        return definition
    }

    private fun VarpDefinition.decode(buffer: ByteBuf, opcode: Int) {
        when (opcode) {
            1 -> buffer.readUnsignedByte()
            2 -> buffer.readUnsignedByte()
            5 -> parameter = buffer.readUnsignedShort()
            7 -> buffer.readUnsignedInt()
            10 -> buffer.readAsciiString()
            12 -> buffer.readUnsignedInt()
        }
    }

}
