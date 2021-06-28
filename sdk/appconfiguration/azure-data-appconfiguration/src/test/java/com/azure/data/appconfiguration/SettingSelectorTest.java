// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.data.appconfiguration;

import com.azure.data.appconfiguration.models.SettingFields;
import com.azure.data.appconfiguration.models.SettingSelector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingSelectorTest {

    @Test
    public void nullSettingSelectorFields() {
        final SettingSelector settingSelector = new SettingSelector();
        assertEquals(
            "SettingSelector(keyFilter=null, labelFilter=null, acceptDateTime=null, fields=ALL_FIELDS)",
            settingSelector.toString());
    }

    @Test
    public void toStringTest() {
        System.out.println("Classname " + SettingFields.class.getName());

        List<SettingFields> fieldList = new ArrayList<>();
        fieldList.add(SettingFields.ETAG);
        fieldList.add(SettingFields.CONTENT_TYPE);
        System.out.println("TST from LIST Printing fields in toString " + fieldList + "; " + fieldList.get(0) + " " + fieldList.get(1));

        SettingFields[] fields = new SettingFields[2];
        fields[0]= SettingFields.ETAG;
        fields[1] = SettingFields.CONTENT_TYPE;

        System.out.println("TST Printing fields in toString " + fields + "; " + fields[0] + " " + fields[1]);

        Arrays.stream(fields).forEach(field -> System.out.println("test fields F " + field));

        final SettingSelector settingSelector = new SettingSelector()
            .setFields(SettingFields.ETAG, SettingFields.CONTENT_TYPE);
        assertEquals(
            "SettingSelector(keyFilter=null, labelFilter=null, acceptDateTime=null, fields=etag,content_type)",
            settingSelector.toString());
    }
}
