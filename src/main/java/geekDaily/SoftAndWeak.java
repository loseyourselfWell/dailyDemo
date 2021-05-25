package geekDaily;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 软引用以及弱引用
 *
 *
 */
public class SoftAndWeak {

    public static void main(String[] args) {
        String strongRef = new String("abc");
        // 软引用
        SoftReference<String> softRef = new SoftReference<>(strongRef);
        strongRef = null;
        System.gc();
        System.out.println(softRef.get());
        strongRef = new String("123");
        // 弱引用
        WeakReference<String> weakRef = new WeakReference<>(strongRef);
        strongRef = null;
        System.gc();
        System.out.println(weakRef.get());
    }
}
