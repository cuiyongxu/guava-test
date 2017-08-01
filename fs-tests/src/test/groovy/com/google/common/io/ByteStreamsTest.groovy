package com.google.common.io

import spock.lang.Specification

/**
 * Created by cuiyongxu on 17/6/21.
 */
class ByteStreamsTest extends Specification {
    def fileName = "How to Win Friends and Influence People - Wei Zhi.txt";


    def "文件转byte,类似:Files.toByteArray"() {
        given:
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        InputStream is = new FileInputStream(source);
        byte[] contents = ByteStreams.toByteArray(is);
        println new String(contents)
    }
}
