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
 * Copyright 2015 ForgeRock AS.
 */

package org.forgerock.openam.rest;

import static org.forgerock.openam.audit.AuditConstants.Component.SCRIPT;

import org.forgerock.openam.rest.authz.AdminOnlyAuthzModule;
import org.forgerock.openam.rest.scripting.ScriptResource;

/**
 * A {@link RestRouteProvider} that add route for the scripting endpoint.
 *
 * @since 13.0.0
 */
public class ScriptingRestRouteProvider implements RestRouteProvider {

    @Override
    public void addRoutes(RestRouter rootRouter, RestRouter realmRouter) {

        realmRouter.route("scripts")
                .auditAs(SCRIPT)
                .authorizeWith(AdminOnlyAuthzModule.class)
                .toCollection(ScriptResource.class);
    }
}
