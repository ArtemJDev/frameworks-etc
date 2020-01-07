package ru.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Test leak memory working with different references
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        //strongRef();
        //weakRef();
    }

    private static void strongRef() {
        int size = 1010;
        List<LargeObject> references = new ArrayList<>(size);

        for (int k = 0; k < size; k++) {
            references.add(new LargeObject());
            System.out.println(k);
        }
        //OME for -Xmx256m -Xms256m do 137
        System.out.println("Size: " + references.size());
    }

    private static void weakRef() {
        int size = 58;
        List<WeakReference<LargeObject>> references = new ArrayList<>(size);

        for (int k = 0; k < size; k++) {
            LargeObject bigObject = new LargeObject();
            WeakReference<LargeObject> reference = new WeakReference<>(bigObject);
            references.add(reference);
        }

        //System.gc(); //0 with +- without

        int sum = 0;
        for (int k = 0; k < size; k++) {
            if (references.get(k).get() != null) sum++;
        }

        System.out.println("Weak references: " + sum);
    }
}


