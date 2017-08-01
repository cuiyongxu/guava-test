package com.google.common.base

import spock.lang.Specification

import java.sql.SQLException

/**
 * Created by cuiyongxu on 17/6/19.
 */
class ThrowablesTest extends Specification {

    def "抛出自定义异常"() {
        given:
        try {
            aExcpeption();
            bExcpeption();
        } catch (Throwable throwable) {
            Throwables.propagateIfInstanceOf(throwable, SQLException.class);
            Throwables.propagateIfPossible(throwable);
        }
    }


    def aExcpeption() {
        throw new FileNotFoundException("文件没找到");
    }

    def bExcpeption() {
        throw new SQLException("SQL异常");

    }

}
