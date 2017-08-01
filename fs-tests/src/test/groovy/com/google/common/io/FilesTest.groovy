package com.google.common.io

import com.google.common.base.Charsets
import spock.lang.Specification

import java.nio.file.Paths

/**
 * Created by cuiyongxu on 17/6/16.
 */
class FilesTest extends Specification {

    def fileName = "How to Win Friends and Influence People - Wei Zhi.txt";

    def "读取本地文件_java版本"() {
        given:
        def path = this.getClass().getResource("/data").getPath() + File.separator + "article.txt"
        byte[] bytes = java.nio.file.Files.readAllBytes(Paths.get(path))
        println new String(bytes)
    }


    def "读取本地文件_guava版本,读取小文件"() {
        given:
        def path = this.getClass().getResource("/data").getPath() + File.separator + "article.txt"
        List<String> lines = Files.readLines(new File(path), Charsets.UTF_8);
        for (String line : lines) {
            println line
        }
    }

    def "读取本地文件_guava版本,读取大文件"() {
        given:
        def path = this.getClass().getResource("/data").getPath() + File.separator + fileName
        File testFile = new File(path);
        println Files.toString(testFile, Charsets.UTF_8);
    }

    def "写文件_guava版本"() {
        given:
        def taget = this.getClass().getResource("/data").getPath() + File.separator + "myarticle.txt"
        def buffer = new StringBuffer();
        def source = this.getClass().getResource("/data").getPath() + File.separator + "article.txt"
        List<String> lines = Files.readLines(new File(source), Charsets.UTF_8);
        for (String line : lines) {
            buffer.append(line + "\r\n")
        }
        Files.write(buffer.toString().bytes, new File(taget));
    }

    def "复制"() {
        given:
        def taget = this.getClass().getResource("/data").getPath() + File.separator + "myarticle.txt"
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        Files.copy(new File(source), new File(taget));
    }

    def "比较两个文件'内容'是否完全一致"() {
        given:
        def taget = this.getClass().getResource("/data").getPath() + File.separator + "myarticle.txt"
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        println Files.equal(new File(source), new File(taget));
    }

    def "创建临时目录"() {
        given:

        //   /var/folders/yk/pn_39gfn1x7dlxqyrgrhstl00000gn/T/1497945784275-0
        //   /var/folders/yk/pn_39gfn1x7dlxqyrgrhstl00000gn/T/1497945799939-0
        //   /var/folders/yk/pn_39gfn1x7dlxqyrgrhstl00000gn/T/1497945813065-0
        println Files.createTempDir().getPath().toString();
    }

    def "获得文件的扩展名"() {
        given:
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        println Files.getFileExtension(source);
    }

    def "获得不带扩展名的文件名"() {
        given:
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        println Files.getNameWithoutExtension(source);
    }


    def "字节码输出"() {
        given:
        def source = this.getClass().getResource("/data").getPath() + File.separator + fileName
        println new String(Files.toByteArray(new File(source)))
    }

}
