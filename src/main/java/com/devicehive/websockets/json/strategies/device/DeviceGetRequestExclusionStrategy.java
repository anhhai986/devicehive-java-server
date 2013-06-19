package com.devicehive.websockets.json.strategies.device;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jkulagina
 * Date: 19.06.13
 * Time: 13:10
 */
public class DeviceGetRequestExclusionStrategy implements ExclusionStrategy {
    private static final Set<String> FIELDS_NAMES_TO_EXCLUDE;

    static {
        Set<String> initSet = new HashSet<>();
        initSet.add("status");
        initSet.add("device");
        FIELDS_NAMES_TO_EXCLUDE = initSet;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return FIELDS_NAMES_TO_EXCLUDE.contains(fieldAttributes.getName());
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}