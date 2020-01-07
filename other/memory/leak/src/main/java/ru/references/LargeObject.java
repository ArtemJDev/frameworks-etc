package ru.references;

public class LargeObject {
    final byte[] array = new byte[1024 * 1024];

    public byte[] getArray() {
        return array;
    }
}
