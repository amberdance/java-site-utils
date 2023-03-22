package ru.hard2code.jni;

import com.sun.jna.WString;

import java.nio.file.Path;
import java.util.Comparator;

public class StrCmpLogicalWComparator implements Comparator<Path> {

    public static final StrCmpLogicalWComparator WINDOWS_NATIVE_ORDER = new StrCmpLogicalWComparator();


    @Override
    public int compare(Path o1, Path o2) {
        return Shlwapi.INSTANCE.StrCmpLogicalW(
                new WString(o1.toFile().getName()), new WString(o2.toFile().getName()));
    }
}
