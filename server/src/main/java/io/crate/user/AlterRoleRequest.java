/*
 * Licensed to Crate.io GmbH ("Crate") under one or more contributor
 * license agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  Crate licenses
 * this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial agreement.
 */

package io.crate.user;

import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.jetbrains.annotations.Nullable;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;

import java.io.IOException;

public class AlterRoleRequest extends AcknowledgedRequest<AlterRoleRequest> {

    private final String roleName;
    private final SecureHash secureHash;

    public AlterRoleRequest(String roleName, @Nullable SecureHash secureHash) {
        this.roleName = roleName;
        this.secureHash = secureHash;
    }

    public String roleName() {
        return roleName;
    }

    @Nullable
    public SecureHash secureHash() {
        return secureHash;
    }

    public AlterRoleRequest(StreamInput in) throws IOException {
        super(in);
        roleName = in.readString();
        secureHash = in.readOptionalWriteable(SecureHash::readFrom);
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
        out.writeString(roleName);
        out.writeOptionalWriteable(secureHash);
    }
}
