package org.glydar.glydar.netty.packet.client;

import io.netty.buffer.ByteBuf;
import org.glydar.glydar.netty.packet.CubeWorldPacket;

@CubeWorldPacket.Packet(id = 9)
public class Packet9ShootArrow extends CubeWorldPacket {
    long entID; //Unsigned!

    int chunkX;
    int chunkY;

    long something5; //Unsigned Int!

    long posX;
    long posY;
    long posZ;

    long something13; //uint
    long something14; //uint
    long something15; //uint

    float velX;
    float velY;
    float velZ;

    float something19; // rand() ??
    float something20;
    float something21;
    float something22; // ?????
    long something23; //uint
    byte something24;
    long something25; //uint
    byte something26;
    long something27; //uint
    long something28; //uint

    @Override
    protected void internalDecode(ByteBuf buf) {
        entID = buf.readLong(); //Unsigned long actually!

        chunkX = buf.readInt();
        chunkY = buf.readInt();

        something5 = buf.readUnsignedInt();
        buf.readBytes(4); //Padding

        posX = buf.readLong();
        posY = buf.readLong();
        posZ = buf.readLong();

        something13 = buf.readUnsignedInt();
        something14 = buf.readUnsignedInt();
        something15 = buf.readUnsignedInt();

        velX = buf.readFloat();
        velY = buf.readFloat();
        velZ = buf.readFloat();

        something19 = buf.readFloat();
        something20 = buf.readFloat();
        something21 = buf.readFloat();
        something22 = buf.readFloat();
        something23 = buf.readUnsignedInt();
        something24 = buf.readByte();
        buf.readBytes(3); //Padding
        something25 = buf.readUnsignedInt();
        something26 = buf.readByte();
        buf.readBytes(3); //Padding
        something27 = buf.readUnsignedInt();
        something28 = buf.readUnsignedInt();
    }

	@Override
	public void encode(ByteBuf buf) {
		buf.writeLong(entID);
		buf.writeInt(chunkX);
		buf.writeInt(chunkY);
		buf.writeInt((int) something5);
		buf.skipBytes(4);
		buf.writeLong(posX);
		buf.writeLong(posY);
		buf.writeLong(posZ);
		buf.writeInt((int) something13);
		buf.writeInt((int) something14);
		buf.writeInt((int) something15);
		buf.writeFloat(velX);
		buf.writeFloat(velY);
		buf.writeFloat(velZ);
		buf.writeFloat(something19);
		buf.writeFloat(something20);
		buf.writeFloat(something21);
		buf.writeFloat(something22);
		buf.writeInt((int) something23);
		buf.writeByte(something24);
		buf.skipBytes(3);
		buf.writeInt((int) something25);
		buf.writeByte(something26);
		buf.skipBytes(3);
		buf.writeInt((int) something27);
		buf.writeInt((int) something28);
	}
}
