package com.iteye.wwwcomy.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * @author xingnan.liu
 */
public class GZipHelper {

    private GZipHelper() {
    }

    public static byte[] writeCompressObject(Object object_) {
        byte[] data_ = null;
        try {
            if (object_ != null) {
                ByteArrayOutputStream o = new ByteArrayOutputStream();
                GZIPOutputStream gzout = new GZIPOutputStream(o);
                ObjectOutputStream out = new ObjectOutputStream(gzout);
                out.writeObject(object_);
                out.flush();
                out.close();
                gzout.close();
                data_ = o.toByteArray();
                o.close();
            }
        } catch (IOException e) {
            // TODO
        }
        return (data_);
    }

    public static Object readCompressObject(byte[] data_) {
        Object object_ = null;
        try {
            if (data_ != null && data_.length > 0) {
                ByteArrayInputStream i = new ByteArrayInputStream(data_);
                GZIPInputStream gzin = new GZIPInputStream(i);
                ObjectInputStream in = new ObjectInputStream(gzin);
                object_ = in.readObject();
                i.close();
                gzin.close();
                in.close();
            }
        } catch (ClassNotFoundException e) {
            // TODO
        } catch (IOException e) {
            // TODO
        }
        return (object_);
    }
}
