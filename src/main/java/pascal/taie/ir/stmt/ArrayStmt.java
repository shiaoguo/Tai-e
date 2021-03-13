/*
 * Tai-e: A Program Analysis Framework for Java
 *
 * Copyright (C) 2020 Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020 Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * This software is designed for the "Static Program Analysis" course at
 * Nanjing University, and it supports a subset of Java features.
 * Tai-e is only for educational and academic purposes, and any form of
 * commercial use is disallowed.
 */

package pascal.taie.ir.stmt;

import pascal.taie.ir.exp.ArrayAccess;
import pascal.taie.ir.exp.LValue;
import pascal.taie.ir.exp.RValue;

abstract class ArrayStmt<L extends LValue, R extends RValue> extends AssignStmt<L, R> {

    ArrayStmt(L lvalue, R rvalue) {
        super(lvalue, rvalue);
    }

    public abstract ArrayAccess getArrayAccess();
}
