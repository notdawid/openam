/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2013-2015 ForgeRock AS.
 */

package org.forgerock.openam.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A Builder class for creating json array objects.
 */
public class JsonArray {

    private final List<Object> list = new ArrayList<Object>();
    private final JsonObject jsonObject;
    private final String key;

    /**
     * Constructs a builder for creating json arrays.
     *
     * @param jsonObject The json object builder instance.
     * @param key The key this json array will be inserted into the json object against.
     */
    public JsonArray(JsonObject jsonObject, String key) {
        this.jsonObject = jsonObject;
        this.key = key;
    }

    /**
     * Adds an entry into the json array.
     *
     * @param value The value.
     * @return The json array builder.
     */
    public JsonArray add(Object value) {
        list.add(value);
        return this;
    }

    /**
     * Adds a final entry into the json array.
     *
     * @param value The value.
     * @return The parent json object builder.
     */
    public JsonObject addLast(Object value) {
        add(value);
        return build();
    }

    /**
     * Builds the json array and inserts it into its parent json object.
     *
     * @return The parent json object builder.
     */
    public JsonObject build() {
        jsonObject.put(key, list);
        return jsonObject;
    }

    /**
     * Gets the size of this json array.
     *
     * @return The size of the json array.
     */
    public int size() {
        return list.size();
    }
}
