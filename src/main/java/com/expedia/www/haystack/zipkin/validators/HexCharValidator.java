/*
 * Copyright 2020 Expedia Group.
 *
 *        Licensed under the Apache License, Version 2.0 (the "License");
 *        you may not use this file except in compliance with the License.
 *        You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 *        Unless required by applicable law or agreed to in writing, software
 *        distributed under the License is distributed on an "AS IS" BASIS,
 *        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *        See the License for the specific language governing permissions and
 *        limitations under the License.
 */

package com.expedia.www.haystack.zipkin.validators;

import org.apache.commons.lang3.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to validate 128 / 64 bit HexChar value
 */
public class HexCharValidator {
    private static final String HEXCHAR_128_BIT_PATTERN = "([A-Fa-f0-9]{32})";
    private static final String HEXCHAR_64_BIT_PATTERN = "([A-Fa-f0-9]{16})";

    public static boolean isValid128BitHexChar(String hexChar) {
        Validate.notNull(hexChar, "The given value cannot be null");

        Pattern pattern = Pattern.compile(HEXCHAR_128_BIT_PATTERN);
        Matcher matcher = pattern.matcher(hexChar);
        return matcher.matches();
    }

    public static boolean isValid64BitHexChar(String value) {
        Validate.notNull(value, "The given value cannot be null");

        Pattern pattern = Pattern.compile(HEXCHAR_64_BIT_PATTERN);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
