package za.co.code.aoc.supplystacks.adapter.impl;

import za.co.code.aoc.supplystacks.adapter.Adapter;
import za.co.code.aoc.supplystacks.utitls.Utils;

import java.util.List;

public class RawToList implements Adapter<byte[], List<String>> {

    @Override
    public List<String> adapt(byte[] a) {
        return Utils.convertToList(new String(a));
    }
}
