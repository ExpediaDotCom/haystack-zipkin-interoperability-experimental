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

import org.apache.commons.lang3.Validate;

import java.util.UUID;

public class HexCharTransformer {


    public static UUID hexCharToUUID(String value) throws IllegalArgumentException {

        Validate.notNull(value, "The given value cannot be null");

        long msb = 0l;
        long lsb;
        if (value.length() == 32) {
            msb = Long.parseUnsignedLong(value.substring(0, 16), 16);
            lsb = Long.parseUnsignedLong(value.substring(16, 32), 16);
        } else if (value.length() == 16) {
            lsb = Long.parseUnsignedLong(value.substring(0, 16), 16);
        } else {
            throw new IllegalArgumentException("Invalid length for hex char: " + value);
        }

        return new UUID(msb, lsb);

    }

}
