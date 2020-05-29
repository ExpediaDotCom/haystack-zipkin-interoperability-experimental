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

/**
 * UUID to HEX-Char Transformer. Can be used to transform UUID to hex-char encoding format
 */

public class UUIDTransformer {

    public static String uuidTo128BitHexCharEncoding(UUID id) {
        Validate.notNull(id, "The uuid cannot be null");
        Long msb = id.getMostSignificantBits();
        Long lsb = id.getLeastSignificantBits();
        return Long.toHexString(msb).concat(Long.toHexString(lsb));
    }


    public static String uuidTo64BitHexCharEncoding(UUID id) {
        Validate.notNull(id, "The uuid cannot be null");
        return Long.toHexString(id.getLeastSignificantBits());
    }

    public static String uuidTo128BitHexCharEncoding(String id) throws IllegalArgumentException {
        Validate.notNull(id, "The uuid cannot be null");
        return uuidTo128BitHexCharEncoding(UUID.fromString(id));
    }


    public static String uuidTo64BitHexCharEncoding(String id) throws IllegalArgumentException {
        Validate.notNull(id, "The uuid cannot be null");
        return uuidTo64BitHexCharEncoding(UUID.fromString(id));
    }

}
