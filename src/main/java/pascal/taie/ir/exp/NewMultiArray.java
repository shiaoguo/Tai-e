/*
 * Tai-e: A Static Analysis Framework for Java
 *
 * Copyright (C) 2020-- Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020-- Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * Tai-e is only for educational and academic purposes,
 * and any form of commercial use is disallowed.
 * Distribution of Tai-e is disallowed without the approval.
 */

package pascal.taie.ir.exp;

import pascal.taie.language.type.ArrayType;

import java.util.List;

/**
 * Representation of new multi-array expression, e.g., new T[..][..][..].
 */
public class NewMultiArray implements NewExp {

    private final ArrayType type;

    private final List<Var> lengths;

    public NewMultiArray(ArrayType type, List<Var> lengths) {
        this.type = type;
        this.lengths = List.copyOf(lengths);
    }

    @Override
    public ArrayType getType() {
        return type;
    }

    public int getLengthCount() {
        return lengths.size();
    }

    public Var getLength(int i) {
        return lengths.get(i);
    }

    public List<Var> getLengths() {
        return lengths;
    }

    @Override
    public List<RValue> getUses() {
        return List.copyOf(lengths);
    }

    @Override
    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("newmultiarray ");
        sb.append(type.getBaseType());
        lengths.forEach(length ->
                sb.append('[').append(length).append(']'));
        sb.append("[]".repeat(
                Math.max(0, type.getDimensions() - lengths.size())));
        return sb.toString();
    }
}
